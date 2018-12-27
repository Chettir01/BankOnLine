package DAO;

import DAO.Client;
import DAO.TypeNotification;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-28T00:13:29")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-19T15:58:38")
>>>>>>> ab4652e7cc6df262c09dab5937c6bb862575c040
@StaticMetamodel(Notification.class)
public class Notification_ { 

    public static volatile SingularAttribute<Notification, Integer> dateCreation;
    public static volatile SingularAttribute<Notification, TypeNotification> typenotification;
    public static volatile SingularAttribute<Notification, Long> typeNotification;
    public static volatile SingularAttribute<Notification, Client> clientnotification;
    public static volatile SingularAttribute<Notification, Long> id;
    public static volatile SingularAttribute<Notification, String> message;

}