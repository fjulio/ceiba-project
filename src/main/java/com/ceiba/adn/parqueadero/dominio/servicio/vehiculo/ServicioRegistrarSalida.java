package com.ceiba.adn.parqueadero.dominio.servicio.vehiculo;

import com.ceiba.adn.parqueadero.dominio.comando.repositorio.ComandoRepositorioVehiculo;
import com.ceiba.adn.parqueadero.dominio.repositorio.ConsultaRepositorioVehiculo;

public class ServicioRegistrarSalida {

	private final ConsultaRepositorioVehiculo consultaRepositorioVehiculo;
	
	private final ComandoRepositorioVehiculo comandoRepositorioVehiculo;
	
	public ServicioRegistrarSalida(ConsultaRepositorioVehiculo repositorioConsultasVehiculo, ComandoRepositorioVehiculo comandoRepositorioVehiculo) {
		this.consultaRepositorioVehiculo = repositorioConsultasVehiculo;
		this.comandoRepositorioVehiculo = comandoRepositorioVehiculo;
	}
}
