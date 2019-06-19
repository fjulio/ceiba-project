package com.ceiba.adn.parqueadero.dominio.comando.estrategia.pago;

import java.util.HashMap;
import java.util.Map;

import com.ceiba.adn.parqueadero.dominio.TipoVehiculo;

public class CalcularPagoSalida {

	private static final Map<String, ICalcularPago> PAGO_PARQUEADERO = new HashMap<String, ICalcularPago>();

	private CalcularPagoSalida() {
		throw new IllegalStateException("Calculando pago");
	}

	static {
		PAGO_PARQUEADERO.put(TipoVehiculo.CARRO.tipo(), new CalcularPagoCarro());
		PAGO_PARQUEADERO.put(TipoVehiculo.MOTO.tipo(), new CalcularPagoMoto());
	}

	public static ICalcularPago obtenerEstrategia(String estrategia) {
		return PAGO_PARQUEADERO.get(estrategia);
	}
}
