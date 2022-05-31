package ar.utn.frgp.tp3.grupo12.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import ar.utn.frgp.tp3.grupo12.entidad.Autor;
import ar.utn.frgp.tp3.grupo12.entidad.Nacionalidad;

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
	
	public static List<Autor> findAll() {
		Session session = ConfigHibernate.getSession();
		Criteria cr = session.createCriteria(Autor.class);
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return cr.list();
	}

	public static List<Object[]> listarPorNacionalidad(String nacionalidad) {
		//3) Mostrar todos los autores que sean de nacionalidad Argentina
		//Los campos que se deben mostrar son todos los pertenecientes a la clase Autor y Nacionalidad
		Nacionalidad argentino = DaoNacionalidad.findAll().stream().filter(nac -> "Argentino".equals(nac.getDescripcion())).findFirst().orElse(null);
				
		Session session = ConfigHibernate.getSession();
		
		List<Object[]> listaAutores_x_Nacionalidad = (List<Object[]>) session.createQuery
				("FROM Autor AS au INNER JOIN au.nacionalidad WHERE au.nacionalidad.id = " + argentino.getId()).list();
		
		session.close();
		
		return listaAutores_x_Nacionalidad;
		
	}
}
