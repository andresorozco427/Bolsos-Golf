package com.ceiba.modelo.producto;

public abstract class AbstractProducto {	
	private static final String NOMBRE_OBLIGATORIO = "El nombre del producto es obligatorio";
	private static final String PRECIO_OBLIGATORIO = "El precio del producto es obligatorio";
	
	protected String nombre;
	private String descripcion;
	private float precioUnitario;
	
	public AbstractProducto(String nombre, String descripcion, float precioUnitario) {
		
		ValidarArgumentosProducto.validarArgumentoNombre(nombre, NOMBRE_OBLIGATORIO);
		ValidarArgumentosProducto.validarArgumentoPrecio(precioUnitario, PRECIO_OBLIGATORIO);
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	
}
