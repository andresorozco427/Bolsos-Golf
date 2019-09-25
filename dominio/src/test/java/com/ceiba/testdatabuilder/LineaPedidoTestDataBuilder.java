package com.ceiba.testdatabuilder;

import com.ceiba.modelo.LineaPedido;
import com.ceiba.modelo.producto.AbstractProducto;
import com.ceiba.modelo.producto.ProductoOriginario;

public class LineaPedidoTestDataBuilder {
	private Integer cantidad;	
	private AbstractProducto producto;
	
	public LineaPedidoTestDataBuilder() {
		this.cantidad = 4;
		this.producto = new ProductoTestDataBuilder().buildProductoOriginario();
	}
	
	public LineaPedidoTestDataBuilder conCantidad(Integer cantidad) {
		this.cantidad = cantidad;
		return this;
	}
	
	public LineaPedidoTestDataBuilder conProducto(ProductoOriginario productoOriginario) {
		this.producto = productoOriginario;
		return this;
	}
	
	public LineaPedido build() {
		return new LineaPedido(cantidad, producto);
	}
	
}
