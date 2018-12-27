package DAO;

import DAO.Client;
import DAO.Conseiller;
import DAO.OrdreBourse;
import DAO.TypeCompte;
import DAO.Virement;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-28T00:13:29")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-19T15:58:38")
>>>>>>> ab4652e7cc6df262c09dab5937c6bb862575c040
@StaticMetamodel(Compte.class)
public class Compte_ { 

    public static volatile ListAttribute<Compte, Virement> listevirement;
    public static volatile ListAttribute<Compte, Client> listeclientcompte;
    public static volatile SingularAttribute<Compte, Date> dateCreation;
    public static volatile SingularAttribute<Compte, Long> ID_compte;
    public static volatile SingularAttribute<Compte, String> iban;
    public static volatile ListAttribute<Compte, Virement> listevirementdestination;
    public static volatile SingularAttribute<Compte, Float> solde;
    public static volatile SingularAttribute<Compte, TypeCompte> type;
    public static volatile SingularAttribute<Compte, Boolean> valide;
    public static volatile SingularAttribute<Compte, Conseiller> conseillercompte;
    public static volatile ListAttribute<Compte, OrdreBourse> listeordre;

}