package com.ceiba.adn.parqueadero.infraestructura.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vehiculo")
public class EntidadVehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 5, max = 10)
	@Column(name = "placa", nullable = false)
	private String placa;

	@Column(name = "tipo_vehiculo", nullable = false)
	private String tipoVehiculo;

	@Size(min = 2, max = 5)
	@Column(name = "cilindraje")
	private int cilindraje;

	@Column(name = "hora_ingreso")
	private Date horaIngreso;

	@Column(name = "hora_salida")
	private Date horaSalida;

	@Size(min = 2, max = 5)
	@Column(name = "estado")
	private int estado;

	@Size(min = 3, max = 10)
	@Column(name = "pago")
	private double pago;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public EntidadVehiculo() {
		super();
	}

	public EntidadVehiculo(Long id, @Size(min = 5, max = 10) String placa, String tipoVehiculo,
			@Size(min = 2, max = 5) int cilindraje, Date horaIngreso, Date horaSalida,
			@Size(min = 2, max = 5) int estado, @Size(min = 3, max = 10) double pago) {
		super();
		this.id = id;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.horaIngreso = horaIngreso;
		this.horaSalida = horaSalida;
		this.estado = estado;
		this.pago = pago;
	}

}
