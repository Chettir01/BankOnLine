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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    @ManyToOne
    @JoinColumn(name = "client")
    private Client clientmessage;

    @ManyToOne
    @JoinColumn(name = "conseiller")
    private Conseiller conseiller;

    @Column
    private String message;

    @Column
    private boolean isclient;

    public Client getClient() {
        return clientmessage;
    }

    public void setClient(Client client) {
        this.clientmessage = client;
    }

    public Conseiller getConseiller() {
        return conseiller;
    }

    public void setConseiller(Conseiller conseiller) {
        this.conseiller = conseiller;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIsclient() {
        return isclient;
    }

    public void setIsclient(boolean isclient) {
        this.isclient = isclient;
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
        return "DAO.Conversation[ id=" + id + " ]";
    }

}
