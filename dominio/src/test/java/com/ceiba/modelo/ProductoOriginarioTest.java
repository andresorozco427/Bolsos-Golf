package com.ceiba.modelo;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.Constantes;
import com.ceiba.excepcion.ExcepcionValoresObligatorios;
import com.ceiba.testdatabuilder.ProductoTestDataBuilder;

public class ProductoOriginarioTest {

	
	@Test
	public void validarNombreObligatorio() {
		//Arrange
		ProductoTestDataBuilder productoOriginario = new ProductoTestDataBuilder().conNombre(null);
		
		//Act //assert
		BasePrueba.assertThrows(() -> productoOriginario.buildProductoOriginario(), ExcepcionValoresObligatorios.class, Constantes.NOMBRE_OBLIGATORIO);
	}
	
	@Test
	public void validarPrecioObligatorio() {
		//Arrange
		ProductoTestDataBuilder productoOriginario = new ProductoTestDataBuilder().conPrecio(0);
		
		//Act //assert
		BasePrueba.assertThrows(() -> productoOriginario.buildProductoOriginario(), ExcepcionValoresObligatorios.class, Constantes.PRECIO_OBLIGATORIO);
	}
	
	@Test
	public void validarCategoriaObligatoria() {
		//Arrange
		ProductoTestDataBuilder productoOriginario = new ProductoTestDataBuilder().conCategoria(null);
		
		//Act //assert
		BasePrueba.assertThrows(() -> productoOriginario.buildProductoOriginario(), ExcepcionValoresObligatorios.class, Constantes.CATEGORIA_OBLIGATORIO);
	}
}
