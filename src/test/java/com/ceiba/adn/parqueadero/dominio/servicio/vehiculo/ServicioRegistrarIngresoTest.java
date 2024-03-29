package com.ceiba.adn.parqueadero.dominio.servicio.vehiculo;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.adn.PruebaBase;
import com.ceiba.adn.parqueadero.dominio.TipoVehiculo;
import com.ceiba.adn.parqueadero.dominio.Vehiculo;
import com.ceiba.adn.parqueadero.dominio.comando.repositorio.ComandoRepositorioVehiculo;
import com.ceiba.adn.parqueadero.dominio.comando.testdata.VehiculoDatosPrueba;
import com.ceiba.adn.parqueadero.dominio.excepcion.ExcepcionNoPermiteIngreso;
import com.ceiba.adn.parqueadero.dominio.excepcion.ExcepcionRegistrado;
import com.ceiba.adn.parqueadero.dominio.repositorio.ConsultaRepositorioVehiculo;

public class ServicioRegistrarIngresoTest {

	@Test
	public void validarIngresoVehiculoConInicialPlacaA() {
		
		String mensajeNoPermitidoIngreso = "Las placas inicializadas con la letra A, solo tienen permitido el ingreso los dias domingo y lunes";
		int limite = 20;
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		
		Date fechaIngreso = cal.getTime();
		
		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		vehiculoDatosPrueba.placa("AJM789").fechaIngreso(fechaIngreso);
		Vehiculo vehiculo = vehiculoDatosPrueba.construir();
		
		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(null);
		Mockito.when(consultaRepositorioVehiculo.obtenerVehiculosIngresados(Mockito.anyString())).thenReturn(limite);
		Mockito.when(comandoRepositorioVehiculo.registrarIngresoSalidaVehiculo(vehiculo)).thenReturn(vehiculo);
	
		ServicioRegistrarIngreso servicioRegistrarIngreso = new ServicioRegistrarIngreso(consultaRepositorioVehiculo, comandoRepositorioVehiculo);
		
		PruebaBase.assertThrows(() -> servicioRegistrarIngreso.ejecutar(vehiculo), ExcepcionNoPermiteIngreso.class,
			mensajeNoPermitidoIngreso);
		
	}
	
	@Test
	public void validarLimiteDeVehiculoTipoCarro() {
		
		String mensajeNoPermitidoIngreso = "El parqueadero no tiene cupo disponible para el tipo de vehiculo.";
		int limite = 20;
		
		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		vehiculoDatosPrueba.placa("MJK895").tipoVehiculo(TipoVehiculo.CARRO.tipo());
		Vehiculo vehiculo = vehiculoDatosPrueba.construir();
		
		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(null);
		Mockito.when(consultaRepositorioVehiculo.obtenerVehiculosIngresados(Mockito.anyString())).thenReturn(limite);
		Mockito.when(comandoRepositorioVehiculo.registrarIngresoSalidaVehiculo(vehiculo)).thenReturn(vehiculo);
	
		ServicioRegistrarIngreso servicioRegistrarIngreso = new ServicioRegistrarIngreso(consultaRepositorioVehiculo, comandoRepositorioVehiculo);
		
		PruebaBase.assertThrows(() -> servicioRegistrarIngreso.ejecutar(vehiculo), ExcepcionNoPermiteIngreso.class,
			mensajeNoPermitidoIngreso);
		
	}
	
	@Test
	public void validarLimiteDeVehiculoTipoMoto() {
		
		String mensajeNoPermitidoIngreso = "El parqueadero no tiene cupo disponible para el tipo de vehiculo.";
		int limite = 20;
		
		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		vehiculoDatosPrueba.placa("MJK895").tipoVehiculo(TipoVehiculo.MOTO.tipo());
		Vehiculo vehiculo = vehiculoDatosPrueba.construir();
		
		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(null);
		Mockito.when(consultaRepositorioVehiculo.obtenerVehiculosIngresados(Mockito.anyString())).thenReturn(limite);
		Mockito.when(comandoRepositorioVehiculo.registrarIngresoSalidaVehiculo(vehiculo)).thenReturn(vehiculo);
	
		ServicioRegistrarIngreso servicioRegistrarIngreso = new ServicioRegistrarIngreso(consultaRepositorioVehiculo, comandoRepositorioVehiculo);
		
		PruebaBase.assertThrows(() -> servicioRegistrarIngreso.ejecutar(vehiculo), ExcepcionNoPermiteIngreso.class,
			mensajeNoPermitidoIngreso);
		
	}
	
	
	@Test
	public void insertar() {
		int limite = 10;
		VehiculoDatosPrueba datosPrueba = new VehiculoDatosPrueba();
		datosPrueba.placa("KRM549");
		Vehiculo vehiculo = datosPrueba.construir();
		
		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(null);
		Mockito.when(consultaRepositorioVehiculo.obtenerVehiculosIngresados(Mockito.anyString())).thenReturn(limite);
		Mockito.when(comandoRepositorioVehiculo.registrarIngresoSalidaVehiculo(vehiculo)).thenReturn(vehiculo);
	
		ServicioRegistrarIngreso servicioRegistrarIngreso = new ServicioRegistrarIngreso(consultaRepositorioVehiculo, comandoRepositorioVehiculo);
		
		Long id = servicioRegistrarIngreso.ejecutar(vehiculo);
		
		assertEquals(id, vehiculo.getId());
				
	}
}
