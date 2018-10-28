/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Compte;
import DAO.Professionel;
import DAO.Virement;
import DAO.VirementDAO;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julien
 */
@Service
public class VirementServiceImpl implements VirementService {

    @Resource
    VirementDAO DAO;

    @Override
    public void add(String nom) {
        this.DAO.save(new Virement());
    }

    @Override
    public void remove(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean auth(String login, String mdp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNomsMessages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Virement> findByCompte(Compte c) {
        return DAO.findByCompte(c);
    }

}
