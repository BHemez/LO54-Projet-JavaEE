package fr.utbm.lo54.projet.entity;

import fr.utbm.lo54.projet.entity.Client;
import fr.utbm.lo54.projet.entity.Course;
import fr.utbm.lo54.projet.entity.Location;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-18T23:21:22")
@StaticMetamodel(Session.class)
public class Session_ { 

    public static volatile ListAttribute<Session, Client> clients;
    public static volatile SingularAttribute<Session, Date> endDate;
    public static volatile SingularAttribute<Session, Integer> capMax;
    public static volatile SingularAttribute<Session, Course> course;
    public static volatile SingularAttribute<Session, Location> location;
    public static volatile SingularAttribute<Session, Integer> id;
    public static volatile SingularAttribute<Session, Date> startDate;

}