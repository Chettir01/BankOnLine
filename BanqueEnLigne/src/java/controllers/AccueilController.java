/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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


    
    @RequestMapping(value = "accueil", method = RequestMethod.GET)
    public String init(HttpServletRequest request, HttpServletResponse response) {
        return "accueil";
    }
    
    @RequestMapping(value="accueil", method=RequestMethod.POST)
     public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("accueil");
        return mv;
    } 
}
