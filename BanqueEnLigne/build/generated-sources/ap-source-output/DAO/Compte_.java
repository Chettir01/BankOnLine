package DAO;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-20T13:00:52")
@StaticMetamodel(Compte.class)
public class Compte_ { 

    public static volatile SingularAttribute<Compte, Integer> numcompte;
    public static volatile SingularAttribute<Compte, Date> dateCreation;
    public static volatile SingularAttribute<Compte, Long> ID_compte;
    public static volatile SingularAttribute<Compte, Long> typeCompte;
    public static volatile SingularAttribute<Compte, Integer> IDPerson;
    public static volatile SingularAttribute<Compte, String> iban;
    public static volatile SingularAttribute<Compte, Integer> solde;

}