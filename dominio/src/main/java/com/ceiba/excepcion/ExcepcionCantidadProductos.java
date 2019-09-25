package com.ceiba.excepcion;

public class ExcepcionCantidadProductos extends RuntimeException{


	private static final long serialVersionUID = 2687467082870300737L;

	public ExcepcionCantidadProductos(String message) {
		super(message);
	}
	
}
