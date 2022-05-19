package ar.utn.frgp.tp3.grupo12.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ar.utn.frgp.tp3.grupo12.enums.EstadoLibroEnum;

@Entity
@Table(name="BIBLIOTECA_REFS")
public class Biblioteca implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@OneToOne(fetch=FetchType.EAGER, cascade= {CascadeType.ALL})
	@JoinColumn(name="ISBN_LIBRO")
	private Libro libro;

	@Column(name="FECHA_ALTA", nullable=false)
	private Date fechaDeAlta;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ESTADO", nullable=false)
	private EstadoLibroEnum estado;
	
	public Biblioteca() {
	}

	
	public Biblioteca(Libro libro, Date fechaDeAlta, EstadoLibroEnum estado) {
		super();
		this.libro = libro;
		this.fechaDeAlta = fechaDeAlta;
		this.estado = estado;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(Date fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	public EstadoLibroEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoLibroEnum estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Biblioteca [id=" + id + ", libro=" + libro + ", fechaDeAlta=" + fechaDeAlta + ", estado=" + estado
				+ "]";
	}

	
}
