/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.Client;
import DAO.Compte;
import Service.CompteService;
import Service.OrdreBourseService;
import Service.VirementService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Julien
 */
@Controller
public class detailsCompteController {

    @Autowired
    OrdreBourseService o;
    @Autowired
    VirementService v;
    @Autowired
    CompteService c;

    @RequestMapping(value = "detailscompte", method = RequestMethod.GET)
    public ResponseEntity<?> init(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
           String str;
        if (session == null) {
            return new ResponseEntity("[]", HttpStatus.OK);
        } else {

            long id;
            Compte compte = null;
            System.err.println("Compte  : "+request.getParameter("compte"));
            id = Long.parseLong(request.getParameter("compte"));
            compte = c.findById(id);

            List<Object> liste = new ArrayList<Object>();
         
            liste.add(v.findByCompte(compte));
            liste.add(o.findByCompte(compte));
            liste.add(compte);
            str = ToJSON.toJson(liste);
            System.out.println(str);
            session.setAttribute("compte", compte);
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            //
            //Cherche liste compte

        }
        return new ResponseEntity(str, HttpStatus.OK);
    }
    /*
    @RequestMapping(value = "detailscompte", method = RequestMethod.POST)
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        return mv;
    }*/
}
