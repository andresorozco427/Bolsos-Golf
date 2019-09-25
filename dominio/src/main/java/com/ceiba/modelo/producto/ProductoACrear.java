package com.ceiba.modelo.producto;

import java.util.List;

import com.ceiba.modelo.persona.Proveedor;

public class ProductoACrear extends AbstractProducto{
	
	private List<Proveedor> proveedores;	
	
	public ProductoACrear(String nombre, String descripcion, float precioUnitario, List<Proveedor> proveedores) {
		super(nombre, descripcion, precioUnitario);
		this.proveedores = proveedores;
	}
	
	public void agregarProveedor(Proveedor proveedor) {
		this.proveedores.add(proveedor);
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	

	
}
