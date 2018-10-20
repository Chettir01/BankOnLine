package DAO;

import DAO.Compte;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-20T13:00:52")
@StaticMetamodel(Client.class)
public abstract class Client_ { 

    public static volatile SingularAttribute<Client, Long> conseiler;
    public static volatile SingularAttribute<Client, Long> IDClient;
    public static volatile ListAttribute<Client, Compte> comptes;
    public static volatile SingularAttribute<Client, String> mdp;
    public static volatile SingularAttribute<Client, String> adresse;
    public static volatile SingularAttribute<Client, String> tel;
    public static volatile SingularAttribute<Client, String> login;

}