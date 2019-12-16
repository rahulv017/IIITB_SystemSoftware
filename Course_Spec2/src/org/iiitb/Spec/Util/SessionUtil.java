package org.iiitb.Spec.Util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.iiitb.Spec.Bean.Course;
import org.iiitb.Spec.Bean.Specilisation;


public class SessionUtil {
private static final SessionFactory sessionFactory;
    
    static {
        Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
        try {
            Configuration configuration = new Configuration();
            
            configuration.addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Specilisation.class);
            
            sessionFactory = configuration.buildSessionFactory();
        }
        catch (HibernateException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}
