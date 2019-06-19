package com.ceiba.adn.parqueadero.dominio.excepcion;

public class ExcepcionVehiculoNoIngresado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionVehiculoNoIngresado(String mensaje) {
		super(mensaje);
	}
}