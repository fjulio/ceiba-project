package com.ceiba.adn.parqueadero.comun.aplicacion;

public class ComandoRespuesta<T> {

	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public ComandoRespuesta(T value) {
		this.value = value;
	}

}
