package com.ceiba.modelo.persona;

public class Proveedor extends PersonaNatural{
	private static final String MATERIAL_OBLIGATORIO = "El material es obligatorio";
	private static final String PRECIO_OBLIGATORIO = "El precio es obligatorio";

	private String materialProveedor;
	private float precio;
	private String descripcion;
	
	public Proveedor(String nombre, String direccion, String email, String tipoPersona, String ciudad,
			boolean calificacion, String cedula, String material, float precio, String telefono) {
		super(nombre, direccion, email, tipoPersona, ciudad, telefono, calificacion, cedula);
		ValidarArgumentosPersona.validarArgumentosMaterialProveedor(material, MATERIAL_OBLIGATORIO);
		ValidarArgumentosPersona.validarArgumentosPrecioMaterial(precio, PRECIO_OBLIGATORIO);
		this.materialProveedor = material;
		this.precio = precio;
	}

	public String getMaterialProveedor() {
		return materialProveedor;
	}

	public void setMaterialProveedor(String materialProveedor) {
		this.materialProveedor = materialProveedor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
