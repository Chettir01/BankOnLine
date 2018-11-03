/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.Client;
import DAO.Compte;
import DAO.Conseiller;
import Service.CompteService;
import Service.ConseillerService;
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
            cps.update(c);
            mv = new ModelAndView("accueilconseiller");
            mv.addObject("listecompte", ((Conseiller) session.getAttribute("conseiller")).getListecompte());
            mv.addObject("listecomptenonvalide", cps.findNonvalide());
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
        mv = new ModelAndView("connexionconseiller");

        return mv;
    }
}
