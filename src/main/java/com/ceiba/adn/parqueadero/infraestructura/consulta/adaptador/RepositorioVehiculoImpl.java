package com.ceiba.adn.parqueadero.infraestructura.consulta.adaptador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.adn.parqueadero.dominio.Vehiculo;
import com.ceiba.adn.parqueadero.dominio.modelo.VehiculoDTO;
import com.ceiba.adn.parqueadero.dominio.repositorio.ConsultaRepositorioVehiculo;
import com.ceiba.adn.parqueadero.infraestructura.mapeo.VehiculoMapeoImpl;
import com.ceiba.adn.parqueadero.infraestructura.repositorio.RepositorioJPA;

@Component
public class RepositorioVehiculoImpl implements ConsultaRepositorioVehiculo{

	private RepositorioJPA repositorioJPA;
	
	private final VehiculoMapeoImpl  vehiculoMapeoImpl = VehiculoMapeoImpl.getInstance();
	
	@Autowired
	public RepositorioVehiculoImpl(RepositorioJPA repositorioJPA) {
		this.repositorioJPA = repositorioJPA;
	}
	
	@Override
	public List<VehiculoDTO> findAll() {
		return this.vehiculoMapeoImpl.mapearListaEntidad(repositorioJPA.findAll());
	}

	@Override
	public int obtenerVehiculosIngresados(String tipoVehiculo) {
		return repositorioJPA.obtenerVehiculosIngresados(tipoVehiculo);
	}

	@Override
	public Vehiculo existeIngreso(String placa) {
		return this.vehiculoMapeoImpl.mapearDesdeEntidad(repositorioJPA.existeIngreso(placa));
	}

}
