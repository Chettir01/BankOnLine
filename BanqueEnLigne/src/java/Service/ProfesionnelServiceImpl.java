/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Professionel;
import DAO.ProfessionelDAO;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julien
 */
@Service
public class ProfesionnelServiceImpl implements ProfessionelService {

    @Resource
    ProfessionelDAO DAO;

    @Override
    public void add(String nom) {
        this.DAO.save(new Professionel(nom));
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
    public Professionel find(long id) {
        return DAO.find(id);
    }

    @Override
    public void update(Professionel h) {
        DAO.update(h);
    }

}
