/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Client;
import DAO.Conseiller;

/**
 *
 * @author Julien
 */
public interface ConseillerService {
        public void add(Conseiller c);
    public void remove(String nom);
    public Conseiller auth(String login,String mdp);
    public String getNomsMessages();
}
