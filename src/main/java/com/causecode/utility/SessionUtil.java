package com.causecode.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * SessionUtil is utility Singleton class responsible for handling session's with Database  
 * 
 * @author Ankur Pande
 *
 */
 
public class SessionUtil  {
    
    private static SessionUtil instance;
    private SessionFactory sessionFactory;
    
    public static SessionUtil getInstance(){
    	if (instance == null){
			instance=new SessionUtil();
		}
		return instance;     
    }
	
	private SessionUtil(){
		sessionFactory  = new Configuration().configure().buildSessionFactory();
         
    }
    
    public static Session getSession(){
        Session session =  getInstance().sessionFactory.openSession();
        
        return session;
    }
}
