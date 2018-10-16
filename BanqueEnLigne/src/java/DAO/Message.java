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
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private long createur;
	    @Column
private String contenu;
	    @Column
private Date datecreation;
	    @Column
private long idConversation;


	public void setCreateur(long aCreateur) {
		this.createur = aCreateur;
	}

	public long getCreateur() {
		return this.createur;
	}

	public void setContenu(String aContenu) {
		this.contenu = aContenu;
	}

	public String getContenu() {
		return this.contenu;
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
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Message[ id=" + id + " ]";
    }
    
}
