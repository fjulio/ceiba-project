package com.ceiba.adn.parqueadero.dominio.comando.estrategia.aproximacion;

import java.util.HashMap;
import java.util.Map;

public class BuilderAproximacion {

	private static final String ESTRATEGIA_GENERAL = "GENERAL";
	
	private static final Map<String, IAproximacion> ESTRATEGIAS_APROXIMACION = new HashMap<>();
	
	static {
		ESTRATEGIAS_APROXIMACION.put(ESTRATEGIA_GENERAL, new AproximacionImpl());
	}
	
	private BuilderAproximacion() {
		throw new IllegalStateException("Construyendo estrategias de aproximacion");
	}
	
	public static IAproximacion obtenerEstrategia(String estrategia) {
		return ESTRATEGIAS_APROXIMACION.get(estrategia);
	}
}
