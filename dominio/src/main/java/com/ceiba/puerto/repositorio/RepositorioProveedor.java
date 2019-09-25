package com.ceiba.puerto.repositorio;

import com.ceiba.modelo.persona.Proveedor;

public interface RepositorioProveedor {

	public Proveedor consultar(String cedula);
}
