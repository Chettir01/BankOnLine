package DAO;

import DAO.Client;
import DAO.TypeNotification;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-03T22:52:24")
@StaticMetamodel(Notification.class)
public class Notification_ { 

    public static volatile SingularAttribute<Notification, Integer> dateCreation;
    public static volatile SingularAttribute<Notification, TypeNotification> typenotification;
    public static volatile SingularAttribute<Notification, Long> typeNotification;
    public static volatile SingularAttribute<Notification, Client> clientnotification;
    public static volatile SingularAttribute<Notification, Long> id;
    public static volatile SingularAttribute<Notification, String> message;

}