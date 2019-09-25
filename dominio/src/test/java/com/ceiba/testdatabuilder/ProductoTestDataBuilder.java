package com.ceiba.testdatabuilder;

import java.util.List;

import com.ceiba.modelo.persona.Proveedor;
import com.ceiba.modelo.producto.Categoria;
import com.ceiba.modelo.producto.ProductoACrear;
import com.ceiba.modelo.producto.ProductoOriginario;

public class ProductoTestDataBuilder{
	
	private String nombre;
	private String descripcion;
	private float precio;
	private Categoria categoria;	
	private Integer cantidad;
	private List<Proveedor> proveedores;
	
	public ProductoTestDataBuilder() {
		this.nombre = "Bolsos golf";
		this.descripcion = "Bolso con gran capacidad de equipaje";
		this.precio = 2000;
		this.categoria = new Categoria("Bolso arrieta");
		this.cantidad = 2;
	}	
	
	
	public ProductoTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ProductoTestDataBuilder conDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}
	
	public ProductoTestDataBuilder conPrecio(float precio) {
		this.precio = precio;
		return this;
	}
	
	public ProductoTestDataBuilder conCategoria(String nombreCategoria) {
		this.categoria.setNombreCategoria(nombreCategoria);
		return this;
	}
	
	public ProductoTestDataBuilder conCantidad(Integer cantidad) {
		this.cantidad = cantidad;
		return this;
	}
	
	public ProductoTestDataBuilder conProveedor(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
		return this;
	}
	
	public ProductoOriginario buildProductoOriginario() {
		return new ProductoOriginario(nombre, descripcion, precio, categoria, cantidad);
	}
	
	public ProductoACrear buildProductoACrear() {
		return new ProductoACrear(nombre, descripcion, precio, proveedores);
	}
}
