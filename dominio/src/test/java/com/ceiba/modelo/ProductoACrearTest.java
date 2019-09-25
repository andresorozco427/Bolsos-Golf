package com.ceiba.modelo;


import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.Constantes;
import com.ceiba.excepcion.ExcepcionValoresObligatorios;
import com.ceiba.testdatabuilder.ProductoTestDataBuilder;

public class ProductoACrearTest {

	@Test
	public void validarArgumentoNombre() {
		//Arrange
		ProductoTestDataBuilder productoACrear = new ProductoTestDataBuilder().conNombre(null);
		
		//Act //Assert
		BasePrueba.assertThrows(() -> productoACrear.buildProductoACrear(), ExcepcionValoresObligatorios.class, Constantes.NOMBRE_OBLIGATORIO);
		
	}
	
	@Test
	public void validarPrecioObligatorio() {
		//Arrange
		ProductoTestDataBuilder productoACrear = new ProductoTestDataBuilder().conPrecio(0);
		
		//Act //assert
		BasePrueba.assertThrows(() -> productoACrear.buildProductoACrear(), ExcepcionValoresObligatorios.class, Constantes.PRECIO_OBLIGATORIO);
	}

}
