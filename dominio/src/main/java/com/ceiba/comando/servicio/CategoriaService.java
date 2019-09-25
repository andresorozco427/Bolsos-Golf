package com.ceiba.comando.servicio;

import java.util.List;

import com.ceiba.excepcion.ExcepcionCategoriaYaExistente;
import com.ceiba.modelo.producto.Categoria;
import com.ceiba.puerto.repositorio.RepositorioCategoria;

public class CategoriaService {
	private static final String CATEGORIA_EXISTENTE = "La categoria ya existe";

	private RepositorioCategoria repositorioCategoria;

	public CategoriaService(RepositorioCategoria repositorioCategoria) {
		this.repositorioCategoria = repositorioCategoria;
	};	
	
	public void crear(Categoria categoria) {
		validarExistenciaDeCategoria(categoria.getNombreCategoria());
		
		this.repositorioCategoria.crear(categoria);
	}

	private void validarExistenciaDeCategoria(String nombreCategoria) {
		String nombreCategoriaReciente = nombreCategoria.toLowerCase();
		List<Categoria> categoriasCreadas = this.repositorioCategoria.consultarCategorias();
		for (int i = 0; i < categoriasCreadas.size(); i++) {			
			if(categoriasCreadas.get(i).getNombreCategoria().toLowerCase().contentEquals(nombreCategoriaReciente)){
				throw new ExcepcionCategoriaYaExistente(CATEGORIA_EXISTENTE);
			}
		}
	}
	
}
