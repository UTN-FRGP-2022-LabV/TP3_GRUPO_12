package ar.utn.frgp.tp3.grupo12.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;

import ar.utn.frgp.tp3.grupo12.entidad.Biblioteca;

public class DaoBiblioteca {
	
	/**
	 * Agrega el elemento a la tabla
	 * El id no debe estar seteado
	 * @param biblioteca
	 */
	public static void save(Biblioteca biblioteca) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		session.save(biblioteca);
		session.getTransaction().commit();
		
		session.close();
	}
	
	/**
	 * Lee un elemento con el id
	 * @param id
	 * @return
	 */
	public static Biblioteca findById(int id) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		Biblioteca biblioteca = (Biblioteca) session.get(Biblioteca.class, id);
		session.close();
		
		return biblioteca;
	}
	
	/**
	 * Actualiza el elemento en la tabla
	 * Debe tener seteado el id
	 * @param biblioteca
	 */
	public static void update(Biblioteca biblioteca) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		session.update(biblioteca);
		session.getTransaction().commit();
		
		session.close();
	}

	/**
	 * Elimina el elemento en la tabla
	 * Debe tener seteado el id
	 * @param biblioteca
	 */
	public static void delete(Biblioteca biblioteca) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		session.delete(biblioteca);
		session.getTransaction().commit();

		session.close();
	}
	
	
	public static List<Biblioteca> findAll() {
		Session session = ConfigHibernate.getSession();
		Criteria cr = session.createCriteria(Biblioteca.class);
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return cr.list();
	}
	
}
