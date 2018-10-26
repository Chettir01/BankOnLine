/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.naming.spi.DirStateFactory;
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
public class inscriptionOnSuccesParticulier {
    
    public inscriptionOnSuccesParticulier() {
    }
    @RequestMapping(value = "inscriptionOnSuccesParticulier", method = RequestMethod.GET)
     public String init ()throws Exception {
       
         return "inscriptionOnSucces";
     }
    
    @RequestMapping(value = "inscriptionOnSuccesParticulier", method = RequestMethod.POST)
     public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
         
         //appeler le serice des client et des comptes
         //appeler la methode qui permet d'ajouter un nouveau client
         //appeler la methode qui permet d'ajouter un nouveau compte
       String nom = request.getParameter("nom")+" "+request.getParameter("pernom");
       
         ModelAndView mv = new ModelAndView("inscriptionOnSucces");
         
         mv.addObject("nom", nom);
         return mv;
     }
}
