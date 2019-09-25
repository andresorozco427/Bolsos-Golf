package com.ceiba.testdatabuilder;

import com.ceiba.modelo.persona.PersonaJuridica;
import com.ceiba.modelo.persona.PersonaNatural;
import com.ceiba.modelo.persona.Proveedor;

public class PersonaTestDataBuilder {
	
	private String cedula;
	private String nit;
	private String nombre;
	private String telefono;
	private String direccion;
	private String email;
	private String tipoPersona;
	private String ciudad;
	private boolean calificacion;	
	private String material;
	private float precio;
	
	public PersonaTestDataBuilder() {
		this.cedula = "716745361";
		this.nit = "99909093123-5";
		this.nombre = "Fauto Murillo";
		this.telefono = "4567643";
		this.direccion = "Cra 141 #45-65";
		this.email = "Andres@gmail.com";
		this.tipoPersona = "natural";
		this.ciudad = "Medellin";
		this.calificacion = true;
		this.material = "tela";
		this.precio = 3000;
	}
	
	public PersonaTestDataBuilder conCedula(String cedula) {
		this.cedula = cedula;
		return this;
	}	
	
	public PersonaTestDataBuilder conNit(String nit) {
		this.nit = nit;
		return this;
	}	
	
	public PersonaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}	
	
	public PersonaTestDataBuilder conTelefono(String telefono) {
		this.telefono = telefono;
		return this;
	}
	
	public PersonaTestDataBuilder conDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}
	
	public PersonaTestDataBuilder conEmail(String email) {
		this.email = email;
		return this;
	}
	
	public PersonaTestDataBuilder conTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
		return this;
	}
	
	public PersonaTestDataBuilder conCiudad(String ciudad) {
		this.ciudad = ciudad;
		return this;
	}
	
	public PersonaTestDataBuilder conCalificacion(boolean calificacion) {
		this.calificacion = calificacion;
		return this;
	}
	
	public PersonaTestDataBuilder conMaterial(String material) {
		this.material = material;
		return this;
	}
	
	public PersonaTestDataBuilder conPrecio(float precio) {
		this.precio = precio;
		return this;
	}
	
	public Proveedor buildProveedor() {
		return new Proveedor(nombre, direccion, email, tipoPersona, ciudad, calificacion, cedula, material, precio, telefono);
	}
	
	public PersonaNatural buildPersonaNatural() {
		return new PersonaNatural(nombre, direccion, email, tipoPersona, ciudad, telefono, calificacion, cedula);
	}
	
	public PersonaJuridica buildPersonaJuridica() {
		return new PersonaJuridica(nombre, direccion, email, tipoPersona, ciudad, telefono, calificacion, nit);
	}
	
}
