/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Client;
import DAO.Compte;
import DAO.Conseiller;
import DAO.ConseillerDAO;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julien
 */
@Service
public class ConseillerServiceImpl implements ConseillerService {
    @Resource
    ConseillerDAO DAO;

    @Override
    public void add(Conseiller c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conseiller auth(String login, String mdp) {
        return DAO.authentification(login, mdp);
    }

    @Override
    public String getNomsMessages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
