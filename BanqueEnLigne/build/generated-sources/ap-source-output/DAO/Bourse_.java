package DAO;

import DAO.OrdreBourse;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-18T23:24:13")
@StaticMetamodel(Bourse.class)
public class Bourse_ { 

    public static volatile SingularAttribute<Bourse, Integer> prix;
    public static volatile ListAttribute<Bourse, OrdreBourse> listebourse;
    public static volatile SingularAttribute<Bourse, Date> datelimite;
    public static volatile SingularAttribute<Bourse, Long> id;
    public static volatile SingularAttribute<Bourse, String> nom;

}