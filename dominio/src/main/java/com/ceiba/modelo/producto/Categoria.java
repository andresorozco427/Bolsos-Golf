package com.ceiba.modelo.producto;

import java.io.Serializable;

public class Categoria implements Serializable{		
	private static final String NOMBRE_OBLIGATORIO = "El nombre de la categoria es obligatorio";
	
	private String nombreCategoria;	
	
	public Categoria(String nombreCategoria) {
		ValidarArgumentosCategoria.validarArgumentoNombre(nombreCategoria, NOMBRE_OBLIGATORIO);
		
		this.nombreCategoria = nombreCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	private static final long serialVersionUID = -5769918616898031479L;	
}
