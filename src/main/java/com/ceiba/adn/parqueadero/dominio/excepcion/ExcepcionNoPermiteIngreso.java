package com.ceiba.adn.parqueadero.dominio.excepcion;

public class ExcepcionNoPermiteIngreso extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionNoPermiteIngreso(String message) {
		super(message);
	}
}
