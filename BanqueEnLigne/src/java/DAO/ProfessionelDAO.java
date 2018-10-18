/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author Julien
 */
public interface ProfessionelDAO {
      public void save(Professionel h);
 public void update(Professionel h);
 public void delete(Professionel h);
 public Professionel find(long id);
 public boolean authentification(String login,String mdp);
 public List<Professionel> findAll();
 public List<Professionel> findByName( String nom);
}
