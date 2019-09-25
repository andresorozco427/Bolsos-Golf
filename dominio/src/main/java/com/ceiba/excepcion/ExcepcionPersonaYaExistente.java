package com.ceiba.excepcion;

public class ExcepcionPersonaYaExistente extends RuntimeException{

	private static final long serialVersionUID = 8749704225429729144L;

	public ExcepcionPersonaYaExistente(String message) {
		super(message);
	}
	
}
