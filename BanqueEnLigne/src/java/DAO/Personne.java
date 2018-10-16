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
@Entity
public abstract class Personne {
        @Id
        @GeneratedValue
	private long ID_person;
        
        @Column
	private String nom;
        
        @Column
	private String prenom;
        
        @Column
	private String login;
        
        @Column
	private String mdp;
        
        @Column
	private Date dateNaissance;
        
        @Column
	private String adresse;
        
        @Column
	private String tel;
        
        @Column
	private long civilite;

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

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return this.login;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
		return this.tel;
	}

	public void setCivilite(Long civilite) {
		this.civilite = civilite;
	}

	public long getCivilite() {
		return this.civilite;
	}
}
