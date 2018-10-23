package DAO;

import DAO.Client;
import DAO.OrdreBourse;
import DAO.TypeCompte;
import DAO.Virement;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-23T14:48:32")
@StaticMetamodel(Compte.class)
public class Compte_ { 

    public static volatile ListAttribute<Compte, Virement> listevirement;
    public static volatile SingularAttribute<Compte, Integer> numcompte;
    public static volatile SingularAttribute<Compte, Date> dateCreation;
    public static volatile SingularAttribute<Compte, Long> ID_compte;
    public static volatile SingularAttribute<Compte, String> iban;
    public static volatile SingularAttribute<Compte, Client> client;
    public static volatile SingularAttribute<Compte, Integer> solde;
    public static volatile SingularAttribute<Compte, TypeCompte> type;
    public static volatile ListAttribute<Compte, OrdreBourse> listeordre;

}