package com.ceiba.puerto.repositorio;

import java.util.List;

import com.ceiba.modelo.persona.AbstractPersona;

public interface RepositorioPersona {
	
	public void crear(AbstractPersona abstractPersona);
	
	public AbstractPersona consultarPersona(String identificacion);
	
	public List<AbstractPersona> consultarPersonas();
}
