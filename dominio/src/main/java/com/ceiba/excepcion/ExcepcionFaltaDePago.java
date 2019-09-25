package com.ceiba.excepcion;

public class ExcepcionFaltaDePago extends RuntimeException{

	private static final long serialVersionUID = 4885709431015670397L;

	public ExcepcionFaltaDePago(String message) {
		super(message);
	}
	
}
