package DAO;

import DAO.Compte;
import DAO.Message;
import DAO.Notification;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-06T18:45:17")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile ListAttribute<Client, Notification> listenotifications;
    public static volatile ListAttribute<Client, Message> listemessage;
    public static volatile ListAttribute<Client, Compte> listecompte;
    public static volatile SingularAttribute<Client, Long> IDClient;
    public static volatile SingularAttribute<Client, String> mdp;
    public static volatile SingularAttribute<Client, String> adresse;
    public static volatile SingularAttribute<Client, String> tel;
    public static volatile SingularAttribute<Client, String> login;

}