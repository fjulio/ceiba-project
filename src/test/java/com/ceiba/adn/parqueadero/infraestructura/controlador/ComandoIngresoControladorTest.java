package com.ceiba.adn.parqueadero.infraestructura.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.adn.AplicacionMock;
import com.ceiba.adn.parqueadero.aplicacion.comando.manipula.ManipularComandoRegistrarIngreso;
import com.ceiba.adn.parqueadero.aplicacion.consulta.manipula.ManipularConsultaVehiculos;
import com.ceiba.adn.parqueadero.dominio.comando.repositorio.ComandoRepositorioVehiculo;
import com.ceiba.adn.parqueadero.dominio.repositorio.ConsultaRepositorioVehiculo;
import com.ceiba.adn.parqueadero.infraestructura.comando.controlador.ComandoVehiculoControlador;
import com.ceiba.adn.parqueadero.infraestructura.consulta.controlador.ConsultaVehiculoControlador;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AplicacionMock.class)
@WebMvcTest({ ComandoVehiculoControlador.class, ConsultaVehiculoControlador.class })
public class ComandoIngresoControladorTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ConsultaRepositorioVehiculo consultaRepositorioVehiculo;
	
	@MockBean
	private ComandoRepositorioVehiculo comandoRepositorioVehiculo;
	
	@MockBean
	private ManipularComandoRegistrarIngreso comandoRegistrarIngreso;
	
	@MockBean
	private ManipularConsultaVehiculos manipularConsultaVehiculos;
	
	@Test
	public void checkList() throws Exception {

		// Act
		//this.mockMvc.perform(get("/vehiculo")).andDo(print()).andExpect(status().isAccepted()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
	
}
