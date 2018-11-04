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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv;

        if (request.getParameter("identifient").equals("") && request.getParameter("password").equals("")) {
            mv = new ModelAndView("connexionconseiller");
        } else {
            Conseiller c = cs.auth(request.getParameter("identifient"), request.getParameter("password"));
            if (c != null) {
                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(60 * 30);
                c.setListecompte(cps.findByConseiller(c));
                session.setAttribute("conseiller", c);
                mv = new ModelAndView("accueilconseiller");
                mv.addObject("listecompte", c.getListecompte());
                mv.addObject("listecomptenonvalide", cps.findNonvalide());
                mv.addObject("toutcompte", cps.findAll());
            } else {
                mv = new ModelAndView("connexionconseiller");
            }
        }
        return mv;
    }

    @RequestMapping(value = "validationcompte", method = RequestMethod.POST)
    public ModelAndView validationcompte(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv;

        HttpSession session = request.getSession(false);
        if (session != null) {
            Compte c = cps.findById(Integer.parseInt(request.getParameter("id")));
            c.setValide(true);
            Conseiller cl = (Conseiller) session.getAttribute("conseiller");
            c.setConseillercompte(cl);
            cps.update(c);
            mv = new ModelAndView("accueilconseiller");
            mv.addObject("listecompte", cps.findByConseiller((Conseiller) session.getAttribute("conseiller")));
            mv.addObject("listecomptenonvalide", cps.findNonvalide());
            mv.addObject("toutcompte", cps.findAll());
        } else {
            mv = new ModelAndView("connexionconseiller");
        }

        return mv;
    }

    @RequestMapping(value = "agios", method = RequestMethod.POST)
    public ModelAndView agios(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv;

        HttpSession session = request.getSession(false);
        if (session != null) {
            Compte c = cps.findByIBAN("AGIOSBANQUE");
            if (c == null) {
                cps.add(new Compte(1000000, "AGIOSBANQUE", new TypeCompte("Banque gestion", 0,false)));
                c = cps.findByIBAN("AGIOSBANQUE");
            }
            List<Compte> listecompte = cps.findAll();
            for (int i = 0; i < listecompte.size(); i++) {
                if (listecompte.get(i).getID_compte() != c.getID_compte()) {
                    if (listecompte.get(i).isValide()) {
                        Virement v;
                        float somme;
                        if (listecompte.get(i).getType().getTaux() > 0.0 && listecompte.get(i).getType().isTransaction()==false) {
                            somme = (float) (listecompte.get(i).getSolde() * ((float)listecompte.get(i).getType().getTaux() / 100));
                            v = new Virement(listecompte.get(i), c, somme);
                            listecompte.get(i).setSolde(listecompte.get(i).getSolde() + somme);
                            c.setSolde(c.getSolde() - somme);

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

            mv = new ModelAndView("accueilconseiller");
            mv.addObject("listecompte", cps.findByConseiller((Conseiller) session.getAttribute("conseiller")));
            mv.addObject("listecomptenonvalide", cps.findNonvalide());
            mv.addObject("toutcompte", cps.findAll());
        } else {
            mv = new ModelAndView("index");
        }

        return mv;
    }

    @RequestMapping(value = "cloturecompte", method = RequestMethod.POST)
    public ModelAndView cloturecompte(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv;

        HttpSession session = request.getSession(false);
        if (session != null) {
            Compte c = cps.findById(Integer.parseInt(request.getParameter("id")));
            c.setValide(false);
            cps.update(c);
            mv = new ModelAndView("accueilconseiller");
            mv.addObject("listecompte", cps.findByConseiller((Conseiller) session.getAttribute("conseiller")));
            mv.addObject("listecomptenonvalide", cps.findNonvalide());
            mv.addObject("toutcompte", cps.findAll());
        } else {
            mv = new ModelAndView("connexionconseiller");
        }

        return mv;
    }

    @RequestMapping(value = "deconnexionconseiller", method = RequestMethod.GET)
    public ModelAndView deconnexion(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv;

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        mv = new ModelAndView("index");

        return mv;
    }
}
