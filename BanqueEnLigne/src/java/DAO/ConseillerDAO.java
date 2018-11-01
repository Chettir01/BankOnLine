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
public interface ConseillerDAO {
          public void save(Conseiller h);
 public void update(Conseiller h);
 public void delete(Conseiller h);
 public Conseiller find(long id);
 public Conseiller authentification(String login,String mdp);
 public List<Conseiller> findAll();
 public List<Conseiller> findByName( String nom,String prenom);
}
