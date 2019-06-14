package com.ceiba.adn.parqueadero.infraestructura.mapeo;

import java.util.List;

import com.ceiba.adn.parqueadero.dominio.Vehiculo;
import com.ceiba.adn.parqueadero.dominio.modelo.VehiculoDTO;
import com.ceiba.adn.parqueadero.infraestructura.entidad.EntidadVehiculo;

public interface VehiculoMapeo {

	EntidadVehiculo mapearAEntidad(Vehiculo vehiculo);

	Vehiculo mapearDesdeEntidad(EntidadVehiculo entidadVehiculo);
	
	List<VehiculoDTO> mapearListaEntidad(List<EntidadVehiculo> listEntidadVehiculo);
}
