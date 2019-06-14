package com.ceiba.adn.parqueadero.infraestructura.consulta.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ceiba.adn.parqueadero.aplicacion.consulta.manipula.ManipularConsultaVehiculos;
import com.ceiba.adn.parqueadero.dominio.modelo.VehiculoDTO;
import com.ceiba.adn.parqueadero.dominio.utilidades.Respuesta;

@RestControllerAdvice
@RestController
@RequestMapping("/vehiculo")
@CrossOrigin("*")
public class ConsultaVehiculoControlador {

	private ManipularConsultaVehiculos manejador;
	
	@Autowired
	public ConsultaVehiculoControlador(ManipularConsultaVehiculos manejador) {
		this.manejador = manejador;
	}
	
	@GetMapping
	public Respuesta<List<VehiculoDTO>> obtenerVehiculos(){
		return new Respuesta<>(true, "objetos cargados", 0, manejador.obtener());
	}
}
