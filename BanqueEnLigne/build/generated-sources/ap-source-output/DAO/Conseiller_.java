package DAO;

import DAO.Compte;
import DAO.Message;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-13T22:45:52")
@StaticMetamodel(Conseiller.class)
public class Conseiller_ { 

    public static volatile ListAttribute<Conseiller, Message> listemessage;
    public static volatile ListAttribute<Conseiller, Compte> listecompte;
    public static volatile SingularAttribute<Conseiller, String> mdp;
    public static volatile SingularAttribute<Conseiller, Long> id;
    public static volatile SingularAttribute<Conseiller, String> login;
    public static volatile SingularAttribute<Conseiller, String> nom;
    public static volatile SingularAttribute<Conseiller, String> prenom;

}