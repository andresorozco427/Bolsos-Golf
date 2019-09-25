package com.ceiba.adaptador.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producto_crear")
public class ProductoACrearEntity extends ProductoEntity{	
	@ManyToMany
	@JoinTable(
			name = "producto_proveedor",
			joinColumns = @JoinColumn(name =  "producto_id"),
			inverseJoinColumns = @JoinColumn(name = "proveedor_id")
			)
	private List<ProveedorEntity> proveedores;

	public ProductoACrearEntity(List<ProveedorEntity> proveedores) {
		this.proveedores = proveedores;
	}

	public List<ProveedorEntity> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<ProveedorEntity> proveedores) {
		this.proveedores = proveedores;
	}	
	
}
