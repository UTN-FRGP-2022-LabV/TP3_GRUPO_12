package ar.utn.frgp.tp3.grupo12;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import ar.utn.frgp.tp3.grupo12.dao.ConfigHibernate;
import ar.utn.frgp.tp3.grupo12.dao.DaoBiblioteca;
import ar.utn.frgp.tp3.grupo12.dao.DaoGenero;
import ar.utn.frgp.tp3.grupo12.entidad.Autor;
import ar.utn.frgp.tp3.grupo12.entidad.Biblioteca;
import ar.utn.frgp.tp3.grupo12.entidad.Genero;
import ar.utn.frgp.tp3.grupo12.entidad.Libro;
import ar.utn.frgp.tp3.grupo12.entidad.Nacionalidad;
import ar.utn.frgp.tp3.grupo12.enums.EstadoLibroEnum;
import ar.utn.frgp.tp3.grupo12.enums.IdiomaEnum;

/**
 * TP 3 - Grupo 12
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//DaoGenero.add(new Genero("Fantasia"));

    	Nacionalidad nacionalidad = new Nacionalidad("Britanico");
    	
    	Autor autor = new Autor("J.R.R", "Tolkien", nacionalidad, "--");
  
    	Set<Genero> generos = new HashSet<Genero>();
    	generos.add(new Genero("Fantasía"));
    	generos.add(new Genero("Literatura Fantástica"));
    	generos.add(new Genero("Ciencia Ficción"));

    	
    	Libro libro = new Libro(
    			"9788445003022", 
    			"El Señor de los Anillos", 
    			new Date(), 
    			IdiomaEnum.ESPANIOL.name(), 
    			1392,
    			autor, 
    			"Los Anillos de Poder fueron forjados en antiguos tiempos por los herreros Elfos, y Sauron, el Señor Oscuro, forjó el Anillo Único..", 
    			generos);
    	
    	Biblioteca biblioteca = new Biblioteca(libro, new Date(), EstadoLibroEnum.EN_BIBLIOTECA.value);
    	
    	DaoBiblioteca.add(biblioteca);
    	
    	Biblioteca registroBiblioteca = DaoBiblioteca.readOne(1);
    	
    	System.out.println(registroBiblioteca);
    	
    	ConfigHibernate.cerrarSessionFactory();
    	
    }
}
