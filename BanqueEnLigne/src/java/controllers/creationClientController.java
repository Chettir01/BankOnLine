/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.Client;
import DAO.Particulier;
import DAO.Professionel;
import Service.ParticulierService;
import Service.ProfessionelService;
import java.text.SimpleDateFormat;
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
public class creationClientController {

    @Autowired
    ParticulierService ps;
    @Autowired
    ProfessionelService pf;

    @RequestMapping(value = "creationclientparticulier", method = RequestMethod.GET)
    public ModelAndView initpar(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("creationclient");
        String type ="PARTICULIER";
        mv.addObject("type", type);
        return mv;
    }
    
        @RequestMapping(value = "creationclientprofessionel", method = RequestMethod.GET)
    public ModelAndView initpro(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("creationclient");
        String type ="PROFESSIONEL";
        mv.addObject("type", type);
        return mv;
    }

    @RequestMapping(value = "creationclient", method = RequestMethod.POST)
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("accueil");
        HttpSession session = request.getSession();
        Client c = (Client) session.getAttribute("client");
        if (!request.getParameter("login").equals("") && !request.getParameter("mdp").equals("")) {
            if (request.getParameter("type").equals("PARTICULIER")) {

                SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = formatter2.parse(request.getParameter("date"));
                java.sql.Date datesql = new java.sql.Date(date.getTime());
                ps.update(new Particulier(c.getIDClient(), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("civilite"), datesql, request.getParameter("login"), request.getParameter("mdp"), request.getParameter("adresse"), request.getParameter("tel")));

            } else if (request.getParameter("type").equals("PROFESSIONEL")) {
                pf.update(new Professionel(request.getParameter("entreprise"), c.getIDClient(), request.getParameter("login"), request.getParameter("mdp"), request.getParameter("adresse"), request.getParameter("tel")));
            }
        }
        return mv;
    }
}
