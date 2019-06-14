package com.ceiba.adn.parqueadero.infraestructura.comando.repositorio.impl;

import org.springframework.stereotype.Component;

import com.ceiba.adn.parqueadero.dominio.Vehiculo;
import com.ceiba.adn.parqueadero.dominio.comando.repositorio.ComandoRepositorioVehiculo;
import com.ceiba.adn.parqueadero.infraestructura.mapeo.VehiculoMapeoImpl;
import com.ceiba.adn.parqueadero.infraestructura.repositorio.RepositorioJPA;

@Component
public class ComandoRepositorioVehiculoImpl implements ComandoRepositorioVehiculo {

	private RepositorioJPA repositorioJPA;
	
	private VehiculoMapeoImpl vehiculoMapeoImpl = VehiculoMapeoImpl.getInstance();

	public ComandoRepositorioVehiculoImpl(RepositorioJPA repositorioJPA) {
		this.repositorioJPA = repositorioJPA;
	}
	
	@Override
	public Vehiculo registrarIngreso(Vehiculo vehiculo) {
		return vehiculoMapeoImpl.mapearDesdeEntidad(repositorioJPA.save(vehiculoMapeoImpl.mapearAEntidad(vehiculo)));
	}

	@Override
	public void borrarIngresoVehiculo(Vehiculo vehiculo) {
		
	}
	
	
}
