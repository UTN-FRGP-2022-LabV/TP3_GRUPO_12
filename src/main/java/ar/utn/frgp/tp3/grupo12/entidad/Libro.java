package ar.utn.frgp.tp3.grupo12.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ar.utn.frgp.tp3.grupo12.enums.IdiomaEnum;
import ar.utn.frgp.tp3.grupo12.utils.DateUtils;

@Entity
@Table(name="LIBROS")
public class Libro implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ISBN", nullable=false)
	private String isbn;

	@Column(name="TITULO", nullable=false)
	private String titulo;
	
	@Column(name="FECHA_LANZAMIENTO", nullable=false)
	private Date fechaDeLanzamiento;

	@Enumerated(EnumType.STRING)
	@Column(name="IDIOMA", nullable=false)
	private IdiomaEnum idioma;
	
	@Column(name="CANTIDAD_PAGINAS", nullable=false)
	private Integer cantidadDePaginas;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_AUTOR")
	private Autor autor;
	
	@Column(name="DESCRIPCION", nullable=false)
	private String descripcion;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="LIBROS_X_GENERO", joinColumns= {@JoinColumn(name="ISBN_LIBRO")}, inverseJoinColumns= {@JoinColumn(name="ID_GENERO")})
	private Set<Genero> generos = new HashSet<Genero>();
	
	public Libro() {
	}
	
	public Libro(String isbn, String titulo, Date fechaDeLanzamiento, IdiomaEnum idioma, Integer cantidadDePaginas,
			Autor autor, String descripcion, Set<Genero> generos) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.fechaDeLanzamiento = fechaDeLanzamiento;
		this.idioma = idioma;
		this.cantidadDePaginas = cantidadDePaginas;
		this.autor = autor;
		this.descripcion = descripcion;
		this.generos = generos;
	}



	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaDeLanzamiento() {
		return fechaDeLanzamiento;
	}

	public void setFechaDeLanzamiento(Date fechaDeLanzamiento) {
		this.fechaDeLanzamiento = fechaDeLanzamiento;
	}

	public IdiomaEnum getIdioma() {
		return idioma;
	}

	public void setIdioma(IdiomaEnum idioma) {
		this.idioma = idioma;
	}

	public Integer getCantidadDePaginas() {
		return cantidadDePaginas;
	}

	public void setCantidadDePaginas(Integer cantidadDePaginas) {
		this.cantidadDePaginas = cantidadDePaginas;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(Set<Genero> generos) {
		this.generos = generos;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", fechaDeLanzamiento=" + DateUtils.formatFromDate(fechaDeLanzamiento) + ", idioma="
				+ idioma + ", cantidadDePaginas=" + cantidadDePaginas + ", autor=" + autor + ", descripcion="
				+ descripcion + ", generos=" + generos + "]";
	}
	
	
}
