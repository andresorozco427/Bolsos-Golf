package com.ceiba.puerto.repositorio;

import java.util.List;

import com.ceiba.modelo.producto.Categoria;

public interface RepositorioCategoria {
	
	public void crear(Categoria categoria); 
	
	public List<Categoria> consultarCategorias();
}
