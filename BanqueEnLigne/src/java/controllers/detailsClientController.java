/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.Client;
import DAO.Particulier;
import DAO.Professionel;
import Service.ParticulierService;
import Service.ProfessionelService;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Julien
 */
@Controller
public class detailsClientController {

    @Autowired
    ParticulierService ps;
    @Autowired
    ProfessionelService pf;

    @RequestMapping(value = "detailsclient", method = RequestMethod.GET)
    public ResponseEntity<?> init(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        ResponseEntity<?> resp;
        if (session != null) {
            //On récupére l'id du client à partir de l'objet client stocké dans la session
            long id = ((Client) session.getAttribute("client")).getIDClient();
            Particulier p = ps.findById(id);
            //Si c'est un particulier on envoie toute les données concernant un particulier à la vue.
            String str;
            if (p != null) {
                str = ToJSON.toJson(p);
                resp = new ResponseEntity(str, HttpStatus.OK);
                //Si c'est un professionel on envoie toute les données concernant un professionel à la vue.
            } else {
                Professionel pfs = pf.find(id);
                str = ToJSON.toJson(pfs);
                resp = new ResponseEntity(str, HttpStatus.OK);
            }
        } else {
            resp = new ResponseEntity(HttpStatus.GATEWAY_TIMEOUT);
        }

        return resp;
    }

    @RequestMapping(value = "detailsclient", method = RequestMethod.POST)
    public ResponseEntity<?> handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String str = "[]";
        HttpSession session = request.getSession();
        Client c = (Client) session.getAttribute("client");
        //On vérifie si les champs minimaux sont renseignés
        if (!request.getParameter("login").equals("") && !request.getParameter("mdp").equals("")) {
            //On vérifie le type du client car cela définie l'affichage  du formulaire
            if (request.getParameter("type").equals("PARTICULIER")) {

                SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("Nouvelle date : " + request.getParameter("date"));
                java.util.Date date = formatter2.parse(request.getParameter("date"));
                java.sql.Date datesql = new java.sql.Date(date.getTime());
                ps.update(new Particulier(c.getIDClient(), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("civilite"), datesql, request.getParameter("login"), request.getParameter("mdp"), request.getParameter("adresse"), request.getParameter("tel")));
                str = ToJSON.toJson(ps.findById(c.getIDClient()));
            } else if (request.getParameter("type").equals("PROFESSIONEL")) {
                pf.update(new Professionel(request.getParameter("entreprise"), c.getIDClient(), request.getParameter("login"), request.getParameter("mdp"), request.getParameter("adresse"), request.getParameter("tel")));
                str = ToJSON.toJson(pf.find(c.getIDClient()));
            }
            return new ResponseEntity(str, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.PARTIAL_CONTENT);
    }
}
