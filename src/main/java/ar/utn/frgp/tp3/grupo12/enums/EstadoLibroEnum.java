package ar.utn.frgp.tp3.grupo12.enums;

public enum EstadoLibroEnum {
	EN_BIBLIOTECA(1),
	PRESTADO(2);
	
	public final int value;
	
	private EstadoLibroEnum(int value) {
		this.value = value;
	}
}
