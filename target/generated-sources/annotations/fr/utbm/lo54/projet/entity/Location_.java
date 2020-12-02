package fr.utbm.lo54.projet.entity;

import fr.utbm.lo54.projet.entity.Session;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-02T18:57:50")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile ListAttribute<Location, Session> sessions;
    public static volatile SingularAttribute<Location, String> city;
    public static volatile SingularAttribute<Location, Integer> id;

}