package fr.utbm.lo54.projet.entity;

import fr.utbm.lo54.projet.entity.Session;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-10T20:20:53")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile ListAttribute<Course, Session> sessions;
    public static volatile SingularAttribute<Course, Integer> code;
    public static volatile SingularAttribute<Course, String> title;

}