package com.ceiba.adn.parqueadero.infraestructura.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.adn.AplicacionMock;
import com.ceiba.adn.ParqueaderoApplication;
import com.ceiba.adn.parqueadero.aplicacion.comando.ComandoVehiculo;
import com.ceiba.adn.parqueadero.aplicacion.comando.constructorDatos.ComandoVehiculoDatosPrueba;
import com.ceiba.adn.parqueadero.comun.aplicacion.ComandoRespuesta;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AplicacionMock.class)
@SpringBootTest(classes = ParqueaderoApplication.class)
public class ComandoIngresoControladorTest {

	private MockMvc mockMvc;

	private static final String API = "/vehiculo";

	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void checkList() throws Exception {

		this.mockMvc.perform(get(API)).andExpect(status().isOk())
		// Assert
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
	
	
	@Test
	public void registrarIngreso() throws Exception {

		// Arrange
		ComandoVehiculoDatosPrueba vehiculoDatosPrueba= new ComandoVehiculoDatosPrueba();
		ComandoVehiculo comandoVehiculo= vehiculoDatosPrueba.construir();
		JSONObject vehiculoJson = new JSONObject(comandoVehiculo);
		
		
		ComandoRespuesta<Long> response = new ComandoRespuesta<>(1L);
		JSONObject responseJson = new JSONObject(response);

		// Act
		this.mockMvc.perform(post(API).contentType(MediaType.APPLICATION_JSON_UTF8).content(vehiculoJson.toString()))
				.andExpect(status().isOk()).andExpect(content().json(responseJson.toString()));
	}
	
	
	@Test
	public void registrarSalida() throws Exception {

		// Arrange
		String placa = "AFJ568";
		ComandoVehiculoDatosPrueba vehiculoDatosPrueba = new ComandoVehiculoDatosPrueba();

		ComandoVehiculo comandoVehiculo = vehiculoDatosPrueba.placa(placa).id(2L).fechaSalida(new Date()).construir();
		JSONObject entryJson = new JSONObject(comandoVehiculo);
		this.mockMvc.perform(put(API).contentType(MediaType.APPLICATION_JSON_UTF8).content(entryJson.toString()))
				.andExpect(status().isOk());
	}

}
