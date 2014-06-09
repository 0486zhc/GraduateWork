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
	    
	    //获取SessionFactory
	    public static SessionFactory getSessionFactory() { 
	        return sessionFactory; 
	    } 
	    
	    //获取Session
	    public static Session getSession(){
	    	return sessionFactory.openSession();
	    }
}
