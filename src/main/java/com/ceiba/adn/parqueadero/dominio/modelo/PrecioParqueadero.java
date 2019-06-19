package com.ceiba.adn.parqueadero.dominio.modelo;

public enum PrecioParqueadero {

	MOTOHORA(1, 500d),
	CARROHORA(2, 1000d),
	MOTODIA(3, 4000d),
	CARRODIA(4, 8000d),
	MOTOCILINDRAJE(5, 2000d);
	
	private int id;
	
	private double valor;
	
	PrecioParqueadero(int id, double valor) {
		this.id = id;
		this.valor = valor;
	}
	
	public int id() {
		return id;
	}
	
	public double valor() {
		return valor;
	}
}
