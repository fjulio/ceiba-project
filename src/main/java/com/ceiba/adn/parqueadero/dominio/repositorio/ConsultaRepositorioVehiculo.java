package com.ceiba.adn.parqueadero.dominio.repositorio;

import java.util.List;

import com.ceiba.adn.parqueadero.dominio.Vehiculo;
import com.ceiba.adn.parqueadero.dominio.modelo.VehiculoDTO;

public interface ConsultaRepositorioVehiculo {
	
	List<VehiculoDTO> findAll();
	
	int obtenerVehiculosIngresados(String tipoVehiculo);

	Vehiculo existeIngreso(String placa);
}
