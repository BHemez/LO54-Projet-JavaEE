package fr.utbm.lo54.projet.entity;

import fr.utbm.lo54.projet.entity.Session;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-07T18:17:13")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> firstname;
    public static volatile SingularAttribute<Client, String> password;
    public static volatile ListAttribute<Client, Session> sessions;
    public static volatile SingularAttribute<Client, String> address;
    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile SingularAttribute<Client, String> email;
    public static volatile SingularAttribute<Client, String> lastname;

}