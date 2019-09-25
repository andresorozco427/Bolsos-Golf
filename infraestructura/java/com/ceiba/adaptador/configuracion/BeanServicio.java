package com.ceiba.adaptador.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.comando.servicio.CategoriaService;
import com.ceiba.comando.servicio.PersonaService;
import com.ceiba.comando.servicio.ProductoACrearService;
import com.ceiba.comando.servicio.ProductoOriginarioService;
import com.ceiba.puerto.repositorio.RepositorioCategoria;
import com.ceiba.puerto.repositorio.RepositorioInventario;
import com.ceiba.puerto.repositorio.RepositorioPersona;
import com.ceiba.puerto.repositorio.RepositorioProductoACrear;
import com.ceiba.puerto.repositorio.RepositorioProductoOriginario;

@Configuration
public class BeanServicio {

	private RepositorioProductoOriginario repositorioProductoOriginario;
	private RepositorioPersona repositorioPersona;
	private RepositorioProductoACrear repositorioProductoACrear;
	private RepositorioCategoria repositorioCategoria;
	private RepositorioInventario repositorioInventario;
 	
	@Autowired
	public BeanServicio(RepositorioProductoOriginario repositorioProductoOriginario, RepositorioPersona repositorioPersona,
			RepositorioProductoACrear repositorioProductoACrear,  RepositorioCategoria repositorioCategoria,
			RepositorioInventario repositorioInventario) {
		this.repositorioProductoOriginario = repositorioProductoOriginario;
		this.repositorioPersona = repositorioPersona;
		this.repositorioProductoACrear = repositorioProductoACrear;
		this.repositorioCategoria = repositorioCategoria;
		this.repositorioInventario = repositorioInventario;
	}
	
	@Bean
	public ProductoACrearService servicioProductoACrear() {
		return new ProductoACrearService(repositorioProductoACrear);
	}
	
	@Bean
	public ProductoOriginarioService servicioProductoOriginario() {
		return new ProductoOriginarioService(repositorioProductoOriginario, repositorioInventario);
	}
	
	@Bean
	public PersonaService servicioPersona() {
		return new PersonaService(repositorioPersona);
	}
	
	@Bean
	public CategoriaService servicioCategoria() {
		return new CategoriaService(repositorioCategoria);
	}
}
