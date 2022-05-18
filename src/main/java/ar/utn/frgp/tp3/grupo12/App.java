package ar.utn.frgp.tp3.grupo12;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import ar.utn.frgp.tp3.grupo12.dao.ConfigHibernate;
import ar.utn.frgp.tp3.grupo12.dao.DaoBiblioteca;
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

    	nuevoRegistro1();
    	nuevoRegistro2();
    	nuevoRegistro3();
    	nuevoRegistro4();
    	nuevoRegistro5();
    	
    	ConfigHibernate.cerrarSessionFactory();
    }
    
    public static void nuevoRegistro1() {

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
    }
    
    public static void nuevoRegistro2() {

    	Nacionalidad nacionalidad = new Nacionalidad("Britanico");
    	
    	Autor autor = new Autor("J. K.", "Rowling", nacionalidad, "--");

    	Set<Genero> generos = new HashSet<Genero>();
    	generos.add(new Genero("Fantasía Contemporanea"));
    	generos.add(new Genero("Literatura Fantástica"));
    	generos.add(new Genero("Novela"));

    	
    	Libro libro = new Libro(
    			"1788445003023", 
    			"Harry Potter", 
    			new Date(), 
    			IdiomaEnum.ESPANIOL.name(), 
    			3400,
    			autor, 
    			"Las aventuras del joven aprendiz de magia y hechicería Harry Potter y sus amigos Hermione Granger y Ron Weasley, durante los años que pasan en el Colegio Hogwarts de Magia y Hechicería.", 
    			generos);
    	
    	Biblioteca biblioteca = new Biblioteca(libro, new Date(), EstadoLibroEnum.EN_BIBLIOTECA.value);
    	
    	DaoBiblioteca.add(biblioteca);
    	
    	Biblioteca registroBiblioteca = DaoBiblioteca.readOne(1);
    	
    	System.out.println(registroBiblioteca);
        }
    
    public static void nuevoRegistro3() {

    	Nacionalidad nacionalidad = new Nacionalidad("Argentino");
    	
    	Autor autor = new Autor("Edgardo", "Scott", nacionalidad, "--");

    	Set<Genero> generos = new HashSet<Genero>();
    	generos.add(new Genero("No Ficcion"));
    	generos.add(new Genero("Pandemia"));
    	generos.add(new Genero("Riesgo"));

    	
    	Libro libro = new Libro(
    			"2788445033025", 
    			"Contacto", 
    			new Date(), 
    			IdiomaEnum.ESPANIOL.name(), 
    			853,
    			autor, 
    			"Dispuesto a recuperar lo que parece perdido, como ya hizo Odiseo en la isla de Calipso (pero con Internet), Scott echa mano a lo que tienen todos los aislados..", 
    			generos);
    	
    	Biblioteca biblioteca = new Biblioteca(libro, new Date(), EstadoLibroEnum.EN_BIBLIOTECA.value);
    	
    	DaoBiblioteca.add(biblioteca);
    	
    	Biblioteca registroBiblioteca = DaoBiblioteca.readOne(1);
    	
    	System.out.println(registroBiblioteca);
        }
    
    public static void nuevoRegistro4() {

    	Nacionalidad nacionalidad = new Nacionalidad("Britanico");
    	
    	Autor autor = new Autor("Nicholas", "Sparks", nacionalidad, "--");

    	Set<Genero> generos = new HashSet<Genero>();
    	generos.add(new Genero("Novela"));
    	generos.add(new Genero("Cine Romantico"));
    	generos.add(new Genero("Drama"));

    	
    	Libro libro = new Libro(
    			"5588445033026", 
    			"Diario de una Pasion", 
    			new Date(), 
    			IdiomaEnum.ESPANIOL.name(), 
    			853,
    			autor, 
    			"Una dolorosa historia sobre el poder duradero del amor y sus milagros. Un hombre tiene un cuaderno viejo, traído y llevado mil veces, en su regazo.", 
    			generos);
    	
    	Biblioteca biblioteca = new Biblioteca(libro, new Date(), EstadoLibroEnum.EN_BIBLIOTECA.value);
    	
    	DaoBiblioteca.add(biblioteca);
    	
    	Biblioteca registroBiblioteca = DaoBiblioteca.readOne(1);
    	
    	System.out.println(registroBiblioteca);
        }
    
    public static void nuevoRegistro5() {

    	Nacionalidad nacionalidad = new Nacionalidad("Estadounidense");
    	
    	Autor autor = new Autor("Stephenie", "Meyer", nacionalidad, "--");

    	Set<Genero> generos = new HashSet<Genero>();
    	generos.add(new Genero("Young Adult Fiction"));
    	generos.add(new Genero("Ficcion Romantica"));
    	generos.add(new Genero("Vampire Fiction"));

    	
    	Libro libro = new Libro(
    			"9998445033029", 
    			"Crepusculo", 
    			new Date(), 
    			IdiomaEnum.ESPANIOL.name(), 
    			853,
    			autor, 
    			"Cuando Edward Cullen y Bella Swan se conocieron en «Crepúsculo», nació una historia de amor icónica.", 
    			generos);
    	
    	Biblioteca biblioteca = new Biblioteca(libro, new Date(), EstadoLibroEnum.EN_BIBLIOTECA.value);
    	
    	DaoBiblioteca.add(biblioteca);
    	
    	Biblioteca registroBiblioteca = DaoBiblioteca.readOne(1);
    	
    	System.out.println(registroBiblioteca);
        }
}
