package com.ceiba.servicio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.Constantes;
import com.ceiba.comando.servicio.ProductoOriginarioService;
import com.ceiba.excepcion.ExcepcionCantidadProductos;
import com.ceiba.modelo.producto.Inventario;
import com.ceiba.modelo.producto.ProductoOriginario;
import com.ceiba.puerto.repositorio.RepositorioInventario;
import com.ceiba.puerto.repositorio.RepositorioProductoOriginario;
import com.ceiba.testdatabuilder.ProductoTestDataBuilder;

public class ProductoOriginarioServiceTest {
	private RepositorioProductoOriginario repositorioOriginario;
	private RepositorioInventario repositorioInventario;
	
	@Before
	public void setUp() {
		this.repositorioOriginario = mock(RepositorioProductoOriginario.class);
		this.repositorioInventario = mock(RepositorioInventario.class);
	}
	
	@Test(expected = ExcepcionCantidadProductos.class)
	public void validarDisponibilidadEnStock() {
		//Arrange
		ProductoOriginario productoOriginario = new ProductoTestDataBuilder().buildProductoOriginario();		
		ProductoOriginarioService productoOriginarioService = new ProductoOriginarioService(repositorioOriginario, repositorioInventario);
		//Act
		when(this.repositorioInventario.cantidadDeProductosEnStock(productoOriginario.getCategoria().getNombreCategoria())).thenReturn(Constantes.CANTIDAD_MAXIMA_PRODUCTOS_ORIGINARIOS);
		//Assert
		productoOriginarioService.ejecutar(productoOriginario);
	}
	
	@Test
	public void validarIngresoInventarioSegunCategoria() {
		//Arrange
		List<ProductoOriginario> productos = new ArrayList<>();
		ProductoOriginario productoOriginario = new ProductoTestDataBuilder().buildProductoOriginario();		
		ProductoOriginario productoOriginario2 = new ProductoTestDataBuilder().buildProductoOriginario();	
		productos.add(productoOriginario);		
		productos.add(productoOriginario2);	
		ProductoOriginarioService productoOriginarioService = new ProductoOriginarioService(repositorioOriginario, repositorioInventario);
		//Act
		when(this.repositorioInventario.consultarProductosEnStock()).thenReturn(productos);
		Inventario inventario = productoOriginarioService.agregarProductoAlStock(productoOriginario);
		//Assert
		assertEquals(inventario.getCantidad().doubleValue(), 4, 0);
	}

}
