package ar.utn.frgp.tp3.grupo12.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConfigHibernate {
	private static SessionFactory sessionFactory;
	
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
	
	/**
	 * getSession devuelve una session, una vez utilizado debe llamar al metodo close de session
	 * @return
	 * @throws HibernateException
	 */
	public static Session getSession() throws HibernateException {
		 
        Session retSession=null;
            try {
                retSession = sessionFactory.openSession();
            }catch(Throwable t){
            	System.err.println("Ocurrió una Excepción mientras intentaba obtener una session.. ");
            	t.printStackTrace();
            }
            if(retSession == null) {
                System.err.println("La sesion es invalida");
            }
 
            return retSession;
    }

	/**
	 * cerrarSessionFactory debe llamarse inmediatamente antes de terminar el programa, y no tiene que haber ningun otro proceso despues 
	 */
	public static void cerrarSessionFactory() {
		sessionFactory.close();
	}
	

}
