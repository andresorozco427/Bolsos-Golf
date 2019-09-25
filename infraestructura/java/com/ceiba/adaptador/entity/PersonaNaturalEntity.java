package com.ceiba.adaptador.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("natural")
public class PersonaNaturalEntity extends PersonaEntity{

	private String cedula;
	
	public PersonaNaturalEntity(String nombre, String telefono, String direccion, String email, String tipoPersona,
			String ciudad, boolean calificacion, String cedula) {
		super(nombre, telefono, direccion, email, tipoPersona, ciudad, calificacion);
		this.cedula = cedula;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}	
	

}
