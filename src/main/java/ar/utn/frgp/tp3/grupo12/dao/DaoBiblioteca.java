package ar.utn.frgp.tp3.grupo12.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;

import ar.utn.frgp.tp3.grupo12.entidad.Biblioteca;
import ar.utn.frgp.tp3.grupo12.entidad.Libro;
import ar.utn.frgp.tp3.grupo12.utils.DateUtils;

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

	// Cualquier cosa consultar esta pagina de hql para armar las consultas
	// https://docs.jboss.org/hibernate/orm/3.5/reference/es-ES/html/queryhql.html

	public static List<Libro> listarOrdenadosPorISBN() {
		//1) Mostrar todos los libros ordenados según ISBN de mayor a menor.
		//Los campos que se deben mostrar son todos los pertenecientes a la clase Libro.

		Session session = ConfigHibernate.getSession();
		List<Libro> libros = session.createQuery("FROM Libro l ORDER BY l.isbn desc").list();
		session.close();
		return libros;
	}
	
	public static List<Biblioteca> listarPrestados() {
		//2) Mostrar todos los libros de la biblioteca que se encuentran prestados.
		//Los campos que se deben mostrar son ID biblioteca, fecha de alta y título del libro.

		Session session = ConfigHibernate.getSession();
		List<Biblioteca> biblioteca = session.createQuery("FROM Biblioteca b WHERE b.estado = 'PRESTADO'").list();
		session.close();
		return biblioteca;
		
	}
	
	public static Libro listarPorISBN(String isbn) {
		//4) Mostrar el libro con ISBN 12345 junto con todos sus gÃ©neros
		//Los campos que se deben mostrar la informaciÃ³n de la clase libro junto con todos sus gÃ©neros.

		Session session = ConfigHibernate.getSession();
		Libro libro = (Libro) session.createQuery
				("FROM Libro AS lib WHERE lib.isbn ="+isbn).uniqueResult();
		
		session.close();
		
		return libro;
}

	public static String obtenerConMayorISBN() {
		//5) Mostrar el libro que tenga el mayor número de ISBN
		//El único campo que se debe traer en la consulta es ISBN.

		Session session = ConfigHibernate.getSession();
		String isbn = (String) session.createQuery
				("SELECT max(lib.isbn) as isbn FROM Libro AS lib").uniqueResult();
		
		session.close();
		return isbn;
	}

	public static List<Object[]> obtenerCantidadLibrosPorGenero() {
		//6) Mostrar la cantidad de libros que existen para cada género.
		//Los campos que se deben mostrar son ID género, descripción y cantidad.	

		Session session = ConfigHibernate.getSession();
		
		List<Object[]> objects = session.createQuery("Select g.id, g.descripcion, COUNT(g.id) FROM Libro l INNER JOIN l.generos g GROUP BY g.id, g.descripcion").list();
		
		
		session.close();
		
		return objects;
	}
	
}
