/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Client;
import DAO.Compte;
import DAO.CompteDAO;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julien
 */
@Service
public class CompteServiceImpl implements CompteService {

    @Resource
    CompteDAO DAO;
    
    @Override
    public void add(Compte c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Compte> findByClient(Client client) {
        return this.DAO.findByClient(client);
    }
    
}
