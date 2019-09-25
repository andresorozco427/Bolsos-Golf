package com.ceiba.modelo.producto;

import com.ceiba.excepcion.ExcepcionValoresObligatorios;

public class ValidarArgumentosCategoria {
	
	private ValidarArgumentosCategoria() {
		
	}
	
	public static void validarArgumentoNombre(Object nombre, String mensaje) {
		if(nombre == null) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}
}
