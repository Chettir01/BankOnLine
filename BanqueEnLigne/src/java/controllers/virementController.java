/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.Compte;
import Service.ClientService;
import Service.CompteService;
import Service.VirementService;
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
public class virementController {

    @Autowired
    VirementService v;
    @Autowired
    CompteService c;

    @RequestMapping(value = "virement", method = RequestMethod.GET)
    public String init() {
        return "virement";
    }

    @RequestMapping(value = "virement", method = RequestMethod.POST)
    public ResponseEntity<?> handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResponseEntity<?> rep;
        HttpSession session = request.getSession(false);
        if (session != null) {
            //Je vérifie que les champs de saisie nécessaire ne sont pas vides
            if (!request.getParameter("IBAN").isEmpty() && !request.getParameter("Montant").isEmpty()) {
                //On cherche le compte avec l'iban qui a été renseigné
                Compte encaisseur = c.findByIBAN(request.getParameter("IBAN"));
                float montant = Float.parseFloat(request.getParameter("Montant"));
                System.out.println("Compte : "+request.getParameter("compte"));
                Compte debiteur = (Compte) c.findById(Long.parseLong(request.getParameter("compte")));
                //On vérifie si l'iban correspond à un compte existant et si le montant n'est pas nul
                if (encaisseur != null && montant > 0.0) {
                    //Les découverts ne sont pas autorisé dans la baqnue donc on vérifie si le solde du compte est supérieur au montant
                    if (debiteur.getSolde() >= montant) {
                        if (encaisseur.getID_compte() != debiteur.getID_compte()) {
                            encaisseur.setSolde(encaisseur.getSolde() + montant);
                            debiteur.setSolde(debiteur.getSolde() - montant);
                            c.update(debiteur);
                            c.update(encaisseur);
                            v.add(encaisseur, (Compte) session.getAttribute("compte"), Float.parseFloat(request.getParameter("Montant")));

                            rep = new ResponseEntity("[ok]", HttpStatus.OK);
                        } else {
                            rep = new ResponseEntity("[]", HttpStatus.NOT_FOUND);
                        }
                    } else {
                        rep = new ResponseEntity("[]", HttpStatus.NOT_FOUND);
                    }

                } else {
                    rep = new ResponseEntity("[encaisseur pas ok]", HttpStatus.NOT_FOUND);
                }

            } else {
                rep = new ResponseEntity("[]", HttpStatus.NOT_FOUND);
            }
        } else {
            rep = new ResponseEntity("[SESSION OUT]", HttpStatus.GATEWAY_TIMEOUT);
        }
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        return rep;
    }
}
