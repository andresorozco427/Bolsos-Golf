package com.ceiba.comando.servicio;

import com.ceiba.excepcion.ExcepcionPersonaYaExistente;
import com.ceiba.modelo.persona.AbstractPersona;
import com.ceiba.modelo.persona.PersonaJuridica;
import com.ceiba.modelo.persona.PersonaNatural;
import com.ceiba.modelo.persona.Proveedor;
import com.ceiba.puerto.repositorio.RepositorioPersona;

public class PersonaService {
	private static final String PERSONA_YA_EXISTENTE = "La persona ingresada ya es existente en la base de datos";

	private RepositorioPersona repositorioPersona;
	
	public PersonaService(RepositorioPersona repositorioPersona) {
		this.repositorioPersona = repositorioPersona;
	}
	
	public void guardar(AbstractPersona abstractPersona) {
		validarExistenciaPersonaNatural(abstractPersona);
		
		this.repositorioPersona.crear(abstractPersona);
	}
	
	private void validarExistenciaPersonaNatural(AbstractPersona abstractPersona2) {
		AbstractPersona persona = this.repositorioPersona.consultarPersona(codigoDeLaPersona(abstractPersona2));
		if(laPersonaEsExistente(persona)) {
			throw new ExcepcionPersonaYaExistente(PERSONA_YA_EXISTENTE);
		}
	}
	
	private boolean laPersonaEsExistente(AbstractPersona personaAConsultar) {
		return personaAConsultar != null;
	}	
	
	public static String codigoDeLaPersona(AbstractPersona abstractPersona) {
		String tipo = abstractPersona.getTipoPersona().toLowerCase();
		String codigo = null;
		if(tipo.contentEquals("natural")) {
			PersonaNatural personaNatural = (PersonaNatural) abstractPersona;
			codigo = personaNatural.getCedula();
		}
		if(tipo.contentEquals("juridica")) {
			PersonaJuridica personaJuridica = (PersonaJuridica) abstractPersona;
			codigo = personaJuridica.getNit();
		}
		if(tipo.contentEquals("proveedor")) {
			Proveedor proveedor = (Proveedor) abstractPersona;
			codigo = proveedor.getCedula();
		}
		return codigo;
	}
	
	

	
	
}
