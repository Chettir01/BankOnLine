/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Service.ParticulierService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Julien
 */
@Controller
public class ConnexionParticulierController extends AbstractController {

    @Autowired
    ParticulierService Service;

    public ConnexionParticulierController() {
    }
@RequestMapping(value= "auth", method = RequestMethod.GET)
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        if (this.Service.auth("ok", "ok")) {
            System.out.println("good");
        } else {
            System.out.println("bad");

        }
        return new ModelAndView("index");
    }

}
