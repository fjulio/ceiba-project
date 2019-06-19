package com.ceiba.adn.parqueadero.dominio.comando.estrategia.aproximacion;

public class AproximacionImpl implements IAproximacion {

	@Override
	public int aproximacion(double valor) {
		int integerPart = (int) valor;
		return valor > integerPart ? integerPart + 1 : integerPart;
	}

}
