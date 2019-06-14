package com.ceiba.adn.parqueadero.aplicacion.comando.manipula;

import org.springframework.stereotype.Component;

import com.ceiba.adn.parqueadero.aplicacion.comando.ComandoVehiculo;
import com.ceiba.adn.parqueadero.aplicacion.comando.fabrica.FabricarIngresoVehiculo;
import com.ceiba.adn.parqueadero.comun.aplicacion.ComandoRespuesta;
import com.ceiba.adn.parqueadero.comun.manipula.ComandoManipulaRespuesta;
import com.ceiba.adn.parqueadero.dominio.Vehiculo;
import com.ceiba.adn.parqueadero.dominio.servicio.vehiculo.ServicioRegistrarIngreso;

@Component
public class ManipularComandoRegistrarIngreso
		implements ComandoManipulaRespuesta<ComandoVehiculo, ComandoRespuesta<Long>> {

	private ServicioRegistrarIngreso servicioRegistrarIngreso;

	private FabricarIngresoVehiculo fabricarIngresoVehiculo;

	public ManipularComandoRegistrarIngreso(ServicioRegistrarIngreso servicioRegistrarIngreso) {
		this.servicioRegistrarIngreso = servicioRegistrarIngreso;
	}

	@Override
	public ComandoRespuesta<Long> ejecutar(ComandoVehiculo comando) {
		Vehiculo vehiculo = fabricarIngresoVehiculo.registrar(comando);
		return new ComandoRespuesta<>(this.servicioRegistrarIngreso.ejecutar(vehiculo));
	}

}
