package DAO;

import DAO.Compte;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-24T20:10:41")
@StaticMetamodel(Virement.class)
public class Virement_ { 

    public static volatile SingularAttribute<Virement, String> iban;
    public static volatile SingularAttribute<Virement, String> datecreation;
    public static volatile SingularAttribute<Virement, Long> id;
    public static volatile SingularAttribute<Virement, Compte> compte;

}