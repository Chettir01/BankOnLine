/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

/**
 *
 * @author Julien
 */
@Entity
@Table(name = "Particulier")
public class Particulier extends Client {

  

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private long civilite;

    @Column
    private Date dateNaissance;
    
    public Particulier(){
        
    }
    
    public Particulier(String prenom,String nom){
        this.prenom=prenom;
        this.nom=nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateNaissance() {
        return this.dateNaissance;
    }

    public void setCivilite(Long civilite) {
        this.civilite = civilite;
    }

    public long getCivilite() {
        return this.civilite;
    }

}
