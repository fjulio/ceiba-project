package com.ceiba.adn.parqueadero.aplicacion.comando.constructorDatos;

import java.util.Date;

import com.ceiba.adn.parqueadero.aplicacion.comando.ComandoVehiculo;
import com.ceiba.adn.parqueadero.dominio.EstadoIngreso;
import com.ceiba.adn.parqueadero.dominio.TipoVehiculo;


public class ComandoVehiculoDatosPrueba {
	
	private long id;
	
	private String placa;
	
	private int cilindraje;
	
	private String tipoVehiculo;
	
	private Date horaIngreso;
	
	private Date horaSalida;
	
	private int estado;
	
	private double pago;

	public ComandoVehiculoDatosPrueba() {
		this.placa = "JKM459";
		this.cilindraje = 2000;
		this.tipoVehiculo = TipoVehiculo.CARRO.tipo();
		this.horaIngreso = new Date();
		this.estado = EstadoIngreso.INGRESO.id();
	}
	
	public ComandoVehiculoDatosPrueba placa(String placa) {
	  this.placa = placa;
	  return this;
	}
	
	public ComandoVehiculoDatosPrueba fechaIngreso(Date fechaIngreso) {
		this.horaIngreso = fechaIngreso;
		return this;
	}
	
	public ComandoVehiculoDatosPrueba tipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}
	
	public ComandoVehiculoDatosPrueba fechaSalida(Date fechaSalida) {
		this.horaSalida = fechaSalida;
		return this;
	}
	
	public ComandoVehiculoDatosPrueba estado(int estado) {
		this.estado = estado;
		return this;
	}
	
	public ComandoVehiculoDatosPrueba cilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}

	public ComandoVehiculoDatosPrueba id(Long id) {
		this.id = id;
		return this;
	}
	
	public ComandoVehiculo construir() {
		return new ComandoVehiculo(this.id,this.placa, this.cilindraje, this.tipoVehiculo, this.horaIngreso, this.horaSalida, this.estado, this.pago);
	}
	
}
