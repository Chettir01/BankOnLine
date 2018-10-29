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
public interface BourseDAO {
                  public void save(Bourse h);
 public void update(Bourse h);
 public void delete(Bourse h);
 public Bourse find(long id);
 public List<Bourse> findAll();
}
