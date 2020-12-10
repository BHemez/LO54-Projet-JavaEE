
import fr.utbm.lo54.projet.entity.Client;
import fr.utbm.lo54.projet.tools.HibernateUtil;
import fr.utbm.lo54.projet.entity.Course;
import fr.utbm.lo54.projet.entity.Location;
import fr.utbm.lo54.projet.entity.Session;
import fr.utbm.lo54.projet.entity.SessionsView;
import fr.utbm.lo54.projet.service.ClientService;
import fr.utbm.lo54.projet.service.CourseService;
import fr.utbm.lo54.projet.service.LocationService;
import fr.utbm.lo54.projet.service.SessionService;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Remi
 */
public class App {
    
    public static void main(String[] args) {
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("school");
        EntityManager entityManager = null;
               
        LocationService ls = new LocationService();
        CourseService cs = new CourseService();
        ClientService cls = new ClientService();
        SessionService ss = new SessionService();
        
        
        /*Course c = new Course();
        c.setTitle("Oracle Database");
        cs.registerCourse(c);

        Location l = new Location();
        l.setCity("Mulhouse");
        ls.registerLocation(l);
        
        
        Client cl = new Client();
        cl.setFirstname("Remi");
        cl.setLastname("Papillier");
        cl.setAddress("9 rue Georges Koecklin Belfort");
        cl.setEmail("remi.papillier@utbm.fr");
        cl.setPassword("12345678");
        cls.registerClient(cl);*/

        Session s = new Session();
        s.setStartDate(new GregorianCalendar(2021,01,18));
        s.setEndDate(new GregorianCalendar(2021,01,22));
        s.setCapMax(20);
        Location testloc = ls.findLocationById(3);
        s.setLocation(testloc);
        Course testcourse = cs.findCourseById(5);
        s.setCourse(testcourse);
        //ss.registerSession(s);
        /*
        Client testclient = cls.findClientById(1);
        testclient.addSession(s);
        cls.updateClient(testclient);*/
        //List<Session> sessions2 = sv.getSessions();
        //System.out.println(sessions2);
        //System.out.println(ss.findSessiontById(1));

        HibernateUtil.shutdown();
    }
}
