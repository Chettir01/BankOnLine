/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Compte;
import DAO.TypeCompteDAO;
import DAO.TypeOrdre;
import DAO.TypeOrdreDAO;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julien
 */
@Service
public class TypeOrdreServiceImpl implements TypeOrdreService {

    @Resource
    TypeOrdreDAO DAO;
    
    @Override
    public void add(String iban, Compte compte, float somme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public List<TypeOrdre> findAll() {
        return DAO.findAll();
    }

    @Override
    public TypeOrdre findById(long Id) {
        return DAO.findById(Id);
    }
    
}
