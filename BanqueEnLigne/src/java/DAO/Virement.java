/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
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
public class Virement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String ibandestination;
    @Column
    private Date datecreation;

    @ManyToOne
    @JoinColumn(name = "Compte")
    private Compte compte;

    public Virement(String ibandestination, Compte compte, float somme) {
        this.ibandestination = ibandestination;
        this.datecreation = new java.sql.Date(new java.util.Date().getTime());
        this.compte = compte;
        this.somme = somme;
    }

    @Column
    private float somme;

    public float getSomme() {
        return somme;
    }

    public void setSomme(float somme) {
        this.somme = somme;
    }

    public Virement() {

    }

    public String getIbandestination() {
        return ibandestination;
    }

    public void setIbandestination(String ibandestination) {
        this.ibandestination = ibandestination;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public void setDatecreation(Date aDatecreation) {
        this.datecreation = aDatecreation;
    }

    public Date getDatecreation() {
        return this.datecreation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Virement)) {
            return false;
        }
        Virement other = (Virement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Virement[ id=" + id + " ]";
    }

}
