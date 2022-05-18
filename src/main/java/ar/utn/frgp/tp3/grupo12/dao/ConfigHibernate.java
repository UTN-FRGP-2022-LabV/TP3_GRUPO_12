package ar.utn.frgp.tp3.grupo12.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConfigHibernate {
	private static SessionFactory sessionFactory;
	//private Session session;
	
	static {
        try{
            loadSessionFactory();
        }catch(Exception e){
            System.err.println("Exception while initializing hibernate util.. ");
            e.printStackTrace();
        }
    }
	
	public static void loadSessionFactory() {
    	Configuration configuration = new Configuration();
    	configuration.configure();	
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static Session getSession() throws HibernateException {
		 
        Session retSession=null;
            try {
                retSession = sessionFactory.openSession();
            }catch(Throwable t){
            System.err.println("Exception while getting session.. ");
            t.printStackTrace();
            }
            if(retSession == null) {
                System.err.println("session is discovered null");
            }
 
            return retSession;
    }
	/*
	public Session abrirConexion() {
		session = sessionFactory.openSession();
		return session;
	}
	
	public void cerrarSession() {
		session.close();
		//cerrarSessionFactory();
	}
*/
	public static void cerrarSessionFactory() {
		sessionFactory.close();
	}
	

}
