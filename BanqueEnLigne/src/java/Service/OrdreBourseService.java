/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Client;
import DAO.Compte;
import DAO.OrdreBourse;
import java.util.List;

/**
 *
 * @author Julien
 */
public interface OrdreBourseService {
    public void add(OrdreBourse c);
    public void remove(String nom);
    public List<OrdreBourse> findByCompte(Compte c);
}
