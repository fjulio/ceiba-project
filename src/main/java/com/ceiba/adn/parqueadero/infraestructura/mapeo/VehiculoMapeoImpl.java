package com.ceiba.adn.parqueadero.infraestructura.mapeo;

import java.util.List;

import org.assertj.core.util.Lists;

import com.ceiba.adn.parqueadero.dominio.Vehiculo;
import com.ceiba.adn.parqueadero.dominio.modelo.VehiculoDTO;
import com.ceiba.adn.parqueadero.infraestructura.entidad.EntidadVehiculo;
import com.ceiba.adn.parqueadero.infraestructura.excepcion.ExcepcionVehiculoNoEncontrado;

public class VehiculoMapeoImpl implements VehiculoMapeo {

	private static final String MENSAJE_VEHICULO_NO_ENCONTRADO = "El vehículo no se encuentra en el parqueadero";

	private static final VehiculoMapeoImpl INSTANCIA = new VehiculoMapeoImpl();

	public static VehiculoMapeoImpl getInstance() {
		return INSTANCIA;
	}

	@Override
	public EntidadVehiculo mapearAEntidad(Vehiculo vehiculo) {
		if (vehiculo == null)
			throw new ExcepcionVehiculoNoEncontrado(MENSAJE_VEHICULO_NO_ENCONTRADO);
		return new EntidadVehiculo(vehiculo.getId(), vehiculo.getPlaca(), vehiculo.getTipoVehiculo(),
				vehiculo.getCilindraje(), vehiculo.getHoraIngreso(), vehiculo.getHoraSalida(), vehiculo.getEstado(),
				vehiculo.getPago());
	}

	@Override
	public Vehiculo mapearDesdeEntidad(EntidadVehiculo entidadVehiculo) {
		if (entidadVehiculo == null)
			throw new ExcepcionVehiculoNoEncontrado(MENSAJE_VEHICULO_NO_ENCONTRADO);
		
		return new Vehiculo(entidadVehiculo.getId(), entidadVehiculo.getPlaca(), entidadVehiculo.getTipoVehiculo(),
				entidadVehiculo.getCilindraje(), entidadVehiculo.getHoraIngreso(), entidadVehiculo.getHoraSalida(), entidadVehiculo.getEstado(),
				entidadVehiculo.getPago());
	}

	@Override
	public List<VehiculoDTO> mapearListaEntidad(List<EntidadVehiculo> listEntidadVehiculo) {
		List<VehiculoDTO> lista = Lists.newArrayList();
		listEntidadVehiculo.forEach(entidadVehiculo -> lista.add(new VehiculoDTO(entidadVehiculo.getPlaca(),entidadVehiculo.getCilindraje(), entidadVehiculo.getTipoVehiculo(),
				 entidadVehiculo.getHoraIngreso(), entidadVehiculo.getHoraSalida(), entidadVehiculo.getEstado(),
				entidadVehiculo.getPago())));
		return lista;
	}

}
