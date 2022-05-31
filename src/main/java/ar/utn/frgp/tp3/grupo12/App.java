package ar.utn.frgp.tp3.grupo12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.utn.frgp.tp3.grupo12.dao.ConfigHibernate;
import ar.utn.frgp.tp3.grupo12.dao.DaoAutor;
import ar.utn.frgp.tp3.grupo12.dao.DaoBiblioteca;
import ar.utn.frgp.tp3.grupo12.dao.DaoGenero;
import ar.utn.frgp.tp3.grupo12.dao.DaoNacionalidad;
import ar.utn.frgp.tp3.grupo12.entidad.Autor;
import ar.utn.frgp.tp3.grupo12.entidad.Biblioteca;
import ar.utn.frgp.tp3.grupo12.entidad.Genero;
import ar.utn.frgp.tp3.grupo12.entidad.Libro;
import ar.utn.frgp.tp3.grupo12.entidad.Nacionalidad;
import ar.utn.frgp.tp3.grupo12.enums.EstadoLibroEnum;
import ar.utn.frgp.tp3.grupo12.enums.IdiomaEnum;
import ar.utn.frgp.tp3.grupo12.utils.DateUtils;

/**
 * TP 4 - Grupo 12
 * Integrantes:
 * 
 * Marcos Zone
 * Manuel Oreguy
 * Sergio Palacio
 */

