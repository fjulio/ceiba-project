package com.ceiba.adn.parqueadero.dominio;

public enum EstadoIngreso {

	SALIDA(2,"salida"),
	INGRESO(1, "ingreso");
	
	private int id;
	private String estado;
	
	EstadoIngreso(int id, String estado) {
		this.id = id;
		this.estado = estado;
	}
	
	public int id() {
		return id;
	}
	
	public String estado() {
		return estado;
	}
}
