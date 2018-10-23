/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Service.ClientServiceimpl;
import Service.ParticulierService;
import java.util.ArrayList;
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
 * @author nada
 */
@Controller
public class AccueilController {
public AccueilController() {
    }
   @Autowired
   ClientServiceimpl clientService;
   
   
     @RequestMapping(value = "accueil", method = RequestMethod.POST)
     public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
          String identifient = request.getParameter("identifient");
          String password = request.getParameter("password");
        
        if (password.equals("") || identifient.equals("")) {
            ModelAndView mv = new ModelAndView("index");
            return mv;
        } 
        else {
            if (clientService.auth(identifient, password)==true) {
                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(5);
                session.setAttribute("login", identifient);
                ModelAndView mv = new ModelAndView("accueil");
                //mv.addObject(identifient);
                return mv;
            } else {
                ModelAndView mv = new ModelAndView("index");
                return mv;
            }
        }
     }
}
