package com.ceiba.servicio;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.Constantes;
import com.ceiba.comando.servicio.PersonaService;
import com.ceiba.excepcion.ExcepcionPersonaYaExistente;
import com.ceiba.modelo.persona.PersonaJuridica;
import com.ceiba.modelo.persona.PersonaNatural;
import com.ceiba.modelo.persona.Proveedor;
import com.ceiba.puerto.repositorio.RepositorioPersona;
import com.ceiba.testdatabuilder.PersonaTestDataBuilder;

public class PersonaServiceTest {
	
	private RepositorioPersona repositorioPersona;
	
	@Before
	public void setUP() {
		this.repositorioPersona = mock(RepositorioPersona.class);
	}	
	

	@Test
	public void validacionPersonaNaturalYaExistente() {
		//Arrange
		PersonaNatural personaNatural = new PersonaTestDataBuilder().conCedula(Constantes.CEDULA).buildPersonaNatural();
		
		PersonaService personaService = new PersonaService(repositorioPersona);		
		when(this.repositorioPersona.consultarPersona(personaNatural.getCedula())).thenReturn(personaNatural);	
		
		//Act //Assert		
		BasePrueba.assertThrows(() -> personaService.guardar(personaNatural), ExcepcionPersonaYaExistente.class, Constantes.PERSONA_YA_EXISTENTE);
	}
	
	@Test
	public void validacionPersonaJuridicaYaExistente() {
		//Arrange
		PersonaJuridica personaJuridica = new PersonaTestDataBuilder().conNit(Constantes.NIT).conTipoPersona(Constantes.PERSONA_JURIDICA).buildPersonaJuridica();
		
		PersonaService personaService = new PersonaService(repositorioPersona);		
		when(this.repositorioPersona.consultarPersona(personaJuridica.getNit())).thenReturn(personaJuridica);	
		
		//Act //Assert		
		BasePrueba.assertThrows(() -> personaService.guardar(personaJuridica), ExcepcionPersonaYaExistente.class, Constantes.PERSONA_YA_EXISTENTE);
	}
	
	@Test
	public void validacionPersonaProveedorYaExistente() {
		//Arrange
		Proveedor proveedor = new PersonaTestDataBuilder().conCedula(Constantes.CEDULA).conTipoPersona(Constantes.PERSONA_PROVEEDOR).buildProveedor();
		
		PersonaService personaService = new PersonaService(repositorioPersona);		
		when(this.repositorioPersona.consultarPersona(proveedor.getCedula())).thenReturn(proveedor);	
		
		//Act //Assert		
		BasePrueba.assertThrows(() -> personaService.guardar(proveedor), ExcepcionPersonaYaExistente.class, Constantes.PERSONA_YA_EXISTENTE);
	}

}
