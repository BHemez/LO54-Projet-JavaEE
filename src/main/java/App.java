
import fr.utbm.lo54.projet.entity.Client;
import fr.utbm.lo54.projet.repository.EntityClientDao;
import fr.utbm.lo54.projet.repository.EntityCourseDao;
import fr.utbm.lo54.projet.repository.EntityLocationDao;
import fr.utbm.lo54.projet.repository.EntitySessionDao;
import fr.utbm.lo54.projet.tools.HibernateUtil;
import fr.utbm.lo54.projet.entity.Course;
import fr.utbm.lo54.projet.entity.Location;
import fr.utbm.lo54.projet.entity.Session;
import fr.utbm.lo54.projet.service.ClientService;
import fr.utbm.lo54.projet.service.CourseService;
import fr.utbm.lo54.projet.service.LocationService;
import fr.utbm.lo54.projet.service.SessionService;
import javax.persistence.EntityManager;
import java.util.Date;
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
        
        Course c = new Course();
        c.setTitle("Anglais");

        Location l = new Location();
        l.setCity("Belfort");
        
        Client cl = new Client();
        cl.setFirstname("Remi");
        cl.setLastname("Papillier");
        cl.setAddress("Belfort");
        cl.setPhone("0611223344");
        cl.setEmail("remi.papillier@utbm.fr");
        
        Session s = new Session();
        s.setStartDate(new Date(2020, 11, 21));
        s.setEndDate(new Date(2020, 11, 28));
        s.setCapMax(20);
        s.setCourse(c);
        s.setLocation(l);
        
        
        CourseService cs = new CourseService();
        //cs.registerCourse(c);
        
        ClientService cls = new ClientService();
        //cls.registerClient(cl);
        
        LocationService ls = new LocationService();
        //ls.registerLocation(l);
        
        SessionService ss = new SessionService();
        ss.registerSession(s);

        HibernateUtil.shutdown();
    }
}
