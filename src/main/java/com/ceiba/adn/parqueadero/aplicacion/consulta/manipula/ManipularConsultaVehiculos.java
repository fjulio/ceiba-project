package com.ceiba.adn.parqueadero.aplicacion.consulta.manipula;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.adn.parqueadero.dominio.modelo.VehiculoDTO;
import com.ceiba.adn.parqueadero.dominio.repositorio.ConsultaRepositorioVehiculo;

@Component
public class ManipularConsultaVehiculos {

	private ConsultaRepositorioVehiculo consultaRepositorioVehiculo;
	
	public ManipularConsultaVehiculos(ConsultaRepositorioVehiculo consultaRepositorioVehiculo){
		this.consultaRepositorioVehiculo = consultaRepositorioVehiculo;
	}
	
	public List<VehiculoDTO> obtener(){
		return consultaRepositorioVehiculo.findAll();
	}
}
