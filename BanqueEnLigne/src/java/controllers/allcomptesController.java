/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.Client;
import DAO.Compte;
import Service.ClientService;
import Service.CompteService;
import Service.TypeCompteService;
import java.util.ArrayList;
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
public class allcomptesController {

    @Autowired
    CompteService c;
    @Autowired
    TypeCompteService ts;

    @RequestMapping(value = "allcomptes", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv;
        HttpSession session = request.getSession(false);
        if (session == null) {
            mv = new ModelAndView("index");
        } else {
            mv = new ModelAndView("allcomptes");
           // mv.addObject("listecompte", c.findByClient((Client) session.getAttribute("client")));
            mv.addObject("listecompte",c.findByClient((Client) session.getAttribute("client")));
            mv.addObject("listetypecompte",ts.findAll());
            //
            //Cherche liste compte

        }
        return mv;
    }

    @RequestMapping(value = "allcomptes", method = RequestMethod.POST)
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        return mv;
    }
}
