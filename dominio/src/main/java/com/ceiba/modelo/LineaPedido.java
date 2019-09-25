package com.ceiba.modelo;

import com.ceiba.modelo.producto.AbstractProducto;

public class LineaPedido {	

	private Integer cantidad;	
	private AbstractProducto producto;	
	
	public LineaPedido(Integer cantidad, AbstractProducto producto) {
		this.cantidad = cantidad;
		this.producto = producto;
	}

	public double calcularImporte() {
		return cantidad.doubleValue() * producto.getPrecioUnitario();
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public AbstractProducto getProducto() {
		return producto;
	}

	public void setProducto(AbstractProducto producto) {
		this.producto = producto;
	}

}
