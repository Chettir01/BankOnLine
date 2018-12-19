package DAO;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-19T15:58:38")
@StaticMetamodel(Particulier.class)
public class Particulier_ extends Client_ {

    public static volatile SingularAttribute<Particulier, Date> dateNaissance;
    public static volatile SingularAttribute<Particulier, String> nom;
    public static volatile SingularAttribute<Particulier, String> prenom;
    public static volatile SingularAttribute<Particulier, String> civilite;

}