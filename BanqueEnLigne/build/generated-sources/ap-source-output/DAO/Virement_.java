package DAO;

import DAO.Compte;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-12T00:29:47")
@StaticMetamodel(Virement.class)
public class Virement_ { 

    public static volatile SingularAttribute<Virement, Compte> comptedestination;
    public static volatile SingularAttribute<Virement, Float> somme;
    public static volatile SingularAttribute<Virement, Date> datecreation;
    public static volatile SingularAttribute<Virement, Long> id;
    public static volatile SingularAttribute<Virement, Compte> compte;

}