/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Client;
import DAO.ClientDAO;
import DAO.Particulier;
import DAO.ParticulierDAO;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julien
 */
@Service
public class ClientServiceimpl implements ClientService{

    @Resource
    ClientDAO DAO; 

    @Override
    public void add(Client c) {
        this.DAO.save(new Client());
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
    
}
