/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.Bourse;
import DAO.Client;
import DAO.Compte;
import DAO.OrdreBourse;
import Service.BourseService;
import Service.CompteService;
import Service.OrdreBourseService;
import Service.TypeCompteService;
import Service.TypeOrdreService;
import Service.VirementService;
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
public class creationOrdreBourseController {

    @Autowired
    OrdreBourseService o;
    @Autowired
    TypeOrdreService t;
    @Autowired
    BourseService b;
    @Autowired
    CompteService c;

    @RequestMapping(value = "ordrebourse", method = RequestMethod.GET)
    public ModelAndView init() {
        ModelAndView mv = new ModelAndView("creationordrebourse");
        mv.addObject("listetypecompte", t.findAll());
        mv.addObject("listebourse", b.findAll());
        return mv;
    }

    @RequestMapping(value = "ordrebourse", method = RequestMethod.POST)
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv;
        HttpSession session = request.getSession(false);
        if (!request.getParameter("bourse").isEmpty() && !request.getParameter("type").isEmpty() && !request.getParameter("quantite").isEmpty() && session != null) {

            Compte compte = c.findById(((Compte) session.getAttribute("compte")).getID_compte());
            if (compte != null) {
                Bourse bo = b.findById(Integer.parseInt(request.getParameter("bourse")));
                float somme = bo.getPrix() * Integer.parseInt(request.getParameter("quantite"));
                System.out.println("Somme : "+somme);
                if (compte.getSolde() >= somme) {
                    this.o.add(new OrdreBourse(Integer.parseInt(request.getParameter("quantite")), bo.getDatelimite(), bo.getPrix(), (Compte) session.getAttribute("compte"), bo, t.findById(Long.parseLong(request.getParameter("type"))
                    )));
                    compte.setSolde(compte.getSolde() - somme);
                    c.update(compte);
                    mv = new ModelAndView("redirect:/detailscompte.htm");
                } else {
                    mv = new ModelAndView("redirect:/ordrebourse.htm");
                }
            } else {
                mv = new ModelAndView("redirect:/ordrebourse.htm");
            }

        } else {
            mv = new ModelAndView("redirect:/ordrebourse.htm");
        }
        return mv;
    }
}
