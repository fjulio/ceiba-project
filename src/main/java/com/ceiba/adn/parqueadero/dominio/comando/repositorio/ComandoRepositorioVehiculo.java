package com.ceiba.adn.parqueadero.dominio.comando.repositorio;

import com.ceiba.adn.parqueadero.dominio.Vehiculo;

public interface ComandoRepositorioVehiculo {

	Vehiculo registrarIngreso(Vehiculo vehiculo);
	
	void borrarIngresoVehiculo(Vehiculo vehiculo);
}
