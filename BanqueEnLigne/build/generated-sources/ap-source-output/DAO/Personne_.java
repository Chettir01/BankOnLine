package DAO;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-16T14:26:30")
@StaticMetamodel(Personne.class)
public abstract class Personne_ { 

    public static volatile SingularAttribute<Personne, Date> dateNaissance;
    public static volatile SingularAttribute<Personne, String> mdp;
    public static volatile SingularAttribute<Personne, String> adresse;
    public static volatile SingularAttribute<Personne, String> tel;
    public static volatile SingularAttribute<Personne, String> login;
    public static volatile SingularAttribute<Personne, String> nom;
    public static volatile SingularAttribute<Personne, String> prenom;
    public static volatile SingularAttribute<Personne, Long> ID_person;
    public static volatile SingularAttribute<Personne, Long> civilite;

}