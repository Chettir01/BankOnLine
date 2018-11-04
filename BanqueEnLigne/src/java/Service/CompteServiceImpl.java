/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Client;
import DAO.Compte;
import DAO.CompteDAO;
import DAO.Conseiller;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        DAO.save(c);
    }

    @Override
    public void remove(Compte c) {
        DAO.delete(c);
    }

    @Override
    public List<Compte> findByClient(Client client) {
        return this.DAO.findByClient(client);
    }

    @Override
    public Compte findById(long id) {
        return DAO.findById(id);
    }

    @Override
    public List<Compte> findByConseiller(Conseiller c) {
      return DAO.findByConseiller(c);
    }

    @Override
    public Compte findByIBAN(String IBAN) {
        return DAO.findByIBAN(IBAN);
    }

    @Override
    public void update(Compte h) {
        DAO.update(h);
    }

    @Override
    public List<Compte> findNonvalide() {
        return DAO.findNonvalide();
                
    }

    @Override
    public List<Compte> findAll() {
        return DAO.findAll();
    }

    @Override
    public List<Compte> findByClientvalide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     
    
        
    
}
