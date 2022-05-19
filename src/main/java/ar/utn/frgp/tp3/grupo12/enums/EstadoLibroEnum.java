package ar.utn.frgp.tp3.grupo12.enums;

public enum EstadoLibroEnum {
	EN_BIBLIOTECA("EN_BIBLIOTECA"),
	PRESTADO("PRESTADO");
	
	public final String value;
	
	private EstadoLibroEnum(String value) {
		this.value = value;
	}
}
