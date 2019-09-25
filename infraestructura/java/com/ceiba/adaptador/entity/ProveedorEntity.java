package com.ceiba.adaptador.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class ProveedorEntity{

	@Id
	private String cedula;
	private String nombre;
	private String telefono;
	private String direccion;
	private String email;
	private String ciudad;
	private boolean calificacion;
	private String material;
	private float precio;
	
	@ManyToMany(mappedBy = "proveedores")
	private List<ProductoACrearEntity> productos;
	
	public ProveedorEntity(String cedula, String nombre, String telefono, String direccion, String email, 
			String ciudad, boolean calificacion, String material, float precio) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.ciudad = ciudad;
		this.calificacion = calificacion;
		this.material = material;
		this.precio = precio;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	

	
}
