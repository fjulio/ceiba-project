package com.ceiba.adn.parqueadero.aplicacion.comando;

import java.util.Date;

import com.ceiba.adn.parqueadero.comun.comando.CapturarFecha;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ComandoVehiculo {

	private long id;

	private String placa;

	private int cilindraje;

	private String tipoVehiculo;

	@JsonDeserialize(using = CapturarFecha.class)
	private Date horaIngreso;

	@JsonDeserialize(using = CapturarFecha.class)
	private Date horaSalida;

	private int estado;

	private double pago;

	public ComandoVehiculo(long id, String placa, int cilindraje, String tipoVehiculo, Date horaIngreso,
			Date horaSalida, int estado, double pago) {
		super();
		this.id = id;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipoVehiculo = tipoVehiculo;
		this.horaIngreso = horaIngreso;
		this.horaSalida = horaSalida;
		this.estado = estado;
		this.pago = pago;
	}

	public ComandoVehiculo() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

}
