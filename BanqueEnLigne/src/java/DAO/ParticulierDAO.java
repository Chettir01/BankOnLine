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
public interface ParticulierDAO {
  public void save(Particulier h);
 public void update(Particulier h);
 public void delete(Particulier h);
 public Particulier find(long id);
 public boolean authentification(String login,String mdp);
 public List<Particulier> findAll();
 public List<Particulier> findByName( String nom,String prenom);
}
