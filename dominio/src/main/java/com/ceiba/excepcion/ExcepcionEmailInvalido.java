package com.ceiba.excepcion;

public class ExcepcionEmailInvalido extends RuntimeException{

	private static final long serialVersionUID = -8774266523847260067L;

	public ExcepcionEmailInvalido(String message) {
		super(message);
	}
	

}
