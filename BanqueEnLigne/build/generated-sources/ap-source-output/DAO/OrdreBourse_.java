package DAO;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-18T11:39:41")
@StaticMetamodel(OrdreBourse.class)
public class OrdreBourse_ { 

    public static volatile SingularAttribute<OrdreBourse, Long> id_Person;
    public static volatile SingularAttribute<OrdreBourse, Long> id_Bourse;
    public static volatile SingularAttribute<OrdreBourse, Integer> prixVente;
    public static volatile SingularAttribute<OrdreBourse, Boolean> achat;
    public static volatile SingularAttribute<OrdreBourse, Long> type;
    public static volatile SingularAttribute<OrdreBourse, Integer> date_creation;
    public static volatile SingularAttribute<OrdreBourse, Integer> quantite;
    public static volatile SingularAttribute<OrdreBourse, Integer> dateLimite;

}