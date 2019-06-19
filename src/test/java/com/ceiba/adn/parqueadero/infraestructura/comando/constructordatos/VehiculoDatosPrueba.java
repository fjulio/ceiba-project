package com.ceiba.adn.parqueadero.infraestructura.comando.constructordatos;

import java.util.Date;

import com.ceiba.adn.parqueadero.dominio.EstadoIngreso;
import com.ceiba.adn.parqueadero.dominio.TipoVehiculo;
import com.ceiba.adn.parqueadero.dominio.Vehiculo;

public class VehiculoDatosPrueba {

	private Long id;
	
	private String placa;
	
	private int cilindraje;
	
	private String tipoVehiculo;
	
	private Date fechaIngreso;
	
	private Date fechaSalida;
	
	private int estado;
	
	private double pago;

	public VehiculoDatosPrueba() {
		this.id = 1L;
		this.placa = "JKM459";
		this.cilindraje = 2000;
		this.tipoVehiculo = TipoVehiculo.CARRO.tipo();
		this.fechaIngreso = new Date();
		this.estado = EstadoIngreso.INGRESO.id();
	}
	
	public VehiculoDatosPrueba placa(String placa) {
	  this.placa = placa;
	  return this;
	}
	
	public VehiculoDatosPrueba fechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	public VehiculoDatosPrueba tipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}
	
	public VehiculoDatosPrueba fechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}
	
	public VehiculoDatosPrueba estado(int estado) {
		this.estado = estado;
		return this;
	}
	
	public VehiculoDatosPrueba cilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public Vehiculo construir() {
		return new Vehiculo(id, placa, tipoVehiculo, cilindraje, fechaIngreso, fechaSalida, estado, pago);
	}
	
}
