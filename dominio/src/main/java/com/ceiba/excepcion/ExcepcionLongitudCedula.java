package com.ceiba.excepcion;

public class ExcepcionLongitudCedula extends RuntimeException{


	private static final long serialVersionUID = 3124843019735723411L;

	public ExcepcionLongitudCedula(String message) {
		super(message);
	}
	
}
