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
public class AccueilClientController {

    @Autowired
    ParticulierService p;

    @RequestMapping(value = "accueilClient", method = RequestMethod.GET)
    public String init() {
        return "accueilClient";
    }

    @RequestMapping(value = "accueilClient", method = RequestMethod.POST)
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv;
        String identifient = request.getParameter("identifient");
        String password = request.getParameter("password");
        if (password.equals("") || identifient.equals("")) {
            mv = new ModelAndView("conClient");
        } else {
            if (p.auth(identifient, password)) {
                HttpSession session = request.getSession(true);
                mv = new ModelAndView("accueilClient");
            } else {
                mv = new ModelAndView("conClient");
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
