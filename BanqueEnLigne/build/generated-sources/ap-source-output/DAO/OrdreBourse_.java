package DAO;

import DAO.Bourse;
import DAO.Compte;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T10:09:01")
@StaticMetamodel(OrdreBourse.class)
public class OrdreBourse_ { 

    public static volatile SingularAttribute<OrdreBourse, Bourse> bourse;
    public static volatile SingularAttribute<OrdreBourse, Long> id_Bourse;
    public static volatile SingularAttribute<OrdreBourse, Integer> prixVente;
    public static volatile SingularAttribute<OrdreBourse, Boolean> achat;
    public static volatile SingularAttribute<OrdreBourse, Long> type;
    public static volatile SingularAttribute<OrdreBourse, Long> id_Compte;
    public static volatile SingularAttribute<OrdreBourse, Integer> date_creation;
    public static volatile SingularAttribute<OrdreBourse, Integer> quantite;
    public static volatile SingularAttribute<OrdreBourse, Integer> dateLimite;
    public static volatile SingularAttribute<OrdreBourse, Compte> compte;

}