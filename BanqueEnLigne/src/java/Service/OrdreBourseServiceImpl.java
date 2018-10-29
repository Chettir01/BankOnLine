/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Compte;
import DAO.OrdreBourse;
import DAO.OrdreBourseDAO;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julien
 */
 @Service
public class OrdreBourseServiceImpl implements OrdreBourseService {
    
     @Resource
    OrdreBourseDAO DAO;

    @Override
    public void add(OrdreBourse c) {
        DAO.save(c);
    }

    @Override
    public void remove(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrdreBourse> findByCompte(Compte c) {
        return DAO.findByCompte(c);
    }
    
}
