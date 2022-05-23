package ar.utn.frgp.tp3.grupo12.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import ar.utn.frgp.tp3.grupo12.entidad.Genero;
import ar.utn.frgp.tp3.grupo12.entidad.Nacionalidad;

public class DaoGenero {
	
	/**
	 * Agrega el elemento a la tabla
	 * El id no debe estar seteado
	 * @param genero
	 */
	public static void save(Genero genero) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		session.save(genero);
		session.getTransaction().commit();
		
		session.close();
	}
	
	/**
	 * Lee un elemento con el id
	 * @param id
	 * @return
	 */
	public static Genero findById(int id) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		Genero genero = (Genero) session.get(Genero.class, id);
		session.close();
		
		return genero;
	}
	
	/**
	 * Actualiza el elemento en la tabla
	 * Debe tener seteado el id
	 * @param genero
	 */
	public static void update(Genero genero) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		session.update(genero);
		session.getTransaction().commit();
		
		session.close();
	}

	/**
	 * Elimina el elemento en la tabla
	 * Debe tener seteado el id
	 * @param genero
	 */
	public static void delete(Genero genero) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		session.delete(genero);
		session.getTransaction().commit();

		session.close();
	}
	
	public static List<Genero> findAll() {
		Session session = ConfigHibernate.getSession();
		Criteria cr = session.createCriteria(Genero.class);
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return cr.list();
	}
}
