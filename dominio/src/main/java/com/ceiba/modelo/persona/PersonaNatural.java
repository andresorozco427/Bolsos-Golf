package com.ceiba.modelo.persona;

public class PersonaNatural extends AbstractPersona{
	private static final String CEDULA_OBLIGATORIA = "La cedula es obligatoria";
	private static final String CEDULA_INVALIDA = "La cedula ingresada es invalida";
	private static final int LONGITUD_CEDULA = 8;
	
	private String cedula;
	
	public PersonaNatural(String nombre, String direccion, String email, String tipoPersona, String ciudad,
			String telefono, boolean calificacion) {
		super(nombre, direccion, email, tipoPersona, ciudad, telefono, calificacion);
	}

	public PersonaNatural(String nombre, String direccion, String email, String tipoPersona, String ciudad,String telefono,
			boolean calificacion, String cedula) {
		super(nombre, direccion, email, tipoPersona, ciudad, telefono, calificacion);
		ValidarArgumentosPersona.validarArgumentosCedula(cedula, CEDULA_OBLIGATORIA);
		ValidarArgumentosPersona.validarArgumentosLongitudCedula(cedula, LONGITUD_CEDULA, CEDULA_INVALIDA);
		this.cedula = cedula;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
}
