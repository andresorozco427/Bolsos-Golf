package com.ceiba.excepcion;

public class ExcepcionCategoriaYaExistente extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6178833537496653833L;

	public ExcepcionCategoriaYaExistente(String message) {
		super(message);
	}

	
}
