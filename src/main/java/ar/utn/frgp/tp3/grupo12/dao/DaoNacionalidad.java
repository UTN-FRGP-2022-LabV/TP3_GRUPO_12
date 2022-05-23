package ar.utn.frgp.tp3.grupo12.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import ar.utn.frgp.tp3.grupo12.entidad.Biblioteca;
import ar.utn.frgp.tp3.grupo12.entidad.Nacionalidad;

public class DaoNacionalidad {
	
	/**
	 * Agrega el elemento a la tabla
	 * El id no debe estar seteado
	 * @param nacionalidad
	 */
	public static void save(Nacionalidad nac) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		session.save(nac);
		session.getTransaction().commit();
		
		session.close();
	}
	
	/**
	 * Lee un elemento con el id
	 * @param id
	 * @return
	 */
	public static Nacionalidad findById(int id) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		Nacionalidad nac = (Nacionalidad) session.get(Nacionalidad.class, id);
		session.close();
		
		return nac;
	}
	
	/**
	 * Actualiza el elemento en la tabla
	 * Debe tener seteado el id
	 * @param nacionalidad
	 */
	public static void update(Nacionalidad nac) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		session.update(nac);
		session.getTransaction().commit();
		
		session.close();
	}

	/**
	 * Elimina el elemento en la tabla
	 * Debe tener seteado el id
	 * @param nacionalidad
	 */
	public static void delete(Nacionalidad nac) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		session.delete(nac);
		session.getTransaction().commit();
		
		session.close();
	
	}
	
	public static List<Nacionalidad> findAll() {
		Session session = ConfigHibernate.getSession();
		Criteria cr = session.createCriteria(Nacionalidad.class);
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return cr.list();
	}
}
