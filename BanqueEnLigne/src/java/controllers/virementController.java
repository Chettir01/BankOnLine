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
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv;
        HttpSession session = request.getSession(false);
        if (!request.getParameter("IBAN").isEmpty() && !request.getParameter("Montant").isEmpty() && session != null) {
            Compte encaisseur = c.findByIBAN(request.getParameter("IBAN"));
            int montant = Integer.parseInt(request.getParameter("Montant"));
            Compte debiteur = (Compte) session.getAttribute("compte");
            if (encaisseur != null && montant > 0) {
                if (debiteur.getSolde() >= montant) {
                    encaisseur.setSolde(encaisseur.getSolde() + montant);
                    debiteur.setSolde(debiteur.getSolde() - montant);
                    c.update(debiteur);
                    c.update(encaisseur);
                    v.add(encaisseur, (Compte) session.getAttribute("compte"), Float.parseFloat(request.getParameter("Montant")));
                    mv = new ModelAndView("redirect:/detailscompte.htm");
                } else {
                    mv = new ModelAndView("virement");
                }
            } else {
                mv = new ModelAndView("virement");
            }

        } else {
            mv = new ModelAndView("connexion");
        }
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        return mv;
    }
}
