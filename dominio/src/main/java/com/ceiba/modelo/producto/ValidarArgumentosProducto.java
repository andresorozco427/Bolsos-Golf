package com.ceiba.modelo.producto;

import com.ceiba.excepcion.ExcepcionValoresObligatorios;

public class ValidarArgumentosProducto {
	
	private ValidarArgumentosProducto() {};
	
	public static void validarArgumentoNombre(Object nombre, String mensaje) {
		if(nombre == null) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}
	
	public static void validarArgumentoPrecio(float precio, String mensaje) {
		if(precio==0.0) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}
	
	public static void validarArgumentoCategoria(Object categoria, String mensaje) {
		if(categoria == null) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}
}


