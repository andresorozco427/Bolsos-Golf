package com.ceiba.puerto.repositorio;

import java.util.List;

import com.ceiba.modelo.producto.ProductoOriginario;

public interface RepositorioProductoOriginario {
	
	public void crearOriginario(ProductoOriginario productoOriginario);	
	
	public List<ProductoOriginario> productosOriginarios();
	
	public ProductoOriginario consultarProductoOriginario(long id);	
	
	public List<ProductoOriginario> productosOriginariosPorCategoria(String categoria);

}
