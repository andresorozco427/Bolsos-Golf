package com.ceiba.modelo.persona;

public abstract class AbstractPersona {
	private static final String NOMBRE_OBLIGATORIO = "El nombre es obligatorio";
	private static final String TELEFONO_OBLIGATORIO = "El telefono es obligatorio";
	private static final String DIRECCION_OBLIGATORIO = "La direccion es obligatorio";
	private static final String EMAIL_INVALIDO = "La direccion de email es invalida";
	private static final String TIPOPERSONA_OBLIGATORIO = "El tipo de persona es obligatorio";
	private static final String CIUDAD_OBLIGATORIO = "La ciudad es obligatoria";
	
	
	private String nombre;
	private String telefono;
	private String direccion;
	private String email;
	private String tipoPersona;
	private String ciudad;
	private boolean calificacion;	
	
	public AbstractPersona(String nombre, String direccion, String email, String tipoPersona, String ciudad,String telefono,
			boolean calificacion) {
		ValidarArgumentosPersona.validarArgumentosNombre(nombre, NOMBRE_OBLIGATORIO);
		ValidarArgumentosPersona.validarArgumentosTelefono(telefono, TELEFONO_OBLIGATORIO);
		ValidarArgumentosPersona.validarArgumentosDireccion(direccion, DIRECCION_OBLIGATORIO);
		ValidarArgumentosPersona.validarArgumentosEmail(email, EMAIL_INVALIDO);
		ValidarArgumentosPersona.validarArgumentosTipoPersona(tipoPersona, TIPOPERSONA_OBLIGATORIO);
		ValidarArgumentosPersona.validarArgumentosCiudad(ciudad, CIUDAD_OBLIGATORIO);
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
		this.tipoPersona = tipoPersona;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.calificacion = calificacion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public boolean getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(boolean calificacion) {
		this.calificacion = calificacion;
	}
	
	
}
