package com.ceiba.adn.parqueadero.dominio;

public enum EstadoIngreso {

	OCUPADO(2,"Ocupado"),
	DISPONIBLE(1, "Disponible");
	
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
