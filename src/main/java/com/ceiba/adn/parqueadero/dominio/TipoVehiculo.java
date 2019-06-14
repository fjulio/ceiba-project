package com.ceiba.adn.parqueadero.dominio;

public enum TipoVehiculo {
	
	CARRO(1,"Carro"),
	MOTO(2,"Moto");
	
	private int id;
	private String tipo;

	TipoVehiculo(int id, String tipo){
		this.tipo = tipo;
		this.id = id;
	}
	
	public String tipo() {
		return tipo;
	}
	
	public int id() {
		return id;
	}
	
}
