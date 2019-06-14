package com.ceiba.adn.parqueadero.infraestructura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ceiba.adn.parqueadero.dominio.Vehiculo;
import com.ceiba.adn.parqueadero.infraestructura.entidad.EntidadVehiculo;


public interface RepositorioJPA extends CrudRepository<EntidadVehiculo, Long> {

	List<EntidadVehiculo> findAll();
	
	@Query("select count(*) from EntidadVehiculo v where v.tipoVehiculo = :tipoVehiculo and v.estado = 1")
	int obtenerVehiculosIngresados(@Param("tipoVehiculo") String tipoVehiculo);
	
	@Query("select v from EntidadVehiculo v where v.placa = :placa")
	Vehiculo existeIngreso(@Param("placa") String placa); 
}
