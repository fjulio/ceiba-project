package com.ceiba.adn.parqueadero.dominio.utilidades;

public class Respuesta<T> {

	private boolean success;

	private String message;

	private int idError;

	private T data;

	public Respuesta() {

	}

	public Respuesta(String message) {
		super();
		this.message = message;
		this.success = true;
	}

	public Respuesta(boolean success, String message, int idError, T data) {
		super();
		this.success = success;
		this.message = message;
		this.idError = idError;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getIdError() {
		return idError;
	}

	public void setIdError(int idError) {
		this.idError = idError;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
