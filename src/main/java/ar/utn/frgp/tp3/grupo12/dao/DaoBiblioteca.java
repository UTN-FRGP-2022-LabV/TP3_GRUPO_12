package ar.utn.frgp.tp3.grupo12.dao;

import org.hibernate.Session;

import ar.utn.frgp.tp3.grupo12.entidad.Biblioteca;

public class DaoBiblioteca {
	
	/**
	 * Agrega el elemento a la tabla
	 * El id no debe estar seteado
	 * @param biblioteca
	 */
	public static void add(Biblioteca biblioteca) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		
		session.beginTransaction();
		session.save(biblioteca);
		session.getTransaction().commit();
		
		config.cerrarSession();
	}
	
	/**
	 * Lee un elemento con el id
	 * @param id
	 * @return
	 */
	public static Biblioteca readOne(int id) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		
		session.beginTransaction();
		Biblioteca biblioteca = (Biblioteca) session.get(Biblioteca.class, id);
		
		config.cerrarSession();
		
		return biblioteca;
	}
	
	/**
	 * Actualiza el elemento en la tabla
	 * Debe tener seteado el id
	 * @param biblioteca
	 */
	public static void update(Biblioteca biblioteca) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		
		session.beginTransaction();
		session.update(biblioteca);
		session.getTransaction().commit();
		
		config.cerrarSession();
	}

	/**
	 * Elimina el elemento en la tabla
	 * Debe tener seteado el id
	 * @param biblioteca
	 */
	public static void delete(Biblioteca biblioteca) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		
		session.beginTransaction();
		session.delete(biblioteca);
		session.getTransaction().commit();
		
		config.cerrarSession();
	
	}
	
}
