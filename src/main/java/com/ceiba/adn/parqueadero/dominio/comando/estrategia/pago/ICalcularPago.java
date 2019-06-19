package com.ceiba.adn.parqueadero.dominio.comando.estrategia.pago;

import com.ceiba.adn.parqueadero.dominio.Vehiculo;

public interface ICalcularPago {

	Double calcularPago(Vehiculo vehiculo);
}
