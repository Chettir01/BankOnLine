/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.Client;
import DAO.Compte;
import DAO.Particulier;
import DAO.Professionel;
import Service.ClientService;
import Service.CompteService;
import Service.ParticulierService;
import Service.ProfessionelService;
import Service.TypeCompteService;
import java.text.SimpleDateFormat;
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
 * @author Julien
 */
@Controller
public class creationcompteController {

    @Autowired
    CompteService cs;
    @Autowired
    TypeCompteService ts;
    @Autowired
    ParticulierService ps;
    @Autowired
    ProfessionelService pfs;

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    @RequestMapping(value = "creationcompte", method = RequestMethod.GET)
    public ModelAndView init() {
        ModelAndView mv = new ModelAndView("creationcompte");
        mv.addObject("listetypecompte", ts.findAll());
        return mv;
    }
    
    

    @RequestMapping(value = "creationcompte", method = RequestMethod.POST)
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv;
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (!request.getParameter("type").equals("")) {
                //génération aléatoire de l'IBAN
                StringBuilder builder = new StringBuilder();
                int count = 5;
                while (count-- != 0) {
                    int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
                    builder.append(ALPHA_NUMERIC_STRING.charAt(character));
                }
                //Enregistrement du compte
                Compte c = new Compte(1000, builder.toString(), ts.find(Integer.parseInt(request.getParameter("type"))));
                long id=((Client) session.getAttribute("client")).getIDClient();
                Particulier p = ps.findById(id);
                if (p != null) {
                    p.getListecompte().add(c);
                    c.getListeclientcompte().add(p);
                    ps.update(p);
                }else{
                    Professionel pf=pfs.find(id);
                    pf.getListecompte().add(c);
                    c.getListeclientcompte().add(pf);
                    pfs.update(pf);
                }

                //c.getListeclientcompte().add(ct);
                //cs.add(c);
                mv = new ModelAndView("accueil");
            } else {
                mv = new ModelAndView("creationcompte");
                mv.addObject("listetypecompte", ts.findAll());
            }
        } else {
            mv = new ModelAndView("index");
        }

        return mv;
    }
}
