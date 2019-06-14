package com.ceiba.adn.parqueadero.comun.manipula;

import javax.transaction.Transactional;

public interface ComandoManipulaRespuesta<C, R>  {

	@Transactional
	R ejecutar(C comando);
}
