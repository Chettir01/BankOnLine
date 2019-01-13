/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.Client;
import DAO.Particulier;
import DAO.Professionel;
import Service.ClientService;
import Service.ParticulierService;
import Service.ProfessionelService;
import java.text.SimpleDateFormat;
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
public class creationClientController {

    @Autowired
    ParticulierService ps;
    @Autowired
    ProfessionelService pfs;
    @Autowired
    ClientService cs;

    @RequestMapping(value = "creationclientparticulier", method = RequestMethod.GET)
    public ModelAndView initpar(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("creationclient");
        String type = "PARTICULIER";
        mv.addObject("type", type);
        return mv;
    }

    @RequestMapping(value = "creationclientprofessionel", method = RequestMethod.GET)
    public ModelAndView initpro(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("creationclient");
        String type = "PROFESSIONEL";
        mv.addObject("type", type);
        return mv;
    }

    @RequestMapping(value = "creationclient", method = RequestMethod.POST)
    public ResponseEntity<?> handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //Je vérifie si les champs minimaux sont renseigné
        if (!request.getParameter("login").equals("") && !request.getParameter("mdp").equals("")) {
            //Je vérifie si le login n'est pas déjà utilisé par un autre utilisateur
            if (!cs.findByLogin(request.getParameter("login"))) {
                //On vérifie le type que désire le client
                if (request.getParameter("type").equals("PARTICULIER")) {
                    SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date date = formatter2.parse(request.getParameter("date"));
                    java.sql.Date datesql = new java.sql.Date(date.getTime());
                    Particulier p = new Particulier(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("civilite"), datesql, request.getParameter("login"), request.getParameter("mdp"), request.getParameter("adresse"), request.getParameter("tel"));
                    ps.add(p);
                } else {
                    Professionel pf = new Professionel(request.getParameter("entreprise"), request.getParameter("login"), request.getParameter("mdp"), request.getParameter("adresse"), request.getParameter("tel"));
                    pfs.add(pf);
                }

                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(60 * 30);
                session.setAttribute("client", cs.auth(request.getParameter("login"), request.getParameter("mdp")));

                return new ResponseEntity(ToJSON.toJson(cs.find(request.getParameter("login"))), HttpStatus.OK);
            }
        }

        return new ResponseEntity(HttpStatus.PARTIAL_CONTENT);

    }
}
