package com.ceiba.adn.parqueadero.aplicacion.comando.manipula;

import org.springframework.stereotype.Component;

import com.ceiba.adn.parqueadero.aplicacion.comando.ComandoVehiculo;
import com.ceiba.adn.parqueadero.comun.aplicacion.ComandoRespuesta;
import com.ceiba.adn.parqueadero.comun.manipula.ComandoManipulaRespuesta;
import com.ceiba.adn.parqueadero.dominio.Vehiculo;
import com.ceiba.adn.parqueadero.dominio.servicio.vehiculo.ServicioRegistrarSalida;

@Component
public class ManipularComandoRegistrarSalida implements ComandoManipulaRespuesta<ComandoVehiculo, ComandoRespuesta<ComandoVehiculo>> {

	private ServicioRegistrarSalida registrarSalida;
	
	public ManipularComandoRegistrarSalida(ServicioRegistrarSalida registrarSalida) {
		this.registrarSalida = registrarSalida;
	}
	
	@Override
	public ComandoRespuesta<ComandoVehiculo> ejecutar(ComandoVehiculo comandoVehiculo){
		Vehiculo vehiculo = this.registrarSalida.ejecutar(comandoVehiculo.getPlaca());
		return new ComandoRespuesta<>(new ComandoVehiculo(vehiculo.getId(),vehiculo.getPlaca(), vehiculo.getCilindraje(), vehiculo.getTipoVehiculo(), vehiculo.getHoraIngreso(), vehiculo.getHoraSalida(), vehiculo.getEstado(), vehiculo.getPago()));
	}
}
