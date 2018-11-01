/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;


/**
 *
 * @author Julien
 */
@Controller
public class choixclientController {
     @RequestMapping(value = "choixclient", method = RequestMethod.GET)
    public ModelAndView init() {
        return new ModelAndView("choixclient");
    }
}
