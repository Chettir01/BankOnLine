/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Julien
 */
public class Compte {
        
    @Id
    @GeneratedValue
	private long ID_compte;
    
    @Column
	private int numcompte;
    
    @Column
	private int solde;
    
    @Column
	private String iban;
    
    @Column
	private long typeCompte;
    
    @Column
	private int IDPerson;

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Column
	private Date dateCreation;
    
    public Compte(long ID_compte, int numcompte, int solde, String iban, int typeCompte, int IDPerson) {
        this.ID_compte = ID_compte;
        this.numcompte = numcompte;
        this.solde = solde;
        this.iban = iban;
        this.typeCompte = typeCompte;
        this.IDPerson = IDPerson;
    }

	public int getNumcompte() {
		return this.numcompte;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public int getSolde() {
		return this.solde;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getIban() {
		return this.iban;
	}

	public void setTypeCompte(int typeCompte) {
		this.typeCompte = typeCompte;
	}

	public long getTypeCompte() {
		return this.typeCompte;
	}

	public void setIDPerson(int IDPerson) {
		this.IDPerson = IDPerson;
	}

	public int getIDPerson() {
		return this.IDPerson;
	}

    
}
