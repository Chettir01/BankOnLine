/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private String iban;
    @Column
    private long compte;
    @Column
    private String datecreation;

    public Virement() {

    }

    public void setIban(String aIban) {
        this.iban = aIban;
    }

    public String getIban() {
        return this.iban;
    }

    public long getCompte() {
        return compte;
    }

    public void setCompte(long compte) {
        this.compte = compte;
    }
    public void setDatecreation(String aDatecreation) {
        this.datecreation = aDatecreation;
    }

    public String getDatecreation() {
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
