package ar.utn.frgp.tp3.grupo12.dao;

import org.hibernate.Session;

import ar.utn.frgp.tp3.grupo12.entidad.Genero;

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
}
