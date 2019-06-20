package com.ceiba.adn.parqueadero.dominio.modelo;

import java.util.Date;

public class VehiculoDTO {

	private String placa;
	
	private String tipoVehiculo;
	
	private int cilindraje;
	
	private Date horaIngreso;
	
	private Date horaSalida;
	
	private int estado;
	
	private double pago;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Date getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(Date horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public Date getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
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

	public VehiculoDTO() {
		super();
	}

	public VehiculoDTO(String placa, String tipoVehiculo, int cilindraje, Date horaIngreso, Date horaSalida, int estado,
			double pago) {
		super();
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.horaIngreso = horaIngreso;
		this.horaSalida = horaSalida;
		this.estado = estado;
		this.pago = pago;
	}
	

	
}
