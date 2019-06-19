package com.ceiba.adn.parqueadero.comun.comando;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CapturarFecha extends StdDeserializer<Date> {

	public CapturarFecha() {
		this(null);
	}

	public CapturarFecha(Class<?> vc) {
		super(vc);
	}
	
	private static final long serialVersionUID = 1L;

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String date = p.getText();
		try {
			SimpleDateFormat formato = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
			return formato.parse(date);
		} catch (Exception e) {
			return null;
		}
	}

}
