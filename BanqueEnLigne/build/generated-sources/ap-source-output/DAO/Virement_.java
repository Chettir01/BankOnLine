package DAO;

import DAO.Compte;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-28T00:13:29")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-19T15:58:38")
>>>>>>> ab4652e7cc6df262c09dab5937c6bb862575c040
@StaticMetamodel(Virement.class)
public class Virement_ { 

    public static volatile SingularAttribute<Virement, Compte> comptedestination;
    public static volatile SingularAttribute<Virement, Float> somme;
    public static volatile SingularAttribute<Virement, Date> datecreation;
    public static volatile SingularAttribute<Virement, Long> id;
    public static volatile SingularAttribute<Virement, Compte> compte;

}