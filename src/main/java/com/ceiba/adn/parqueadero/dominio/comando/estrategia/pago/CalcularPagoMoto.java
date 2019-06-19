package com.ceiba.adn.parqueadero.dominio.comando.estrategia.pago;

import java.util.Date;

import com.ceiba.adn.parqueadero.dominio.Vehiculo;
import com.ceiba.adn.parqueadero.dominio.comando.estrategia.aproximacion.BuilderAproximacion;
import com.ceiba.adn.parqueadero.dominio.comando.estrategia.aproximacion.IAproximacion;
import com.ceiba.adn.parqueadero.dominio.modelo.PrecioParqueadero;

public class CalcularPagoMoto implements ICalcularPago {

	private static final Double VALOR_HORA_MILISEGUNDO = 3600000d;
	private static final Long CANTIDAD_HORA_DIA = 24L;
	private static final Double CONVERTIR_A_DIAS = VALOR_HORA_MILISEGUNDO * CANTIDAD_HORA_DIA;
	private static final Long LIMITE_HORAS_DIA = 9L;
	private static final String ESTRATEGIA_GENERAL = "GENERAL";
	private static final int CILINDRAJE_SUPERIOR = 500;

	@Override
	public Double calcularPago(Vehiculo vehiculo) {

		Date fechaIngreso = vehiculo.getHoraIngreso();
		Date fechaSalida = vehiculo.getHoraSalida();
		int diasParqueado = (int) ((fechaSalida.getTime() - fechaIngreso.getTime()) / CONVERTIR_A_DIAS);
		double horasParqueado = ((fechaSalida.getTime() - fechaIngreso.getTime()) / VALOR_HORA_MILISEGUNDO);

		horasParqueado -= diasParqueado * CANTIDAD_HORA_DIA;

		if (horasParqueado >= LIMITE_HORAS_DIA) {
			diasParqueado++;
			horasParqueado = 0;
		}

		IAproximacion aproximacion = BuilderAproximacion.obtenerEstrategia(ESTRATEGIA_GENERAL);
		int horasAproximadas = aproximacion.aproximacion(horasParqueado);

		double valorAPagar = (PrecioParqueadero.MOTODIA.valor() * diasParqueado)
				+ (PrecioParqueadero.MOTOHORA.valor() * horasAproximadas);
		if (vehiculo.getCilindraje() > CILINDRAJE_SUPERIOR) {
			valorAPagar += PrecioParqueadero.MOTOCILINDRAJE.valor();
		}
		return valorAPagar;
	}

}
