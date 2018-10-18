/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author nada
 */
@Controller
public class connexionClient  {
    
    public connexionClient() {
    }
    public String init(){
     return "clientCon";
    }
     public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("accueilClient");
        String identifient = request.getParameter("identifient");
        String identif = "Bonjour " + identifient +", sur votre compte.";
        mv.addObject(identif);
        return mv;
    } 
    
}
