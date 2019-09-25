package com.ceiba.modelo;


import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.Constantes;
import com.ceiba.excepcion.ExcepcionEmailInvalido;
import com.ceiba.excepcion.ExcepcionLongitudCedula;
import com.ceiba.excepcion.ExcepcionNitInvalido;
import com.ceiba.excepcion.ExcepcionValoresObligatorios;
import com.ceiba.testdatabuilder.PersonaTestDataBuilder;

public class PersonaTest {

	@Test
	public void validarArgumentosNombrePersona() {
		//Arrange
		PersonaTestDataBuilder personaNatural = new PersonaTestDataBuilder().conNombre(null);
		
		//Act //Assert
		BasePrueba.assertThrows(() -> personaNatural.buildPersonaNatural(), ExcepcionValoresObligatorios.class, Constantes.NOMBRE_PERSONA_OBLIGATORIO);
	}
	
	@Test
	public void validarArgumentosTelefonoPersona() {
		//Arrange
		PersonaTestDataBuilder personaNatural = new PersonaTestDataBuilder().conTelefono(null);
		
		//Act //Assert
		BasePrueba.assertThrows(() -> personaNatural.buildPersonaNatural(), ExcepcionValoresObligatorios.class, Constantes.TELEFONO_OBLIGATORIO);
	}

	
	@Test
	public void validarArgumentosDireccionPersona() {
		//Arrange
		PersonaTestDataBuilder personaNatural = new PersonaTestDataBuilder().conDireccion(null);
		
		//Act //Assert
		BasePrueba.assertThrows(() -> personaNatural.buildPersonaNatural(), ExcepcionValoresObligatorios.class, Constantes.DIRECCION_OBLIGATORIO);
	}

	
	@Test
	public void validarArgumentosEmailPersona() {
		//Arrange
		PersonaTestDataBuilder personaNatural = new PersonaTestDataBuilder().conEmail("andres");
		
		//Act //Assert
		BasePrueba.assertThrows(() -> personaNatural.buildPersonaNatural(), ExcepcionEmailInvalido.class, Constantes.EMAIL_INVALIDO);
	}

	
	@Test
	public void validarArgumentosTipoPersonaPersona() {
		//Arrange
		PersonaTestDataBuilder personaNatural = new PersonaTestDataBuilder().conTipoPersona(null);
		
		//Act //Assert
		BasePrueba.assertThrows(() -> personaNatural.buildPersonaNatural(), ExcepcionValoresObligatorios.class, Constantes.TIPOPERSONA_OBLIGATORIO);
	}
	
	@Test
	public void validarArgumentosCiudadPersona() {
		//Arrange
		PersonaTestDataBuilder personaNatural = new PersonaTestDataBuilder().conCiudad(null);
		
		//Act //Assert
		BasePrueba.assertThrows(() -> personaNatural.buildPersonaNatural(), ExcepcionValoresObligatorios.class, Constantes.CIUDAD_OBLIGATORIO);
	}
	
	@Test
	public void validarArgumentosCedulaPersonaNatural() {
		//Arrange
		PersonaTestDataBuilder personaNatural = new PersonaTestDataBuilder().conCedula(null);
		
		//Act //Assert
		BasePrueba.assertThrows(() -> personaNatural.buildPersonaNatural(), ExcepcionValoresObligatorios.class, Constantes.CEDULA_OBLIGATORIA);
	}
	
	@Test
	public void validarArgumentosLongitudCedulaPersonaNatural() {
		//Arrange
		PersonaTestDataBuilder personaNatural = new PersonaTestDataBuilder();
		
		//Act //Assert
		BasePrueba.assertThrows(() -> personaNatural.buildPersonaNatural(), ExcepcionLongitudCedula.class, Constantes.CEDULA_INVALIDA);
	}
	
	@Test
	public void validarArgumentosNitPersonaJuridica() {
		//Arrange
		PersonaTestDataBuilder personaNatural = new PersonaTestDataBuilder().conNit(null);
		
		//Act //Assert
		BasePrueba.assertThrows(() -> personaNatural.buildPersonaJuridica(), ExcepcionValoresObligatorios.class, Constantes.NIT_OBLIGATORIO);
	}
	
	@Test
	public void validarArgumentosLongitudYGuionNitPersonaJuridica() {
		//Arrange
		PersonaTestDataBuilder personaNatural = new PersonaTestDataBuilder();
		
		//Act //Assert
		BasePrueba.assertThrows(() -> personaNatural.buildPersonaJuridica(), ExcepcionNitInvalido.class, Constantes.NIT_INVALIDO);
	}
	
	@Test
	public void validarArgumentosMaterialPersonaProveedor() {
		//Arrange
		PersonaTestDataBuilder personaNatural = new PersonaTestDataBuilder().conMaterial(null).conCedula("71672415");
		
		//Act //Assert
		BasePrueba.assertThrows(() -> personaNatural.buildProveedor(), ExcepcionValoresObligatorios.class, Constantes.MATERIAL_OBLIGATORIO);
	}
	
	@Test
	public void validarArgumentosPrecioMaterialPersonaProveedor() {
		//Arrange
		PersonaTestDataBuilder personaNatural = new PersonaTestDataBuilder().conPrecio(0).conCedula("71672415");;
		
		//Act //Assert
		BasePrueba.assertThrows(() -> personaNatural.buildProveedor(), ExcepcionValoresObligatorios.class, Constantes.PRECIO_MATERIAL_OBLIGATORIO);
	}
	
	


}
