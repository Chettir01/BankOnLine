/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Particulier;
import DAO.ParticulierDAO;
import DAO.Professionel;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julien
 */
@Service
public class ParticulierServiceImpl implements ParticulierService {
    
    @Resource
    ParticulierDAO DAO; 

    @Override
    public void add(String nom, String prenom) {
        this.DAO.save(new Particulier(nom,prenom));
    }

    @Override
    public void remove(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNomsMessages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean auth(String login, String mdp) {
        return this.DAO.authentification(login, mdp);
    }

    @Override
    public Particulier findById(long id) {
       return DAO.find(id);
    }

    @Override
    public void update(Particulier h) {
        DAO.update(h);
    }
    
}
