package com.ceiba.modelo.persona;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ceiba.excepcion.ExcepcionEmailInvalido;
import com.ceiba.excepcion.ExcepcionLongitudCedula;
import com.ceiba.excepcion.ExcepcionNitInvalido;
import com.ceiba.excepcion.ExcepcionValoresObligatorios;

public class ValidarArgumentosPersona {
	
	private ValidarArgumentosPersona() {}
	
	public static void validarArgumentosCedula(Object cedula, String mensaje) {
		if(cedula == null) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}
	
	public static void validarArgumentosLongitudCedula(String cedula, int longitud, String mensaje) {
		if(cedula.length() > longitud) {
			throw new ExcepcionLongitudCedula(mensaje);
		}
	}
	
	public static void validarArgumentosNit(Object nit, String mensaje) {
		if(nit == null) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}
	
	public static void validarArgumentosLongitudNit(String nit, int longitud ,String mensaje) {
		if(nit.length() > longitud || nit.substring(9, 10).contentEquals("-")) {
			throw new ExcepcionNitInvalido(mensaje);
		}
	}
	
	
	public static void validarArgumentosNombre(Object nombre, String mensaje) {
		if(nombre == null) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}
	
	public static void validarArgumentosTelefono(Object telefono, String mensaje) {
		if(telefono == null) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}
	
	public static void validarArgumentosDireccion(Object direccion, String mensaje) {
		if(direccion == null) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}	
	
	public static void validarArgumentosEmail(String email, String mensaje) {
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(email);
		if(!matcher.find()) {
			throw new ExcepcionEmailInvalido(mensaje);
		}
	}
	
	public static void validarArgumentosTipoPersona(Object tipoPersona, String mensaje) {
		if(tipoPersona == null) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}	
	
	public static void validarArgumentosCiudad(Object ciudad, String mensaje) {
		if(ciudad == null) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}	
	
	public static void validarArgumentosMaterialProveedor(Object material, String mensaje) {
		if(material == null) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}	
	
	public static void validarArgumentosPrecioMaterial(float precio, String mensaje) {
		if(precio == 0) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}	
}
