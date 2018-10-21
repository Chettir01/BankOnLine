/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Julien
 */
@Entity
@Table(name="Professionel")
@DiscriminatorValue("PROFESSIONEL")
public class Professionel extends Client {

    @Column
    private String nomentreprise;

    public Professionel(String nomentreprise) {
        this.nomentreprise = nomentreprise;
    }

    public String getNomentreprise() {
        return nomentreprise;
    }

    public void setNomentreprise(String nomentreprise) {
        this.nomentreprise = nomentreprise;
    }


    
      public Professionel() {

        }


}
