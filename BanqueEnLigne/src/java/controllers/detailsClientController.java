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
    public ModelAndView init(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        ModelAndView mv;
        if (session != null) {
            mv = new ModelAndView("detailsclient");
            //On récupére l'id du client à partir de l'objet client stocké dans la session
            long id = ((Client) session.getAttribute("client")).getIDClient();
            Particulier p = ps.findById(id);
            //Si c'est un particulier on envoie toute les données concernant un particulier à la vue.
            if (p != null) {
                mv.addObject("login", p.getLogin());
                mv.addObject("mdp", p.getMdp());
                mv.addObject("adresse", p.getAdresse());
                mv.addObject("tel", p.getTel());
                mv.addObject("date", p.getDateNaissance());
                mv.addObject("prenom", p.getPrenom());
                mv.addObject("nom", p.getNom());
                mv.addObject("civilite", p.getCivilite());
                mv.addObject("type", "PARTICULIER");
            //Si c'est un professionel on envoie toute les données concernant un professionel à la vue.
            } else {
                Professionel pfs = pf.find(id);
                mv.addObject("login", pfs.getLogin());
                mv.addObject("mdp", pfs.getMdp());
                mv.addObject("adresse", pfs.getAdresse());
                mv.addObject("tel", pfs.getTel());
                mv.addObject("entreprise", pfs.getNomentreprise());
                mv.addObject("type", "PROFESSIONEL");
            }
        } else {
            mv = new ModelAndView("connexion");
        }

        return mv;
    }

    @RequestMapping(value = "detailsclient", method = RequestMethod.POST)
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("accueil");
        HttpSession session = request.getSession();
        Client c = (Client) session.getAttribute("client");
        //On vérifie si les champs minimaux sont renseignés
        if (!request.getParameter("login").equals("") && !request.getParameter("mdp").equals("")) {
            //On vérifie le type du client car cela définie l'affichage  du formulaire
            if (request.getParameter("type").equals("PARTICULIER")) {

                SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = formatter2.parse(request.getParameter("date"));
                java.sql.Date datesql = new java.sql.Date(date.getTime());
                ps.update(new Particulier(c.getIDClient(), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("civilite"), datesql, request.getParameter("login"), request.getParameter("mdp"), request.getParameter("adresse"), request.getParameter("tel")));

            } else if (request.getParameter("type").equals("PROFESSIONEL")) {
                pf.update(new Professionel(request.getParameter("entreprise"), c.getIDClient(), request.getParameter("login"), request.getParameter("mdp"), request.getParameter("adresse"), request.getParameter("tel")));
            }
        }
        return mv;
    }
}
