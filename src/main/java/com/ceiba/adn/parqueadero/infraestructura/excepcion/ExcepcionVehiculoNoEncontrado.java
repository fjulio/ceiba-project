package com.ceiba.adn.parqueadero.infraestructura.excepcion;

public class ExcepcionVehiculoNoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionVehiculoNoEncontrado(String mensaje) {
		super(mensaje);
	}
}
