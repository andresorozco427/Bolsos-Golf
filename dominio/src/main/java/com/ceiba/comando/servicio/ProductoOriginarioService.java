package com.ceiba.comando.servicio;

import java.util.List;

import com.ceiba.excepcion.ExcepcionCantidadProductos;
import com.ceiba.modelo.producto.Inventario;
import com.ceiba.modelo.producto.ProductoOriginario;
import com.ceiba.puerto.repositorio.RepositorioInventario;
import com.ceiba.puerto.repositorio.RepositorioProductoOriginario;

public class ProductoOriginarioService {
	private static final int CAPACIDAD_PRODUCTOS = 40;
	private static final String NO_HAY_CUPO = "La cantidad en stock supera el limite permitido";
	
	private RepositorioProductoOriginario repositorioProductoOriginario;
	private RepositorioInventario repositorioInventario;
	
	public ProductoOriginarioService(RepositorioProductoOriginario repositorioProductoOriginario, RepositorioInventario repositorioInventario) {
		this.repositorioProductoOriginario = repositorioProductoOriginario;		
		this.repositorioInventario = repositorioInventario;
	}
	
	public void ejecutar(ProductoOriginario productoOriginario) {			
		validarDisponibilidadProductosEnStock(productoOriginario);	
		agregarProductoAlStock(productoOriginario);
		
		productoOriginario.setEstado(false);		
		
		this.repositorioProductoOriginario.crearOriginario(productoOriginario);
	}	

	public Inventario agregarProductoAlStock(ProductoOriginario productoOriginario) {
		int cantidadProductos = 0;
		List<ProductoOriginario> productosEnStock = this.repositorioInventario.consultarProductosEnStock();
		for (int i = 0; i < productosEnStock.size(); i++) {
			if(productosEnStock.get(i).getCategoria().getNombreCategoria().contentEquals(productoOriginario.getCategoria().getNombreCategoria())) {
				cantidadProductos += productoOriginario.getCantidad();		
			}
		}
		Inventario inventario = new Inventario();
		inventario.setProductos(productoOriginario);
		inventario.setCantidad(cantidadProductos);
		this.repositorioInventario.actualizarInventario(inventario);
		return inventario;
	}

	private void validarDisponibilidadProductosEnStock(ProductoOriginario productoOriginario) {
		int numeroDeProductosEnStock = this.repositorioInventario.cantidadDeProductosEnStock(productoOriginario.getCategoria().getNombreCategoria());
		if(numeroDeProductosEnStock > CAPACIDAD_PRODUCTOS) {
			throw new ExcepcionCantidadProductos(NO_HAY_CUPO);
		}		
	}	
	
}
