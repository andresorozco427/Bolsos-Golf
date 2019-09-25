package com.ceiba.adaptador.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_PERSON", discriminatorType = DiscriminatorType.STRING)
public abstract class PersonaEntity {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	private String nombre;
	private String telefono;
	private String direccion;
	private String email;
	private String tipoPersona;
	private String ciudad;
	private boolean calificacion;
	
	public PersonaEntity(String nombre, String telefono, String direccion, String email, String tipoPersona,
			String ciudad, boolean calificacion) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.tipoPersona = tipoPersona;
		this.ciudad = ciudad;
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

	public boolean isCalificacion() {
		return calificacion;
	}

	public void setCalificacion(boolean calificacion) {
		this.calificacion = calificacion;
	}	
	
	
	
	
}
