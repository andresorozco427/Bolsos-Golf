package com.ceiba.puerto.repositorio;

import java.util.List;

import com.ceiba.modelo.producto.Inventario;
import com.ceiba.modelo.producto.ProductoOriginario;

public interface RepositorioInventario {	
	
	public int cantidadDeProductosEnStock(String categoria);
	
	public void actualizarInventario(Inventario inventario);
	
	public List<ProductoOriginario> consultarProductosEnStock();
}
