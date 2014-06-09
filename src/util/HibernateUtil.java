package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	 private static final SessionFactory sessionFactory; 
	    static { 
	        try { 
	           sessionFactory = new Configuration().configure().buildSessionFactory(); 
	        } catch (Throwable ex) { 
	            throw new ExceptionInInitializerError(ex); 
	        } 
	    } 
	    
	    //��ȡSessionFactory
	    public static SessionFactory getSessionFactory() { 
	        return sessionFactory; 
	    } 
	    
	    //��ȡSession
	    public static Session getSession(){
	    	return sessionFactory.openSession();
	    }
}
