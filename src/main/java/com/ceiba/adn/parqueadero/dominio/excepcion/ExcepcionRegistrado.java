package com.ceiba.adn.parqueadero.dominio.excepcion;

public class ExcepcionRegistrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionRegistrado(String mensaje) {
		super(mensaje);
	}
}
