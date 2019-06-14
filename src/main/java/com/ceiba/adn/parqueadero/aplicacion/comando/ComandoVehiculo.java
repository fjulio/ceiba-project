package com.ceiba.adn.parqueadero.aplicacion.comando;

import java.util.Date;

public class ComandoVehiculo {

	private String placa;

	private int cilindraje;

	private String tipoVehiculo;

	private Date fechaIngreso;

	private Date fechaSalida;

	private int estado;

	private double pago;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public double getPago() {
		return pago;
	}

	public void setPago(double pago) {
		this.pago = pago;
	}

	public ComandoVehiculo() {
		super();
	}

	public ComandoVehiculo(String placa, int cilindraje, String tipoVehiculo, Date fechaIngreso, Date fechaSalida,
			int estado, double pago) {
		super();
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipoVehiculo = tipoVehiculo;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.estado = estado;
		this.pago = pago;
	}
}
