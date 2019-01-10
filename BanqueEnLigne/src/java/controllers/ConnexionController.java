/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.Client;
import Service.ClientService;
import com.fasterxml.jackson.core.JsonGenerator;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Julien
 */
@Controller
public class ConnexionController {

    @Autowired
    ClientService p;

    @RequestMapping(value = "connexion", method = RequestMethod.GET)
    public String init() {
        return "connexion";
    }

    @RequestMapping(value = "connexion", method = RequestMethod.POST)
    public ResponseEntity<?> handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String identifient = request.getParameter("identifient");
        String password = request.getParameter("password");
        System.out.println(password + " - " + identifient);

        Client c = p.auth(identifient, password);
        if (c != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("client", c);
            session.setMaxInactiveInterval(60 * 30);
            String str = ToJSON.toJson(c);
            return new ResponseEntity(str, HttpStatus.OK);
        } else {
            return new ResponseEntity("[]", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "ok", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public JSONObject ok(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("controllers.ConnexionController.ok()");
        return new JSONObject().put("mot", "ok");
    }

    @RequestMapping(value = "deconnexion", method = RequestMethod.DELETE)
    public ResponseEntity<?> deconnexion(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        if (session != null) {
            try {
                session.invalidate();
                return new ResponseEntity("ok", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity("erreur", HttpStatus.OK);
            }
        }
        return new ResponseEntity("ok", HttpStatus.OK);
    }
}
