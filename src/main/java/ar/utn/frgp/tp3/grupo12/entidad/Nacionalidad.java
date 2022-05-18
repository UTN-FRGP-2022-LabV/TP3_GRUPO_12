package ar.utn.frgp.tp3.grupo12.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NACIONALIDADES")
public class Nacionalidad implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="DESCRIPCION", nullable=false)
	private String descripcion;
	
	public Nacionalidad() {
	}

	
	public Nacionalidad(String descripcion) {
		super();
		this.descripcion = descripcion;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Nacionalidad [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	
}
