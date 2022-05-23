package ar.utn.frgp.tp3.grupo12;

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

/**
 * TP 3 - Grupo 12
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
		agregarNacionalidades();
		agregarGeneros();
		agregarAutores();
		
		List<Autor> autores = DaoAutor.findAll();
		List<Genero> generos = DaoGenero.findAll();
		
		// AGREGAR
    	nuevoRegistro1(autores, generos);
    	nuevoRegistro2(autores, generos);
    	nuevoRegistro3(autores, generos);
    	nuevoRegistro4(autores, generos);
    	nuevoRegistro5(autores, generos);
    	nuevoRegistro6(autores, generos);
    	
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
    	
    	//Cerrar Session Factory
    	ConfigHibernate.cerrarSessionFactory();
    }
	
	private static void print(Object obj) {
		System.out.println("\n");
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

	public static void nuevoRegistro1(List<Autor> autores, List<Genero> generos) {
		Autor autor = autores.get(0); //Tolkien
		
		Set<Genero> generosLibro = new HashSet();		
		generosLibro.add(generos.get(0)); //Fantasia
		generosLibro.add(generos.get(1)); //Literatura Fantástica
		generosLibro.add(generos.get(2)); //Ciencia Ficción

		Libro libro = new Libro(
				"9788445003022", 
				"El Señor de los Anillos", 
				new Date(), 
				IdiomaEnum.ESPANIOL, 
				1392,
				autor, 
				"Los Anillos de Poder fueron forjados en antiguos tiempos por los herreros Elfos, y Sauron, el Señor Oscuro, forjó el Anillo Único..", 
				generosLibro);
		
		Biblioteca biblioteca = new Biblioteca(libro, new Date(), EstadoLibroEnum.EN_BIBLIOTECA);
		
		DaoBiblioteca.save(biblioteca);
		
		print(biblioteca);
    }
   
    public static void nuevoRegistro2(List<Autor> autores, List<Genero> generos) {
    	
		Autor autor = autores.get(1); //Rowling
		
		Set<Genero> generosLibro = new HashSet();		
		generosLibro.add(generos.get(3)); //Fantasía Contemporanea
		generosLibro.add(generos.get(1)); //Literatura Fantástica
		generosLibro.add(generos.get(4)); //Novela
    	
    	Libro libro = new Libro(
    			"1788445003023", 
    			"Harry Potter", 
    			new Date(), 
    			IdiomaEnum.ESPANIOL, 
    			3400,
    			autor, 
    			"Las aventuras del joven aprendiz de magia y hechicería Harry Potter y sus amigos Hermione Granger y Ron Weasley, durante los años que pasan en el Colegio Hogwarts de Magia y Hechicería.", 
    			generosLibro);
    	
    	Biblioteca biblioteca = new Biblioteca(libro, new Date(), EstadoLibroEnum.EN_BIBLIOTECA);
    	
    	DaoBiblioteca.save(biblioteca);
    	
    	print(biblioteca);
    }
        
    public static void nuevoRegistro3(List<Autor> autores, List<Genero> generos) {
    	
		Autor autor = autores.get(2); //Scott
		
		Set<Genero> generosLibro = new HashSet();		
		generosLibro.add(generos.get(5)); //No Ficcion
		generosLibro.add(generos.get(6)); //Pandemia
		generosLibro.add(generos.get(7)); //Riesgo

    	Libro libro = new Libro(
    			"2788445033025", 
    			"Contacto", 
    			new Date(), 
    			IdiomaEnum.ESPANIOL, 
    			853,
    			autor, 
    			"Dispuesto a recuperar lo que parece perdido, como ya hizo Odiseo en la isla de Calipso (pero con Internet), Scott echa mano a lo que tienen todos los aislados..", 
    			generosLibro);
    	
    	Biblioteca biblioteca = new Biblioteca(libro, new Date(), EstadoLibroEnum.PRESTADO);
    	
    	DaoBiblioteca.save(biblioteca);
    	
    	print(biblioteca);
    }
    
    public static void nuevoRegistro4(List<Autor> autores, List<Genero> generos) {
    	
    	Autor autor = autores.get(3); //Sparks

    	Set<Genero> generosLibro = new HashSet<Genero>();
    	generosLibro.add(generos.get(4));//Novela
    	generosLibro.add(generos.get(8));//Cine Romantico
    	generosLibro.add(generos.get(9));//Drama

    	Libro libro = new Libro(
    			"5588445033026", 
    			"Diario de una Pasion", 
    			new Date(), 
    			IdiomaEnum.INGLES, 
    			853,
    			autor, 
    			"Una dolorosa historia sobre el poder duradero del amor y sus milagros. Un hombre tiene un cuaderno viejo, traído y llevado mil veces, en su regazo.", 
    			generosLibro);
    	
    	Biblioteca biblioteca = new Biblioteca(libro, new Date(), EstadoLibroEnum.PRESTADO);
    	
    	DaoBiblioteca.save(biblioteca);
    	
    	print(biblioteca);
    }
    
    public static void nuevoRegistro5(List<Autor> autores, List<Genero> generos) {

     	Autor autor = autores.get(4); //Meyer

    	Set<Genero> generosLibro = new HashSet<Genero>();
    	generosLibro.add(generos.get(10));//Ficcion adulto joven
    	generosLibro.add(generos.get(11));//Ficcion romantica
    	generosLibro.add(generos.get(12));//Ficcion Vampiros
    	
    	Libro libro = new Libro(
    			"9998445033029", 
    			"Crepusculo", 
    			new Date(), 
    			IdiomaEnum.ESPANIOL, 
    			853,
    			autor, 
    			"Cuando Edward Cullen y Bella Swan se conocieron en «Crepúsculo», nació una historia de amor icónica.", 
    			generosLibro);
    	
    	Biblioteca biblioteca = new Biblioteca(libro, new Date(), EstadoLibroEnum.EN_BIBLIOTECA);
    	
    	DaoBiblioteca.save(biblioteca);
    	
    	print(biblioteca);
    }
    
    public static void nuevoRegistro6(List<Autor> autores, List<Genero> generos) {

    	Autor autor = autores.get(5); //Einstein

    	Set<Genero> generosLibro = new HashSet<Genero>();
    	generosLibro.add(generos.get(13));//Cientifico
    	
    	Libro libro = new Libro(
    			"9788420609744", 
    			"Sobre la teoria de la relatividad especial y general", 
    			new Date(), 
    			IdiomaEnum.ALEMAN, 
    			168,
    			autor, 
    			"Obra publicada en 1917, pocos años antes de que Albert Einstein (1879-1955) estableciera definitivamente las famosas ecuaciones de campo de la relatividad general.", 
    			generosLibro);
    	
    	Biblioteca biblioteca = new Biblioteca(libro, new Date(), EstadoLibroEnum.PRESTADO);
    	
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
