package ar.utn.frgp.tp3.grupo12.dao;

import org.hibernate.Session;

import ar.utn.frgp.tp3.grupo12.entidad.Autor;

public class DaoAutor {
	/**
	 * Agrega el elemento a la tabla
	 * El id no debe estar seteado
	 * @param autor
	 */
	public static void save(Autor autor) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		session.save(autor);
		session.getTransaction().commit();
		
		session.close();
	}
	
	/**
	 * Lee un elemento con el id
	 * @param id
	 * @return
	 */
	public static Autor findById(int id) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		Autor autor = (Autor) session.get(Autor.class, id);
		session.close();
		
		return autor;
	}
	
	/**
	 * Actualiza el elemento en la tabla
	 * Debe tener seteado el id
	 * @param autor
	 */
	public static void update(Autor autor) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		session.update(autor);
		session.getTransaction().commit();
		
		session.close();
	}

	/**
	 * Elimina el elemento en la tabla
	 * Debe tener seteado el id
	 * @param autor
	 */
	public static void delete(Autor autor) {
		Session session = ConfigHibernate.getSession();
		
		session.beginTransaction();
		session.delete(autor);
		session.getTransaction().commit();
		
		session.close();
	
	}
}
