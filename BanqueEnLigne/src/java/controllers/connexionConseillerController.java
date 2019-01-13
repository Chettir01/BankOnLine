/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.Client;
import DAO.Compte;
import DAO.Conseiller;
import DAO.TypeCompte;
import DAO.Virement;
import Service.CompteService;
import Service.ConseillerService;
import Service.VirementService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Julien
 */
@Controller
public class connexionConseillerController {

    @Autowired
    ConseillerService cs;
    @Autowired
    CompteService cps;
    @Autowired
    VirementService vs;

    @RequestMapping(value = "connexionconseiller", method = RequestMethod.GET)
    public String init() {
        return "connexionconseiller";
    }

    @RequestMapping(value = "authconseiller", method = RequestMethod.GET)
    public ResponseEntity<?> handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResponseEntity<?> resp;
        //Je vérifie si le login et le mot de passe sont déjà renseigné et  si ce n'est pas le cas l'utilisateur est redirigé vers la page de connexion
        if (request.getParameter("identifient").equals("") || request.getParameter("password").equals("")) {
            resp = new ResponseEntity(HttpStatus.PARTIAL_CONTENT);
        } else {
            //On récupére le conseiller avec l'identifiant et le mot de passe correspondant
            Conseiller c = cs.auth(request.getParameter("identifient"), request.getParameter("password"));
            if (c != null) {
                //Si le conseiller existe on crée une session et on stocke un objet conseiller dans la session
                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(60 * 30);
                c.setListecompte(cps.findByConseiller(c));
                session.setAttribute("conseiller", c);
                List<Object> liste = new ArrayList<Object>();
                //On charge les différentes liste de compte nécessaire 
                liste.add(c.getListecompte());
                liste.add(cps.findNonvalide());
                liste.add(cps.findAll());
                resp = new ResponseEntity(ToJSON.toJson(liste), HttpStatus.OK);
            } else {
                resp = new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }
        return resp;
    }

    @RequestMapping(value = "validationcompte", method = RequestMethod.POST)
    public ResponseEntity<?> validationcompte(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResponseEntity<?> resp;

        HttpSession session = request.getSession(false);
        if (session != null) {
            //On charge le compte correspondant à l'id et on modifie la valeur du booléen
            Compte c = cps.findById(Integer.parseInt(request.getParameter("id")));
            c.setValide(true);
            //On attribue le compte au conseiller d'une maniére définitive
            Conseiller cl = (Conseiller) session.getAttribute("conseiller");
            c.setConseillercompte(cl);
            //On update le compte
            cps.update(c);
            List<Object> liste = new ArrayList<Object>();
            liste.add(cps.findByConseiller((Conseiller) session.getAttribute("conseiller")));
            liste.add(cps.findNonvalide());
            liste.add(cps.findAll());
            resp = new ResponseEntity(ToJSON.toJson(liste), HttpStatus.OK);
        } else {
            resp = new ResponseEntity(HttpStatus.GATEWAY_TIMEOUT);
        }

        return resp;
    }

    @RequestMapping(value = "agios", method = RequestMethod.POST)
    public ResponseEntity<?> agios(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResponseEntity<?> resp;

        HttpSession session = request.getSession(false);
        if (session != null) {
            //On vérifie si le compte qui permet de gérer les frais banquaire de la banque existe déjà
            Compte c = cps.findByIBAN("AGIOSBANQUE");
            if (c == null) {
                //Si le compte pour gérer les frais banquaire n'existe pas dans la base de données alors on le crée
                cps.add(new Compte(1000000, "AGIOSBANQUE", new TypeCompte("Banque gestion", 0, false)));
                c = cps.findByIBAN("AGIOSBANQUE");
            }
            //On parcoure tous les comptes de la banque pour prélever ou ajouter des sommes d'argent sur ces comptes
            List<Compte> listecompte = cps.findAll();
            for (int i = 0; i < listecompte.size(); i++) {
                //On n'applique pas les prélévement au compte de gestion
                if (listecompte.get(i).getID_compte() != c.getID_compte()) {
                    //Le compte doit être valide (non cloturé) pour qu'un prélévement puisse être effectué
                    if (listecompte.get(i).isValide()) {
                        Virement v;
                        float somme;
                        //Si le compte n'a pas de taux d'intêret et donne la possibilité d'effectuer des transactions banquaire (chéquier, carte de crédit) on préléve 2%
                        if (listecompte.get(i).getType().getTaux() > 0.0 && listecompte.get(i).getType().isTransaction() == false) {
                            somme = (float) (listecompte.get(i).getSolde() * ((float) listecompte.get(i).getType().getTaux() / 100));
                            v = new Virement(listecompte.get(i), c, somme);
                            listecompte.get(i).setSolde(listecompte.get(i).getSolde() + somme);
                            c.setSolde(c.getSolde() - somme);
                            //Si le compte posséde un taux d'intêret on augmente la solde du compte proportionnellement au taux d'intérets
                        } else {
                            somme = (float) (listecompte.get(i).getSolde() * 0.02);
                            v = new Virement(c, listecompte.get(i), somme);
                            listecompte.get(i).setSolde(listecompte.get(i).getSolde() - somme);
                            c.setSolde(c.getSolde() + somme);
                        }
                        cps.update(c);
                        cps.update(listecompte.get(i));
                        vs.add(v);
                    }

                }
            }
            //On met à jour les différentes liste de compte affichés sur la page
            List<Object> liste = new ArrayList<Object>();
            liste.add(cps.findByConseiller((Conseiller) session.getAttribute("conseiller")));
            liste.add(cps.findNonvalide());
            liste.add(cps.findAll());
            resp = new ResponseEntity(ToJSON.toJson(liste), HttpStatus.OK);
        } else {
            resp = new ResponseEntity(HttpStatus.GATEWAY_TIMEOUT);
        }

        return resp;
    }

    @RequestMapping(value = "cloturecompte", method = RequestMethod.POST)
    public ResponseEntity<?> cloturecompte(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResponseEntity<?> resp;

        HttpSession session = request.getSession(false);
        if (session != null) {
            //On cherche le compte dans la base de données à partir de son id et on modifie la valeur du booléen "valide"
            Compte c = cps.findById(Integer.parseInt(request.getParameter("id")));
            c.setValide(false);
            cps.update(c);
            List<Object> liste = new ArrayList<Object>();
            liste.add(cps.findByConseiller((Conseiller) session.getAttribute("conseiller")));
            liste.add(cps.findNonvalide());
            liste.add(cps.findAll());
            resp = new ResponseEntity(ToJSON.toJson(liste), HttpStatus.OK);
        } else {
            resp = new ResponseEntity(HttpStatus.GATEWAY_TIMEOUT);
        }

        return resp;
    }

    @RequestMapping(value = "deconnexionconseiller", method = RequestMethod.GET)
    public ResponseEntity<?> deconnexion(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResponseEntity<?> resp;

        HttpSession session = request.getSession(false);
        if (session != null) {
            try {
                session.invalidate();
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity(HttpStatus.CONFLICT);
            }
        }
        if (session == null || !request.isRequestedSessionIdValid()) {
            resp = new ResponseEntity(HttpStatus.OK);
        } else {
            resp = new ResponseEntity(HttpStatus.CONFLICT);
        }

        return resp;
    }
}
