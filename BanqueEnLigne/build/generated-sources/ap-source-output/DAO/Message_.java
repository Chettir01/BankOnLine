package DAO;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-17T21:31:36")
@StaticMetamodel(Message.class)
public class Message_ { 

    public static volatile SingularAttribute<Message, Long> idConversation;
    public static volatile SingularAttribute<Message, Long> createur;
    public static volatile SingularAttribute<Message, Date> datecreation;
    public static volatile SingularAttribute<Message, Long> id;
    public static volatile SingularAttribute<Message, String> contenu;

}