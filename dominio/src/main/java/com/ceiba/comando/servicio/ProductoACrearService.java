package com.ceiba.comando.servicio;

import com.ceiba.modelo.producto.ProductoACrear;
import com.ceiba.puerto.repositorio.RepositorioProductoACrear;

public class ProductoACrearService {
	
	private RepositorioProductoACrear repositorioProductoACrear;

	public ProductoACrearService(RepositorioProductoACrear productoACrear) {
		this.repositorioProductoACrear = productoACrear;
	}		
	
	public void ejecutar(ProductoACrear productoACrear) {					
		this.repositorioProductoACrear.crear(productoACrear);		
	}
	
	
}
