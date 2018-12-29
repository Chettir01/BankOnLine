/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.Client;
import Service.ClientService;

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
        JSONObject jObj = Mapper.requestToJSONObj(request);
        String identifient = jObj.getString("identifient");
        String password = jObj.getString("password");
        Client c = p.auth(identifient, password);
        if (c != null) {
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(60 * 30);
            session.setAttribute("client", c);
            return new ResponseEntity(c, HttpStatus.OK);
        } else {
            return new ResponseEntity("[]", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "ok", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public JSONObject ok(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("controllers.ConnexionController.ok()");
        return new JSONObject().put("mot", "ok");
    }

    @RequestMapping(value = "deconnexion", method = RequestMethod.GET)
    public ModelAndView deconnexion(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv;

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        mv = new ModelAndView("index");

        return mv;
    }
}
