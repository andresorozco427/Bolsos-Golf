package com.ceiba.excepcion;

public class ExcepcionCantidadMaximaProductos extends RuntimeException{

	private static final long serialVersionUID = -2587327152430136975L;

	public ExcepcionCantidadMaximaProductos(String message) {
		super(message);
	}
	
	
}
