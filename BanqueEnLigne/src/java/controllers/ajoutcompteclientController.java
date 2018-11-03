/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.Client;
import DAO.Compte;
import DAO.Particulier;
import DAO.Professionel;
import Service.ClientService;
import Service.CompteService;
import Service.ParticulierService;
import Service.ProfessionelService;
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
public class ajoutcompteclientController {

    @Autowired
    ClientService cs;

    @Autowired
    CompteService cpts;

    @Autowired
    ProfessionelService pfs;

    @Autowired
    ParticulierService par;

    @RequestMapping(value = "ajoutcompteclient", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv;
        HttpSession session = request.getSession(false);
        if (session == null) {
            mv = new ModelAndView("index");
        } else {
            mv = new ModelAndView("ajoutcompteclient");
            mv.addObject("compte", request.getParameter("compte"));
        }
        return mv;
    }

    @RequestMapping(value = "ajoutcompteclient", method = RequestMethod.POST)
    public ModelAndView creation(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv;
        HttpSession session = request.getSession(false);
        if (session == null) {
            mv = new ModelAndView("index");
        } else {
            if (!request.getParameter("login").equals("")) {
                Particulier p = par.findBylogin(request.getParameter("login"));
                Compte cpt = cpts.findById(Integer.parseInt(request.getParameter("compte")));
                if (p != null) {
                    cpt.getListeclientcompte().add(p);
                    p.getListecompte().add(cpt);
                    par.update(p);
                    cpts.update(cpt);
                    mv = new ModelAndView("accueil");
                } else {
                    Professionel pro = pfs.findByLogin(request.getParameter("login"));
                    if (pro != null) {
                        System.err.println("ok pro");
                        cpt.getListeclientcompte().add(pro);
                        pro.getListecompte().add(cpt);
                        pfs.update(pro);
                        cpts.update(cpt);
                        mv = new ModelAndView("accueil");
                    } else {
                        mv = new ModelAndView("ajoutcompteclient");
                        mv.addObject("compte", request.getParameter("compte"));
                    }
                }
            } else {
                mv = new ModelAndView("ajoutcompteclient");
                mv.addObject("compte", request.getParameter("compte"));
            }

        }
        return mv;
    }
}
