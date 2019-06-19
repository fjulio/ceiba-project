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
import com.ceiba.adn.parqueadero.dominio.excepcion.ExcepcionRegistrado;
import com.ceiba.adn.parqueadero.dominio.modelo.PrecioParqueadero;
import com.ceiba.adn.parqueadero.dominio.repositorio.ConsultaRepositorioVehiculo;

public class ServicioRegistrarSalidaTest {

	private static final Long LIMITE_HORAS_DIA = 9L;
	private static final Long CANTIDAD_HORA_DIA = 24L;

	@Test
	public void testPagoVehiculoNoEncontrado() {

		String mensaje = "El vehiculo no ha ingresado al parqueadero";

		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		Vehiculo vehiculo = vehiculoDatosPrueba.construir();

		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);

		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(null);

		ServicioRegistrarSalida servicioRegistrarSalida = new ServicioRegistrarSalida(consultaRepositorioVehiculo,
				comandoRepositorioVehiculo);

		PruebaBase.assertThrows(() -> servicioRegistrarSalida.ejecutar(vehiculo.getPlaca()), ExcepcionRegistrado.class,
				mensaje);
	}

	@Test
	public void testPagoCarroTiempoMenorHora() {

		Double precioEsperado = PrecioParqueadero.CARROHORA.valor() * 1;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - 1);

		Date fechaSalidaAlterada = cal.getTime();
		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		Vehiculo vehiculo = vehiculoDatosPrueba.fechaIngreso(fechaSalidaAlterada).estado(1).construir();

		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(vehiculo);

		ServicioRegistrarSalida servicioRegistrarSalida = new ServicioRegistrarSalida(consultaRepositorioVehiculo,
				comandoRepositorioVehiculo);

		servicioRegistrarSalida.ejecutar(vehiculo.getPlaca());

		assertEquals(precioEsperado, vehiculo.getPago(), 0);

	}

	@Test
	public void testPagoCarroTiempoDosHoras() {
		Double precioEsperado = PrecioParqueadero.CARROHORA.valor() * 2;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - 1);
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - 1);

		Date fechaSalidaAlterada = cal.getTime();
		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		Vehiculo vehiculo = vehiculoDatosPrueba.fechaIngreso(fechaSalidaAlterada).estado(1).construir();

		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(vehiculo);

		ServicioRegistrarSalida servicioRegistrarSalida = new ServicioRegistrarSalida(consultaRepositorioVehiculo,
				comandoRepositorioVehiculo);

		servicioRegistrarSalida.ejecutar(vehiculo.getPlaca());

		assertEquals(precioEsperado, vehiculo.getPago(), 0);
	}

	@Test
	public void testPagoCarroMenorNueveHoras() {
		Double precioEsperado = PrecioParqueadero.CARROHORA.valor() * LIMITE_HORAS_DIA;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - 1);
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - (LIMITE_HORAS_DIA.intValue() - 1));

		Date fechaSalidaAlterada = cal.getTime();
		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		Vehiculo vehiculo = vehiculoDatosPrueba.fechaIngreso(fechaSalidaAlterada).estado(1).construir();

		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(vehiculo);

		ServicioRegistrarSalida servicioRegistrarSalida = new ServicioRegistrarSalida(consultaRepositorioVehiculo,
				comandoRepositorioVehiculo);

		servicioRegistrarSalida.ejecutar(vehiculo.getPlaca());

		assertEquals(precioEsperado, vehiculo.getPago(), 0);
	}

	@Test
	public void testPagoCarroPorDia() {

		Double precioEsperado = PrecioParqueadero.CARRODIA.valor() * 1;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - 1);
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - LIMITE_HORAS_DIA.intValue());

		Date fechaSalidaAlterada = cal.getTime();
		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		Vehiculo vehiculo = vehiculoDatosPrueba.fechaIngreso(fechaSalidaAlterada).estado(1).construir();

		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(vehiculo);

		ServicioRegistrarSalida servicioRegistrarSalida = new ServicioRegistrarSalida(consultaRepositorioVehiculo,
				comandoRepositorioVehiculo);

		servicioRegistrarSalida.ejecutar(vehiculo.getPlaca());

		assertEquals(precioEsperado, vehiculo.getPago(), 0);
	}

	@Test
	public void testPagoCarroPorDiaYHora() {

		Double precioEsperado = PrecioParqueadero.CARRODIA.valor() * 1 + PrecioParqueadero.CARROHORA.valor() * 4;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - 1);
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - CANTIDAD_HORA_DIA.intValue() - 3);

		Date fechaSalidaAlterada = cal.getTime();
		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		Vehiculo vehiculo = vehiculoDatosPrueba.fechaIngreso(fechaSalidaAlterada).estado(1).construir();

		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(vehiculo);

		ServicioRegistrarSalida servicioRegistrarSalida = new ServicioRegistrarSalida(consultaRepositorioVehiculo,
				comandoRepositorioVehiculo);

		servicioRegistrarSalida.ejecutar(vehiculo.getPlaca());

		assertEquals(precioEsperado, vehiculo.getPago(), 0);
	}

	@Test
	public void testPagoMotoMenorHora() {

		Double precioEsperado = PrecioParqueadero.MOTOHORA.valor() * 1;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - 1);

		Date fechaSalidaAlterada = cal.getTime();
		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		Vehiculo vehiculo = vehiculoDatosPrueba
				.fechaIngreso(fechaSalidaAlterada)
				.tipoVehiculo(TipoVehiculo.MOTO.tipo())
				.cilindraje(200)
				.estado(1)
				.construir();

		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(vehiculo);

		ServicioRegistrarSalida servicioRegistrarSalida = new ServicioRegistrarSalida(consultaRepositorioVehiculo,
				comandoRepositorioVehiculo);

		servicioRegistrarSalida.ejecutar(vehiculo.getPlaca());

		assertEquals(precioEsperado, vehiculo.getPago(), 0);
	}
	
	@Test
	public void testPagoMotoTiempoDosHora() {

		Double precioEsperado = PrecioParqueadero.MOTOHORA.valor() * 2;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - 1);
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - 1);

		Date fechaSalidaAlterada = cal.getTime();
		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		Vehiculo vehiculo = vehiculoDatosPrueba
				.fechaIngreso(fechaSalidaAlterada)
				.tipoVehiculo(TipoVehiculo.MOTO.tipo())
				.cilindraje(200)
				.estado(1)
				.construir();

		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(vehiculo);

		ServicioRegistrarSalida servicioRegistrarSalida = new ServicioRegistrarSalida(consultaRepositorioVehiculo,
				comandoRepositorioVehiculo);

		servicioRegistrarSalida.ejecutar(vehiculo.getPlaca());

		assertEquals(precioEsperado, vehiculo.getPago(), 0);
	}
	
	@Test
	public void testPagoMotoTiempoMenorNueveHora() {

		Double precioEsperado = PrecioParqueadero.MOTOHORA.valor() * LIMITE_HORAS_DIA;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - 1);
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - (LIMITE_HORAS_DIA.intValue() - 1));

		Date fechaSalidaAlterada = cal.getTime();
		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		Vehiculo vehiculo = vehiculoDatosPrueba
				.fechaIngreso(fechaSalidaAlterada)
				.tipoVehiculo(TipoVehiculo.MOTO.tipo())
				.cilindraje(200)
				.estado(1)
				.construir();

		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(vehiculo);

		ServicioRegistrarSalida servicioRegistrarSalida = new ServicioRegistrarSalida(consultaRepositorioVehiculo,
				comandoRepositorioVehiculo);

		servicioRegistrarSalida.ejecutar(vehiculo.getPlaca());

		assertEquals(precioEsperado, vehiculo.getPago(), 0);
	}
	
	@Test
	public void testPagoMotoDia() {

		Double precioEsperado = PrecioParqueadero.MOTODIA.valor() * 1;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - 1);
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - LIMITE_HORAS_DIA.intValue());

		Date fechaSalidaAlterada = cal.getTime();
		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		Vehiculo vehiculo = vehiculoDatosPrueba
				.fechaIngreso(fechaSalidaAlterada)
				.tipoVehiculo(TipoVehiculo.MOTO.tipo())
				.cilindraje(200)
				.estado(1)
				.construir();

		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(vehiculo);

		ServicioRegistrarSalida servicioRegistrarSalida = new ServicioRegistrarSalida(consultaRepositorioVehiculo,
				comandoRepositorioVehiculo);

		servicioRegistrarSalida.ejecutar(vehiculo.getPlaca());

		assertEquals(precioEsperado, vehiculo.getPago(), 0);
	}
	
	@Test
	public void testPagoMotoDiaYHora() {

		Double precioEsperado = PrecioParqueadero.MOTODIA.valor() * 1 + PrecioParqueadero.MOTOHORA.valor() * 4;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - 1);
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - CANTIDAD_HORA_DIA.intValue() - 3);

		Date fechaSalidaAlterada = cal.getTime();
		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		Vehiculo vehiculo = vehiculoDatosPrueba
				.fechaIngreso(fechaSalidaAlterada)
				.tipoVehiculo(TipoVehiculo.MOTO.tipo())
				.cilindraje(200)
				.estado(1)
				.construir();

		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(vehiculo);

		ServicioRegistrarSalida servicioRegistrarSalida = new ServicioRegistrarSalida(consultaRepositorioVehiculo,
				comandoRepositorioVehiculo);

		servicioRegistrarSalida.ejecutar(vehiculo.getPlaca());

		assertEquals(precioEsperado, vehiculo.getPago(), 0);
	}
	
	@Test
	public void testPagoMotoDiaYHoraYCilindrajeMayorQuiniento() {

		Double precioEsperado = PrecioParqueadero.MOTODIA.valor() * 1 + PrecioParqueadero.MOTOHORA.valor() * 4 + PrecioParqueadero.MOTOCILINDRAJE.valor();

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - 1);
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - CANTIDAD_HORA_DIA.intValue() - 3);

		Date fechaSalidaAlterada = cal.getTime();
		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		Vehiculo vehiculo = vehiculoDatosPrueba
				.fechaIngreso(fechaSalidaAlterada)
				.tipoVehiculo(TipoVehiculo.MOTO.tipo())
				.estado(1)
				.construir();

		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(vehiculo);

		ServicioRegistrarSalida servicioRegistrarSalida = new ServicioRegistrarSalida(consultaRepositorioVehiculo,
				comandoRepositorioVehiculo);

		servicioRegistrarSalida.ejecutar(vehiculo.getPlaca());

		assertEquals(precioEsperado, vehiculo.getPago(), 0);
	}
	
	@Test
	public void testPagoMotoDiaConCilindrajeMayorAQuiniento() {

		Double precioEsperado = PrecioParqueadero.MOTODIA.valor() * 1 + PrecioParqueadero.MOTOCILINDRAJE.valor();

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - 1);
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - LIMITE_HORAS_DIA.intValue());

		Date fechaSalidaAlterada = cal.getTime();
		VehiculoDatosPrueba vehiculoDatosPrueba = new VehiculoDatosPrueba();
		Vehiculo vehiculo = vehiculoDatosPrueba
				.fechaIngreso(fechaSalidaAlterada)
				.tipoVehiculo(TipoVehiculo.MOTO.tipo())
				.estado(1)
				.construir();

		ConsultaRepositorioVehiculo consultaRepositorioVehiculo = Mockito.mock(ConsultaRepositorioVehiculo.class);
		ComandoRepositorioVehiculo comandoRepositorioVehiculo = Mockito.mock(ComandoRepositorioVehiculo.class);
		Mockito.when(consultaRepositorioVehiculo.existeIngreso(Mockito.anyString())).thenReturn(vehiculo);

		ServicioRegistrarSalida servicioRegistrarSalida = new ServicioRegistrarSalida(consultaRepositorioVehiculo,
				comandoRepositorioVehiculo);

		servicioRegistrarSalida.ejecutar(vehiculo.getPlaca());

		assertEquals(precioEsperado, vehiculo.getPago(), 0);
	}
}
