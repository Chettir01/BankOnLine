package DAO;

import DAO.Client;
import DAO.Conseiller;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-28T00:13:29")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-19T15:58:38")
>>>>>>> ab4652e7cc6df262c09dab5937c6bb862575c040
@StaticMetamodel(Message.class)
public class Message_ { 

    public static volatile SingularAttribute<Message, Client> clientmessage;
    public static volatile SingularAttribute<Message, Conseiller> conseiller;
    public static volatile SingularAttribute<Message, Long> id;
    public static volatile SingularAttribute<Message, String> message;
    public static volatile SingularAttribute<Message, Boolean> isclient;

}