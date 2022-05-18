package ar.utn.frgp.tp3.grupo12.dao;

import org.hibernate.Session;

import ar.utn.frgp.tp3.grupo12.entidad.Genero;

public class DaoGenero {
	
	/**
	 * Agrega el elemento a la tabla
	 * El id no debe estar seteado
	 * @param genero
	 */
	public static void add(Genero genero) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		
		session.beginTransaction();
		session.save(genero);
		session.getTransaction().commit();
		
		config.cerrarSession();
	}
	
	/**
	 * Lee un elemento con el id
	 * @param id
	 * @return
	 */
	public static Genero readOne(int id) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		
		session.beginTransaction();
		Genero genero = (Genero) session.get(Genero.class, id);
		
		config.cerrarSession();
		
		return genero;
	}
	
	/**
	 * Actualiza el elemento en la tabla
	 * Debe tener seteado el id
	 * @param genero
	 */
	public static void update(Genero genero) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		
		session.beginTransaction();
		session.update(genero);
		session.getTransaction().commit();
		
		config.cerrarSession();
	}

	/**
	 * Elimina el elemento en la tabla
	 * Debe tener seteado el id
	 * @param genero
	 */
	public static void delete(Genero genero) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		
		session.beginTransaction();
		session.delete(genero);
		session.getTransaction().commit();
		
		config.cerrarSession();
	
	}
	
}
