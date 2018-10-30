package DAO;

import DAO.Compte;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-31T00:12:54")
@StaticMetamodel(TypeCompte.class)
public class TypeCompte_ { 

    public static volatile ListAttribute<TypeCompte, Compte> liste;
    public static volatile SingularAttribute<TypeCompte, Integer> taux;
    public static volatile SingularAttribute<TypeCompte, Long> id;
    public static volatile SingularAttribute<TypeCompte, String> nom;
    public static volatile SingularAttribute<TypeCompte, Boolean> transaction;

}