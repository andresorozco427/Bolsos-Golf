package com.ceiba.excepcion;

public class ExcepcionCantidadDePedidoSuperaStock extends RuntimeException{


	private static final long serialVersionUID = -5605595579008430803L;

	public ExcepcionCantidadDePedidoSuperaStock(String message) {
		super(message);
	}

	
}
