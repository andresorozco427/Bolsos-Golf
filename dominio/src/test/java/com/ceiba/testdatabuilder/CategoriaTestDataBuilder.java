package com.ceiba.testdatabuilder;

import com.ceiba.modelo.producto.Categoria;

public class CategoriaTestDataBuilder {
	
	private String nombrecategoria;

	public CategoriaTestDataBuilder() {
		this.nombrecategoria = "Bolsos";
	}
	
	public CategoriaTestDataBuilder conNombreCategoria(String nombreCategoria) {
		this.nombrecategoria = nombreCategoria;
		return this;
	}
	
	public Categoria build() {
		return new Categoria(nombrecategoria);
	}
	
}
