package com.ceiba.adn.parqueadero.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.adn.parqueadero.aplicacion.comando.ComandoVehiculo;
import com.ceiba.adn.parqueadero.dominio.Vehiculo;

@Component
public class FabricarIngresoVehiculo {

	public static final FabricarIngresoVehiculo INSTANCIA = new FabricarIngresoVehiculo();
	
	public FabricarIngresoVehiculo getInstance() {
		return INSTANCIA;
	}
	
	public Vehiculo registrar(ComandoVehiculo comandoVehiculo) {
		return new Vehiculo(comandoVehiculo.getId(), comandoVehiculo.getPlaca(), comandoVehiculo.getTipoVehiculo(), comandoVehiculo.getCilindraje(),
				comandoVehiculo.getHoraIngreso(), comandoVehiculo.getHoraSalida(), comandoVehiculo.getEstado(), comandoVehiculo.getPago());
	}
}
