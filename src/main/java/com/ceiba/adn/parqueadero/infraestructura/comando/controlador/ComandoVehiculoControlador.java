package com.ceiba.adn.parqueadero.infraestructura.comando.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ceiba.adn.parqueadero.aplicacion.comando.ComandoVehiculo;
import com.ceiba.adn.parqueadero.aplicacion.comando.manipula.ManipularComandoRegistrarIngreso;
import com.ceiba.adn.parqueadero.aplicacion.comando.manipula.ManipularComandoRegistrarSalida;
import com.ceiba.adn.parqueadero.comun.aplicacion.ComandoRespuesta;

@RestControllerAdvice
@RestController
@RequestMapping("/vehiculo")
@CrossOrigin("*")public class ComandoVehiculoControlador{

	private ManipularComandoRegistrarIngreso comandoRegistrarIngreso;
	
	private ManipularComandoRegistrarSalida comandoRegistrarSalida;

	@Autowired
	public ComandoVehiculoControlador(ManipularComandoRegistrarIngreso comandoRegistrarIngreso,
			ManipularComandoRegistrarSalida comandoRegistrarSalida) {
		this.comandoRegistrarIngreso = comandoRegistrarIngreso;
		this.comandoRegistrarSalida = comandoRegistrarSalida;
	}
	
	
	
	@PostMapping
	public ComandoRespuesta<Long> registrarIngreso(@RequestBody ComandoVehiculo comandoVehiculo){
		return comandoRegistrarIngreso.ejecutar(comandoVehiculo);
	}
	
	@PutMapping
	public ComandoRespuesta<ComandoVehiculo> registrarSalida(@RequestBody ComandoVehiculo comandoVehiculo){
		return comandoRegistrarSalida.ejecutar(comandoVehiculo);
	}
}
