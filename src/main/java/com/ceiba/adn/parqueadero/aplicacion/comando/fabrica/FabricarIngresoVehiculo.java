package com.ceiba.adn.parqueadero.aplicacion.comando.fabrica;

import com.ceiba.adn.parqueadero.aplicacion.comando.ComandoVehiculo;
import com.ceiba.adn.parqueadero.dominio.Vehiculo;

public class FabricarIngresoVehiculo {

	public static FabricarIngresoVehiculo INSTANCIA = new FabricarIngresoVehiculo();
	
	public FabricarIngresoVehiculo getInstance() {
		return INSTANCIA;
	}
	
	public Vehiculo registrar(ComandoVehiculo comandoVehiculo) {
		return new Vehiculo(null, comandoVehiculo.getPlaca(), comandoVehiculo.getTipoVehiculo(), comandoVehiculo.getCilindraje(),
				comandoVehiculo.getFechaIngreso(), comandoVehiculo.getFechaSalida(), comandoVehiculo.getEstado(), comandoVehiculo.getPago());
	}
}
