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
public interface OrdreBourseDAO {
              public void save(OrdreBourse h);
 public void update(OrdreBourse h);
 public void delete(OrdreBourse h);
 public OrdreBourse find(long id);
 public List<OrdreBourse> findAll();
 public List<OrdreBourse> findByCompte(Compte c);
}
