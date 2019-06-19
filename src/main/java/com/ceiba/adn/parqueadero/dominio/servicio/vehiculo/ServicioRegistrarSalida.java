package com.ceiba.adn.parqueadero.dominio.servicio.vehiculo;

import java.util.Date;

import com.ceiba.adn.parqueadero.dominio.Vehiculo;
import com.ceiba.adn.parqueadero.dominio.comando.estrategia.pago.CalcularPagoSalida;
import com.ceiba.adn.parqueadero.dominio.comando.estrategia.pago.ICalcularPago;
import com.ceiba.adn.parqueadero.dominio.comando.repositorio.ComandoRepositorioVehiculo;
import com.ceiba.adn.parqueadero.dominio.excepcion.ExcepcionRegistrado;
import com.ceiba.adn.parqueadero.dominio.repositorio.ConsultaRepositorioVehiculo;

public class ServicioRegistrarSalida {

	private final ConsultaRepositorioVehiculo consultaRepositorioVehiculo;

	private final ComandoRepositorioVehiculo comandoRepositorioVehiculo;

	private final static String VEHICULO_NO_INGRESADO = "El vehículo no ha ingresado al parqueadero";

	public ServicioRegistrarSalida(ConsultaRepositorioVehiculo repositorioConsultasVehiculo,
			ComandoRepositorioVehiculo comandoRepositorioVehiculo) {
		this.consultaRepositorioVehiculo = repositorioConsultasVehiculo;
		this.comandoRepositorioVehiculo = comandoRepositorioVehiculo;
	}

	public Vehiculo ejecutar(String placa) {
		Vehiculo vehiculo = validaExistenciaPlaca(placa);
		vehiculo.setEstado(2);
		vehiculo.setHoraSalida(new Date());
		vehiculo.setPago(calcularValorSalida(vehiculo));
		return this.comandoRepositorioVehiculo.registrarIngresoSalidaVehiculo(vehiculo);
	}

	private Vehiculo validaExistenciaPlaca(String placa) {
		Vehiculo vehiculo = this.consultaRepositorioVehiculo.existeIngreso(placa);
		if (vehiculo == null)
			throw new ExcepcionRegistrado(VEHICULO_NO_INGRESADO);
		return vehiculo;
	}

	private double calcularValorSalida(Vehiculo vehiculo) {
		ICalcularPago calcularPago = CalcularPagoSalida.obtenerEstrategia(vehiculo.getTipoVehiculo());
		return calcularPago.calcularPago(vehiculo);
	}
}
