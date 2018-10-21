/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Service.ClientService;
import Service.ParticulierService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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
public class IndexController {
    
      @Autowired
    ClientService p;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String init() {
        return "index";
    }

    @RequestMapping(value = "index", method = RequestMethod.POST)
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv;
        String identifient = request.getParameter("identifient");
        String password = request.getParameter("password");
        if (password.equals("") || identifient.equals("")) {
            mv = new ModelAndView("index");
        } else {
            if (p.auth(identifient, password)==true) {
                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(5);
                session.setAttribute("login", identifient);
                mv = new ModelAndView("accueil");
                mv.addObject(identifient);
            } else {
                mv = new ModelAndView("index");
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
