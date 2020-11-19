
import fr.utbm.lo54.projet.entity.Client;
import fr.utbm.lo54.projet.tools.HibernateUtil;
import fr.utbm.lo54.projet.entity.Course;
import fr.utbm.lo54.projet.entity.Location;
import fr.utbm.lo54.projet.entity.Session;
import fr.utbm.lo54.projet.service.ClientService;
import fr.utbm.lo54.projet.service.CourseService;
import fr.utbm.lo54.projet.service.LocationService;
import fr.utbm.lo54.projet.service.SessionService;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import java.util.List;
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
        
        Session s = new Session();
        s.setStartDate(new GregorianCalendar(2020,11,21));
        s.setEndDate(new GregorianCalendar(2020, 11, 28));
        s.setCapMax(20);
        
        Course c = new Course();
        c.setTitle("Management");
        c.addSession(s);

        Location l = new Location();
        l.setCity("Paris");
        l.addSession(s);
        
        Client cl = new Client();
        cl.setFirstname("Antoine");
        cl.setLastname("Test");
        cl.setAddress("15 rue Charle de Gaules");
        cl.setPhone("0623232323");
        cl.setEmail("antoine.test@utbm.fr");
        cl.addSession(s);
        
        
        ClientService cls = new ClientService();
        //cls.registerClient(cl);
        
        CourseService cs = new CourseService();
        //cs.registerCourse(c);
        
        LocationService ls = new LocationService();
        //ls.registerLocation(l);
        
        SessionService ss = new SessionService();
        //ss.registerSession(s);

        HibernateUtil.shutdown();
    }
}
