/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Julien
 */
@Entity
public class OrdreBourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordrebourse_id;
    
    public OrdreBourse(){
        
    }

    public OrdreBourse(int quantite, Date dateLimite, int prixVente, Compte compte, Bourse bourse, TypeOrdre typeOrdre) {
        this.date_creation = new java.sql.Date(new java.util.Date().getTime());
        this.quantite = quantite;
        this.dateLimite = dateLimite;
        this.prixVente = prixVente;
        this.compte = compte;
        this.bourse = bourse;
        this.typeOrdre = typeOrdre;
    }
    private Date date_creation;
    private int quantite;
    private Date dateLimite;

    public long getOrdrenourse_id() {
        return ordrebourse_id;
    }

    public void setOrdrenourse_id(long ordrenourse_id) {
        this.ordrebourse_id = ordrenourse_id;
    }

    public Bourse getBourse() {
        return bourse;
    }

    public void setBourse(Bourse bourse) {
        this.bourse = bourse;
    }

    public TypeOrdre getTypeOrdre() {
        return typeOrdre;
    }

    public void setTypeOrdre(TypeOrdre typeOrdre) {
        this.typeOrdre = typeOrdre;
    }
    private int prixVente;

    @ManyToOne
    @JoinColumn(name = "compte")
    private Compte compte;

    @ManyToOne
    @JoinColumn(name = "bourse")
    private Bourse bourse;

    @ManyToOne
    @JoinColumn(name = "typeordre_id")
    private TypeOrdre typeOrdre;

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_creation() {
        return this.date_creation;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }

    public Date getDateLimite() {
        return this.dateLimite;
    }

    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }

    public int getPrixVente() {
        return this.prixVente;
    }

}
