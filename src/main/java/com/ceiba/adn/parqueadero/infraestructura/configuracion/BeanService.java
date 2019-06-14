package com.ceiba.adn.parqueadero.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.adn.parqueadero.dominio.comando.repositorio.ComandoRepositorioVehiculo;
import com.ceiba.adn.parqueadero.dominio.repositorio.ConsultaRepositorioVehiculo;
import com.ceiba.adn.parqueadero.dominio.servicio.vehiculo.ServicioRegistrarIngreso;
import com.ceiba.adn.parqueadero.dominio.servicio.vehiculo.ServicioRegistrarSalida;

@Configuration
public class BeanService {

	@Bean
	public ServicioRegistrarIngreso comandoCrearServicioIngreso(ConsultaRepositorioVehiculo consultaRepositorioVehiculo, ComandoRepositorioVehiculo comandoRepositorioVehiculo) {
		return new ServicioRegistrarIngreso(consultaRepositorioVehiculo, comandoRepositorioVehiculo);
	}
	
	@Bean
	public ServicioRegistrarSalida comandoServicioRegistrarSalida(ConsultaRepositorioVehiculo consultaRepositorioVehiculo, ComandoRepositorioVehiculo comandoRepositorioVehiculo) {
		return new ServicioRegistrarSalida(consultaRepositorioVehiculo, comandoRepositorioVehiculo);
	}
}