public class App 
{	
	public static void main( String[] args )
    {
		// Se ejecuta una sola vez para insertar registros necesarios
		try {
			insertarRegistros();
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	//ejercicioTP3();
    	ejercicioTP4();
    	
    	//Cerrar Session Factory
    	ConfigHibernate.cerrarSessionFactory();
    }

	private static void insertarRegistros() throws ParseException {
		List<Autor> autores = DaoAutor.findAll();
		
		if (autores == null || autores.isEmpty()) {
			agregarNacionalidades();
			agregarGeneros();
			agregarAutores();
			
			autores = DaoAutor.findAll();
			List<Genero> generos = DaoGenero.findAll();
			
			// AGREGAR
	    	nuevoRegistro1(autores, generos);
	    	nuevoRegistro2(autores, generos);
	    	nuevoRegistro3(autores, generos);
	    	nuevoRegistro4(autores, generos);
	    	nuevoRegistro5(autores, generos);
	    	nuevoRegistro6(autores, generos);
		}
	}

	private static void ejercicioTP4() {
		//1) Mostrar todos los libros ordenados según ISBN de mayor a menor.
		//Los campos que se deben mostrar son todos los pertenecientes a la clase Libro.
	
		List<Libro> libros = DaoBiblioteca.listarOrdenadosPorISBN();
		print("---------- Libros ordenados según ISBN de mayor a menor ----------" );
		libros.stream().forEach(System.out::println);
		print("---------------------------------------------------------------------------------------------------------------------------" );
		//2) Mostrar todos los libros de la biblioteca que se encuentran prestados.
		//Los campos que se deben mostrar son ID biblioteca, fecha de alta y título del libro.
	
		List<Biblioteca> librosPrestados = DaoBiblioteca.listarPrestados();
		print("---------- Libros prestados ----------" );
		for (Biblioteca libroPrestado : librosPrestados) {
			print("ID Biblioteca: " + libroPrestado.getId() + " - Fecha Alta: " + DateUtils.formatFromDate(libroPrestado.getFechaDeAlta()) + " - Titulo: " + libroPrestado.getLibro().getTitulo());
		}
		print("---------------------------------------------------------------------------------------------------------------------------" );
		//3) Mostrar todos los autores que sean de nacionalidad Argentina
		//Los campos que se deben mostrar son todos los pertenecientes a la clase Autor y Nacionalidad
			
		print("---------- Autores con Nacionalidad Argentina -----------");
		List<Object[]> autoresArgentinos = DaoAutor.listarPorNacionalidad("Argentino");
		
		for(Object[] objeto : autoresArgentinos) {
			Autor autor = (Autor)objeto[0];
			Nacionalidad nacionalidad = (Nacionalidad)objeto[1];
			System.out.print("ID Autor: "+autor.getId()+" - Nombre y apellido: "+autor.getNombre()+" "+autor.getApellido()+" - Email: "+autor.getEmail()+
					" - ID Nacionalidad: "+nacionalidad.getId()+" - Nacionalidad: "+nacionalidad.getDescripcion()+"\n");
		}
		print("---------------------------------------------------------------------------------------------------------------------------" );
				
		//4) Mostrar el libro con ISBN 12345 junto con todos sus generos
		//Los campos que se deben mostrar la informacion de la clase libro junto con todos sus generos.
				
		print("---------- Libro con ISBN '1788445003023' Junto con todos sus generos -----------");
		Libro libro = DaoBiblioteca.listarPorISBN("1788445003023");
		
		System.out.print("ISBN: " + libro.getIsbn() + ", Titulo: " + libro.getTitulo() + ", FechaDeLanzamiento: " + DateUtils.formatFromDate(libro.getFechaDeLanzamiento()) + ", idioma: "
				+ libro.getIdioma() + ", CantidadDePaginas: " + libro.getCantidadDePaginas() + ", Autor: " + libro.getAutor() + "\nDescripcion: "
				+ libro.getDescripcion() +"\n----GENEROS----\n"+libro.getGeneros()+"\n");

		print("-----------Libro con mayor ISBN--------------------" );
		
		//5) Mostrar el libro que tenga el mayor número de ISBN
		//El único campo que se debe traer en la consulta es ISBN.
	
		String isbn = DaoBiblioteca.obtenerConMayorISBN();
		print("ISBN: " + isbn);
		
		//6) Mostrar la cantidad de libros que existen para cada género.
		//Los campos que se deben mostrar son ID género, descripción y cantidad.	
		print("-------------Cantidad de libros que existen para cada género ---------------" );
		List<Object[]> objects = DaoBiblioteca.obtenerCantidadLibrosPorGenero();
		for(Object[] object:objects){
			print("ID GENERO: " + object[0] + " | DESCRIPCION: " + object[1] + " | CANTIDAD: " + object[2]);
		}
		print("------------------------------------------------------------------" );
	}

	private static void ejercicioTP3() {
		int bibliotecaId = 1;
    	
    	//LISTAR
    	print("---------- Registro antes de modificar: ----------" );
    	LeerRegistro(bibliotecaId);
    	
    	// MODIFICAR
    	ModificarEstadoRegistro(bibliotecaId);
    	
    	//LISTAR
    	print("---------- Registro modificado: ----------" );
    	LeerRegistro(bibliotecaId);
    	
    	//BORRAR
    	bibliotecaId = 2;
    	print("---------- Eliminar registro ----------" );
    	BorrarRegistro(bibliotecaId);
    	
    	//Imprime todos los registros creados en la tabla Biblioteca
    	print("---------- Listar todos los registros de la tabla Biblioteca ----------" );
    	DaoBiblioteca.findAll().stream().forEach(System.out::println);
	}
	
	private static void print(Object obj) {
		//System.out.println("\n");
		System.out.println(obj.toString());
	}
    
    private static void agregarAutores() {
    	List<Nacionalidad> nacionalidades = DaoNacionalidad.findAll();
    	
    	Nacionalidad britanico = nacionalidades.get(0); //Britanico
		Nacionalidad argentino = nacionalidades.get(1); //Argentino
		Nacionalidad estadounidense = nacionalidades.get(2); //estadounidense
		Nacionalidad aleman = nacionalidades.get(3); //aleman
    	
    	Autor autor = new Autor("J.R.R", "Tolkien", britanico, "--");
		DaoAutor.save(autor);
				
		Autor autor2 = new Autor("J. K.", "Rowling", britanico, "--");
		DaoAutor.save(autor2);
		
		Autor autor3 = new Autor("Edgardo", "Scott", argentino, "--");
		DaoAutor.save(autor3);
		
		Autor autor4 = new Autor("Nicholas", "Sparks", britanico, "--");
		DaoAutor.save(autor4);
		
		Autor autor5 = new Autor("Stephenie", "Meyer", estadounidense, "--");
		DaoAutor.save(autor5);
		
		Autor autor6 = new Autor("Albert", "Einstein", aleman, "--");
		DaoAutor.save(autor6);
		
		print("Autores agregados a la db OK");
	}

	private static void agregarGeneros() {
		Genero fantasia = new Genero("Fantasía");
		DaoGenero.save(fantasia);
		
		Genero literaturaFantastica = new Genero("Literatura Fantástica");
		DaoGenero.save(literaturaFantastica);
		
		Genero cienciaFiccion = new Genero("Ciencia Ficción");	
		DaoGenero.save(cienciaFiccion);
    	
		Genero FantasiaContemporanea = new Genero("Fantasía Contemporanea");
    	DaoGenero.save(FantasiaContemporanea);
    	
    	Genero novela = new Genero("Novela");
    	DaoGenero.save(novela);
    	
    	Genero noFiccion = new Genero("No Ficcion");
    	DaoGenero.save(noFiccion);
    	
    	Genero pandemia = new Genero("Pandemia");
    	DaoGenero.save(pandemia);
    	
    	Genero riesgo = new Genero("Riesgo");
    	DaoGenero.save(riesgo);
    	
    	Genero cineRomantico = new Genero("Cine Romantico");
    	DaoGenero.save(cineRomantico);
    	
    	Genero drama = new Genero("Drama");
    	DaoGenero.save(drama);
    	
    	Genero ficcionAdultoJoven = new Genero("Ficcion adulto joven");
    	DaoGenero.save(ficcionAdultoJoven);
    	
    	Genero ficcionRomantica = new Genero("Ficcion Romantica");
    	DaoGenero.save(ficcionRomantica);
    	
    	Genero ficcionVampiros = new Genero("Ficcion Vampiros");
    	DaoGenero.save(ficcionVampiros);
    	
    	Genero cientifico = new Genero("Cientifico");
    	DaoGenero.save(cientifico);
    	
    	print("Generos agregados a la db OK");
	}

	private static void agregarNacionalidades() {
    	Nacionalidad britanico = new Nacionalidad("Britanico");
    	DaoNacionalidad.save(britanico);
    	Nacionalidad argentino = new Nacionalidad("Argentino");
    	DaoNacionalidad.save(argentino);
    	Nacionalidad estadounidense = new Nacionalidad("Estadounidense");
    	DaoNacionalidad.save(estadounidense);
    	Nacionalidad aleman = new Nacionalidad("Aleman");
    	DaoNacionalidad.save(aleman);
    	
    	print("Nacionalidades agregados a la db OK");
	}

	public static void nuevoRegistro1(List<Autor> autores, List<Genero> generos) throws ParseException {
		Autor autor = autores.get(0); //Tolkien
		
		Set<Genero> generosLibro = new HashSet();		
		generosLibro.add(generos.get(0)); //Fantasia
		generosLibro.add(generos.get(1)); //Literatura Fantástica
		generosLibro.add(generos.get(2)); //Ciencia Ficción

		Libro libro = new Libro(
				"9788445003022", 
				"El Señor de los Anillos", 
				DateUtils.parseFromText("01/02/2021"), 
				IdiomaEnum.ESPANIOL, 
				1392,
				autor, 
				"Los Anillos de Poder fueron forjados en antiguos tiempos por los herreros Elfos, y Sauron, el Señor Oscuro, forjó el Anillo Único..", 
				generosLibro);
		
		Biblioteca biblioteca = new Biblioteca(libro, DateUtils.parseFromText("20/10/2021"), EstadoLibroEnum.EN_BIBLIOTECA);
		
		DaoBiblioteca.save(biblioteca);
		
		print(biblioteca);
    }
   
    public static void nuevoRegistro2(List<Autor> autores, List<Genero> generos) throws ParseException {
    	
		Autor autor = autores.get(1); //Rowling
		
		Set<Genero> generosLibro = new HashSet();		
		generosLibro.add(generos.get(3)); //Fantasía Contemporanea
		generosLibro.add(generos.get(1)); //Literatura Fantástica
		generosLibro.add(generos.get(4)); //Novela
    	
    	Libro libro = new Libro(
    			"1788445003023", 
    			"Harry Potter", 
    			DateUtils.parseFromText("01/12/2019"), 
    			IdiomaEnum.ESPANIOL, 
    			3400,
    			autor, 
    			"Las aventuras del joven aprendiz de magia y hechicería Harry Potter y sus amigos Hermione Granger y Ron Weasley, durante los años que pasan en el Colegio Hogwarts de Magia y Hechicería.", 
    			generosLibro);
    	
    	Biblioteca biblioteca = new Biblioteca(libro, DateUtils.parseFromText("19/04/2022"), EstadoLibroEnum.EN_BIBLIOTECA);
    	
    	DaoBiblioteca.save(biblioteca);
    	
    	print(biblioteca);
    }
        
    public static void nuevoRegistro3(List<Autor> autores, List<Genero> generos) throws ParseException {
    	
		Autor autor = autores.get(2); //Scott
		
		Set<Genero> generosLibro = new HashSet();		
		generosLibro.add(generos.get(5)); //No Ficcion
		generosLibro.add(generos.get(6)); //Pandemia
		generosLibro.add(generos.get(7)); //Riesgo

    	Libro libro = new Libro(
    			"2788445033025", 
    			"Contacto", 
    			DateUtils.parseFromText("01/08/2001"), 
    			IdiomaEnum.ESPANIOL, 
    			853,
    			autor, 
    			"Dispuesto a recuperar lo que parece perdido, como ya hizo Odiseo en la isla de Calipso (pero con Internet), Scott echa mano a lo que tienen todos los aislados..", 
    			generosLibro);
    	
    	Biblioteca biblioteca = new Biblioteca(libro, DateUtils.parseFromText("17/05/2020"), EstadoLibroEnum.PRESTADO);
    	
    	DaoBiblioteca.save(biblioteca);
    	
    	print(biblioteca);
    }
    
    public static void nuevoRegistro4(List<Autor> autores, List<Genero> generos) throws ParseException {
    	
    	Autor autor = autores.get(3); //Sparks

    	Set<Genero> generosLibro = new HashSet<Genero>();
    	generosLibro.add(generos.get(4));//Novela
    	generosLibro.add(generos.get(8));//Cine Romantico
    	generosLibro.add(generos.get(9));//Drama

    	Libro libro = new Libro(
    			"5588445033026", 
    			"Diario de una Pasion", 
    			DateUtils.parseFromText("12/05/2021"), 
    			IdiomaEnum.INGLES, 
    			853,
    			autor, 
    			"Una dolorosa historia sobre el poder duradero del amor y sus milagros. Un hombre tiene un cuaderno viejo, traído y llevado mil veces, en su regazo.", 
    			generosLibro);
    	
    	Biblioteca biblioteca = new Biblioteca(libro, DateUtils.parseFromText("01/02/2022"), EstadoLibroEnum.PRESTADO);
    	
    	DaoBiblioteca.save(biblioteca);
    	
    	print(biblioteca);
    }
    
    public static void nuevoRegistro5(List<Autor> autores, List<Genero> generos) throws ParseException {

     	Autor autor = autores.get(4); //Meyer

    	Set<Genero> generosLibro = new HashSet<Genero>();
    	generosLibro.add(generos.get(10));//Ficcion adulto joven
    	generosLibro.add(generos.get(11));//Ficcion romantica
    	generosLibro.add(generos.get(12));//Ficcion Vampiros
    	
    	Libro libro = new Libro(
    			"9998445033029", 
    			"Crepusculo", 
    			DateUtils.parseFromText("20/10/2006"), 
    			IdiomaEnum.ESPANIOL, 
    			853,
    			autor, 
    			"Cuando Edward Cullen y Bella Swan se conocieron en «Crepúsculo», nació una historia de amor icónica.", 
    			generosLibro);
    	
    	Biblioteca biblioteca = new Biblioteca(libro, DateUtils.parseFromText("28/05/2017"), EstadoLibroEnum.EN_BIBLIOTECA);
    	
    	DaoBiblioteca.save(biblioteca);
    	
    	print(biblioteca);
    }
    
    public static void nuevoRegistro6(List<Autor> autores, List<Genero> generos) throws ParseException {

    	Autor autor = autores.get(5); //Einstein

    	Set<Genero> generosLibro = new HashSet<Genero>();
    	generosLibro.add(generos.get(13));//Cientifico
    	
    	Libro libro = new Libro(
    			"9788420609744", 
    			"Sobre la teoria de la relatividad especial y general", 
    			DateUtils.parseFromText("23/08/2010"), 
    			IdiomaEnum.ALEMAN, 
    			168,
    			autor, 
    			"Obra publicada en 1917, pocos años antes de que Albert Einstein (1879-1955) estableciera definitivamente las famosas ecuaciones de campo de la relatividad general.", 
    			generosLibro);
    	
    	Biblioteca biblioteca = new Biblioteca(libro, DateUtils.parseFromText("01/02/2022"), EstadoLibroEnum.PRESTADO);
    	
    	DaoBiblioteca.save(biblioteca);
    	
    	print(biblioteca);
    }
    
    public static void ModificarEstadoRegistro(int id) {
    	Biblioteca ModificarBiblioteca = DaoBiblioteca.findById(id);
    	ModificarBiblioteca.setEstado(EstadoLibroEnum.PRESTADO);
    	
    	DaoBiblioteca.update(ModificarBiblioteca);
    }
   
    public static void BorrarRegistro(int id) {
    	Biblioteca BorrarBiblioteca = DaoBiblioteca.findById(id); 
    	print(BorrarBiblioteca);
    	
    	DaoBiblioteca.delete(BorrarBiblioteca);  
    }
 
    public static void LeerRegistro(int id) {  
    	Biblioteca registroBiblioteca = DaoBiblioteca.findById(id);
		print(registroBiblioteca);
	}
}
