package com.ceiba.adaptador.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("juridica")
public class PersonaJuridicaEntity extends PersonaEntity{
	
	private String nit;

	public PersonaJuridicaEntity(String nombre, String telefono, String direccion, String email, String tipoPersona,
			String ciudad, boolean calificacion, String nit) {
		super(nombre, telefono, direccion, email, tipoPersona, ciudad, calificacion);
		this.setNit(nit);
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

}
