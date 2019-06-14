package com.ceiba.adn.parqueadero.dominio.servicio.vehiculo;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.adn.parqueadero.dominio.TipoVehiculo;
import com.ceiba.adn.parqueadero.dominio.Vehiculo;
import com.ceiba.adn.parqueadero.dominio.comando.repositorio.ComandoRepositorioVehiculo;
import com.ceiba.adn.parqueadero.dominio.excepcion.ExcepcionNoPermiteIngreso;
import com.ceiba.adn.parqueadero.dominio.repositorio.ConsultaRepositorioVehiculo;

public class ServicioRegistrarIngreso {
	
    private static final int LIMITE_CARRO = 20;
    
    private static final int LIMITE_MOTO = 10;
    
    private static final String NO_EXISTE_CUPO_DISPONIBLE = "El parqueadero no tiene cupo disponible para el tipo de vehiculo.";
    
    private static final String PLACA_LETRA_INICIAL_A = "A";
    
    private static final String NO_PERMITE_INGRESO_PLACAS_A = "Las placas inicializadas con la letra A, solo tienen permitido el ingreso los días domingo y lunes";
    
	private final ConsultaRepositorioVehiculo consultaRepositorioVehiculo;
	
	private final ComandoRepositorioVehiculo comandoRepositorioVehiculo;
	
	public ServicioRegistrarIngreso(ConsultaRepositorioVehiculo repositorioVehiculo, ComandoRepositorioVehiculo comandoRepositorioVehiculo) {
		this.consultaRepositorioVehiculo = repositorioVehiculo;
		this.comandoRepositorioVehiculo = comandoRepositorioVehiculo;
	}

	public Long ejecutar(Vehiculo vehiculo) {
		validarDisponibilidadPorTipoVehiculo(vehiculo.getTipoVehiculo());
		validarDisponibilidadPorInicialPlaca(vehiculo.getPlaca(), vehiculo.getHoraIngreso());
		return this.comandoRepositorioVehiculo.registrarIngreso(vehiculo).getId();
	}
	
	private void validarDisponibilidadPorTipoVehiculo(String tipoVehiculo) {
		int cantidadVehiculos = this.consultaRepositorioVehiculo.obtenerVehiculosIngresados(tipoVehiculo);
		if(tipoVehiculo.equalsIgnoreCase(TipoVehiculo.CARRO.name()) && cantidadVehiculos >= LIMITE_CARRO 
				||  tipoVehiculo.equalsIgnoreCase(TipoVehiculo.MOTO.name()) && cantidadVehiculos >= LIMITE_MOTO )
			throw new ExcepcionNoPermiteIngreso(NO_EXISTE_CUPO_DISPONIBLE);
	}
	
	private void validarDisponibilidadPorInicialPlaca(String placa, Date fechaIngreso) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaIngreso);
		int dia = cal.get(Calendar.DAY_OF_WEEK);
		
		if(placa != null && placa.startsWith(PLACA_LETRA_INICIAL_A)  && dia > Calendar.MONDAY)
			throw new ExcepcionNoPermiteIngreso(NO_PERMITE_INGRESO_PLACAS_A);
	}
	
}
