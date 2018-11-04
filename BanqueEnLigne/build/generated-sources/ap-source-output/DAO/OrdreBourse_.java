package DAO;

import DAO.Bourse;
import DAO.Compte;
import DAO.TypeOrdre;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-04T21:40:46")
@StaticMetamodel(OrdreBourse.class)
public class OrdreBourse_ { 

    public static volatile SingularAttribute<OrdreBourse, Bourse> bourse;
    public static volatile SingularAttribute<OrdreBourse, TypeOrdre> typeOrdre;
    public static volatile SingularAttribute<OrdreBourse, Long> ordrebourse_id;
    public static volatile SingularAttribute<OrdreBourse, Integer> prixVente;
    public static volatile SingularAttribute<OrdreBourse, Date> date_creation;
    public static volatile SingularAttribute<OrdreBourse, Integer> quantite;
    public static volatile SingularAttribute<OrdreBourse, Date> dateLimite;
    public static volatile SingularAttribute<OrdreBourse, Compte> compte;

}