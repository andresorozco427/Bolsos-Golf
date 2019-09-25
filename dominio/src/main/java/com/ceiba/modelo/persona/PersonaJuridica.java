package com.ceiba.modelo.persona;

public class PersonaJuridica extends AbstractPersona{
	private static final String NIT_OBLIGATORIO = "El nit es obligatorio";
	private static final String NIT_INVALIDO = "El nit ingresado es invalido";
	private static final int LONGITUD_NIT = 11;

	private String nit;
	
	
	public PersonaJuridica(String nombre, String direccion, String email, String tipoPersona, String ciudad,
			String telefono, boolean calificacion) {
		super(nombre, direccion, email, tipoPersona, ciudad, telefono, calificacion);
	}

	public PersonaJuridica(String nombre, String direccion, String email, String tipoPersona, String ciudad,String telefono,
			boolean calificacion, String nit) {		
		super(nombre, direccion, email, tipoPersona, ciudad, telefono, calificacion);
		ValidarArgumentosPersona.validarArgumentosNit(nit, NIT_OBLIGATORIO);
		ValidarArgumentosPersona.validarArgumentosLongitudNit(nit, LONGITUD_NIT, NIT_INVALIDO);
		this.nit = nit;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

}
