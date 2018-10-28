/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
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
    private long ordrenourse_id;
	private int date_creation;
	private int achat;
	private int quantite;
	private int dateLimite;

    public long getOrdrenourse_id() {
        return ordrenourse_id;
    }

    public void setOrdrenourse_id(long ordrenourse_id) {
        this.ordrenourse_id = ordrenourse_id;
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
    @JoinColumn(name="compte")
    private Compte compte;

    @ManyToOne
    @JoinColumn(name = "bourse")
    private Bourse bourse;
    
    @ManyToOne
    @JoinColumn(name="typeordre_id")
    private TypeOrdre typeOrdre;
    
    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

	public void setDate_creation(int date_creation) {
		this.date_creation = date_creation;
	}

	public int getDate_creation() {
		return this.date_creation;
	}

	public void setAchat(int achat) {
		this.achat = achat;
	}

	public int Achat() {
		return this.achat;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setDateLimite(int dateLimite) {
		this.dateLimite = dateLimite;
	}

	public int getDateLimite() {
		return this.dateLimite;
	}


	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public int getPrixVente() {
		return this.prixVente;
	}


        
    
}
