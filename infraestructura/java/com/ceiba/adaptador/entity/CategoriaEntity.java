package com.ceiba.adaptador.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class CategoriaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	private String nombreCategoria;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id")
	private List<ProductoOriginarioEntity> productoOriginarios;
		
	public CategoriaEntity(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombreCategoria;
	}

	public void setNombre(String nombre) {
		this.nombreCategoria = nombre;
	}
	
	
}
