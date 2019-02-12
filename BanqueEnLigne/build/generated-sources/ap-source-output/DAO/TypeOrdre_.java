package DAO;

import DAO.OrdreBourse;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-26T12:41:10")
@StaticMetamodel(TypeOrdre.class)
public class TypeOrdre_ { 

    public static volatile SingularAttribute<TypeOrdre, Long> id;
    public static volatile SingularAttribute<TypeOrdre, String> nom;
    public static volatile ListAttribute<TypeOrdre, OrdreBourse> listeordre;

}