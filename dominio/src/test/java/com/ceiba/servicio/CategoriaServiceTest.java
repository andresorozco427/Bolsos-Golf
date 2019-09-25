package com.ceiba.servicio;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.Constantes;
import com.ceiba.comando.servicio.CategoriaService;
import com.ceiba.excepcion.ExcepcionCategoriaYaExistente;
import com.ceiba.modelo.producto.Categoria;
import com.ceiba.puerto.repositorio.RepositorioCategoria;
import com.ceiba.testdatabuilder.CategoriaTestDataBuilder;

public class CategoriaServiceTest {

	private RepositorioCategoria repositorioCategoria;
	
	@Before
	public void setUp(){
		this.repositorioCategoria = mock(RepositorioCategoria.class);
	}

	@Test
	public void validarExistenciaDeLaCategoria() {		
		//Arrange
		List<Categoria> categorias = new ArrayList<>();
		Categoria categoria = new CategoriaTestDataBuilder().build();
		CategoriaService categoriaService = new CategoriaService(repositorioCategoria);
		categorias.add(categoria);
		//Act
		when(this.repositorioCategoria.consultarCategorias()).thenReturn(categorias);		
		//Assert
		BasePrueba.assertThrows(() -> categoriaService.crear(categoria), ExcepcionCategoriaYaExistente.class, Constantes.CATEGORIA_EXISTENTE);
	}

}
