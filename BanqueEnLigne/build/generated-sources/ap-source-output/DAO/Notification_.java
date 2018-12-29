package DAO;

import DAO.Client;
import DAO.TypeNotification;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-29T13:57:40")
@StaticMetamodel(Notification.class)
public class Notification_ { 

    public static volatile SingularAttribute<Notification, Integer> dateCreation;
    public static volatile SingularAttribute<Notification, TypeNotification> typenotification;
    public static volatile SingularAttribute<Notification, Long> typeNotification;
    public static volatile SingularAttribute<Notification, Client> clientnotification;
    public static volatile SingularAttribute<Notification, Long> id;
    public static volatile SingularAttribute<Notification, String> message;

}