/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.Client;
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
    
    @RequestMapping(value = "connexionconseiller", method = RequestMethod.GET)
    public String init() {
        return "connexionconseiller";
    }

    @RequestMapping(value = "authconseiller", method = RequestMethod.GET)
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv=new ModelAndView("connexionconseiller");
        
      /*  String identifient = request.getParameter("identifient");
        String password = request.getParameter("password");
        if (password.equals("") || identifient.equals("")) {
            mv = new ModelAndView("connexion");
        } else {
            Client cs=p.auth(identifient, password);
            if (c!=null) {
                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(60*30);
                session.setAttribute("client", c);
                mv = new ModelAndView("accueil");
            } else {
                mv = new ModelAndView("connexion");
            }
        }

        /*if(session!=null){
                if (identifient!=null && identifient.length()>0)
                    page ="accueilClient";
                else
                    page = "index";
            }*/
      
        return mv;
    }
}
