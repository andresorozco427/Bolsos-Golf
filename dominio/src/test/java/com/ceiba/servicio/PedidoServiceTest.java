package com.ceiba.servicio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.Constantes;
import com.ceiba.comando.servicio.PedidoService;
import com.ceiba.excepcion.ExcepcionCantidadDePedidoSuperaStock;
import com.ceiba.excepcion.ExcepcionCantidadMaximaProductos;
import com.ceiba.excepcion.ExcepcionFaltaDePago;
import com.ceiba.excepcion.ExcepcionValoresObligatorios;
import com.ceiba.modelo.Estados;
import com.ceiba.modelo.LineaPedido;
import com.ceiba.modelo.Pedido;
import com.ceiba.modelo.persona.PersonaJuridica;
import com.ceiba.modelo.persona.PersonaNatural;
import com.ceiba.modelo.producto.Inventario;
import com.ceiba.modelo.producto.ProductoOriginario;
import com.ceiba.puerto.repositorio.RepositorioInventario;
import com.ceiba.puerto.repositorio.RepositorioPedido;
import com.ceiba.testdatabuilder.LineaPedidoTestDataBuilder;
import com.ceiba.testdatabuilder.PedidoTestDataBuilder;
import com.ceiba.testdatabuilder.PersonaTestDataBuilder;

public class PedidoServiceTest {

	private RepositorioInventario repositorioInventario;
	private RepositorioPedido repositorioPedido;

	@Before
	public void setUp() {
		this.repositorioInventario = mock(RepositorioInventario.class);
		this.repositorioPedido = mock(RepositorioPedido.class);
	}

	@Test
	public void validacionCantidadDelPedidoMayorQueCantidadDelStock() {
		// Arrange
		List<LineaPedido> lineas = new ArrayList<>();
		LineaPedido lineaPedido = new LineaPedidoTestDataBuilder().build();
		lineas.add(lineaPedido);
		ProductoOriginario productoOriginario = (ProductoOriginario) lineaPedido.getProducto();
		Pedido pedido = new PedidoTestDataBuilder().build();

		PedidoService pedidoService = new PedidoService(repositorioPedido, repositorioInventario);

		when(this.repositorioInventario
				.cantidadDeProductosEnStock(productoOriginario.getCategoria().getNombreCategoria())).thenReturn(2);

		// Assert //Act
		BasePrueba.assertThrows(() -> pedidoService.validarCantidadDeProductosEnStock(pedido, lineas),
				ExcepcionCantidadDePedidoSuperaStock.class, Constantes.VALIDACION_CANTIDAD_SUPERA_STOCK);
	}

	@Test
	public void validacionCantidadDelPedidoMenorQueCantidadDelStock() {
		// Arrange
		List<LineaPedido> lineas = new ArrayList<>();
		LineaPedido lineaPedido = new LineaPedidoTestDataBuilder().build();
		lineas.add(lineaPedido);
		ProductoOriginario productoOriginario = (ProductoOriginario) lineaPedido.getProducto();
		Pedido pedido = new PedidoTestDataBuilder().build();

		PedidoService pedidoService = new PedidoService(repositorioPedido, repositorioInventario);

		// Act
		when(this.repositorioInventario
				.cantidadDeProductosEnStock(productoOriginario.getCategoria().getNombreCategoria())).thenReturn(6);
		Pedido pedidoResultante = pedidoService.validarCantidadDeProductosEnStock(pedido, lineas);

		// Assert
		assertEquals(Estados.PENDIENTE, pedidoResultante.getEstado());
	}

	@Test
	public void validarNingunaCantidadDeProductosEnLaLineaDePedido() {
		// Arrange
		List<LineaPedido> lineas = new ArrayList<>();
		Pedido pedido = new PedidoTestDataBuilder().build();
		PedidoService pedidoService = new PedidoService(repositorioPedido, repositorioInventario);

		// Act //Assert
		BasePrueba.assertThrows(() -> pedidoService.validarCantidadDeProductosEnLaLineaDePedido(pedido, lineas),
				ExcepcionValoresObligatorios.class, Constantes.LINEAS_OBLIGATORIAS);
	}

	@Test
	public void validacionAgregarLineasDePedidoAlPedido() {
		// Arrange
		List<LineaPedido> lineas = new ArrayList<>();
		LineaPedido lineaPedido = new LineaPedidoTestDataBuilder().conCantidad(47).build();
		LineaPedido lineaPedido2 = new LineaPedidoTestDataBuilder().build();
		lineas.add(lineaPedido);
		lineas.add(lineaPedido2);
		Pedido pedido = new PedidoTestDataBuilder().build();

		PedidoService pedidoService = new PedidoService(repositorioPedido, repositorioInventario);

		// Act
		Pedido pedidoResultante = pedidoService.validarCantidadDeProductosEnLaLineaDePedido(pedido, lineas);

		// Assert
		assertEquals(2, pedidoResultante.getLineaPedido().size());
	}

	@Test
	public void validacionNumeroMaximoDeProductosEnPedido() {
		// Arrange
		List<LineaPedido> lineas = new ArrayList<>();
		LineaPedido lineaPedido = new LineaPedidoTestDataBuilder().build();
		LineaPedido lineaPedido2 = new LineaPedidoTestDataBuilder().build();
		lineas.add(lineaPedido);
		lineas.add(lineaPedido2);
		Pedido pedido = new PedidoTestDataBuilder().build();

		PedidoService pedidoService = new PedidoService(repositorioPedido, repositorioInventario);

		// Act //Assert
		BasePrueba.assertThrows(() -> pedidoService.validarCantidadDeProductosEnLaLineaDePedido(pedido, lineas),
				ExcepcionCantidadMaximaProductos.class, Constantes.VALIDACION_PRODUCTOS_MINIMOS);

	}
	
	@Test
	public void validarPagoPedidosAnterioresPersonaNatural() {
		//Arrange
		List<Pedido> pedidosAnteriores = new ArrayList<>();
		LineaPedido lineaPedido = new LineaPedidoTestDataBuilder().build();
		Pedido pedidoAnterior = new PedidoTestDataBuilder().conLineasDePedido(lineaPedido).build();
		pedidosAnteriores.add(pedidoAnterior);		
		Pedido pedidoReciente = new PedidoTestDataBuilder().build();
		PersonaNatural personaNatural = (PersonaNatural) pedidoAnterior.getPersona();
		
		PedidoService pedidoService = new PedidoService(repositorioPedido, repositorioInventario);
		when(this.repositorioPedido.consultaPedidosRealizados(personaNatural.getCedula())).thenReturn(pedidosAnteriores);
		
		//Act //
		BasePrueba.assertThrows(() -> pedidoService.validarPagoClienteEnPedidosAnteriores(pedidoReciente), ExcepcionFaltaDePago.class, Constantes.FALTA_PAGO);
	}
	
	@Test
	public void validarPagoPedidosAnterioresPersonaJuridica() {
		//Arrange
		List<Pedido> pedidosAnteriores = new ArrayList<>();
		LineaPedido lineaPedido = new LineaPedidoTestDataBuilder().build();
		PersonaJuridica personaJuridica =  new PersonaTestDataBuilder().conNit(Constantes.NIT).conTipoPersona(Constantes.PERSONA_JURIDICA).buildPersonaJuridica();
		Pedido pedidoAnterior = new PedidoTestDataBuilder().conLineasDePedido(lineaPedido).conPersona(personaJuridica).build();
		pedidosAnteriores.add(pedidoAnterior);		
		Pedido pedidoReciente = new PedidoTestDataBuilder().conLineasDePedido(lineaPedido).conPersona(personaJuridica).build();		
		
		PedidoService pedidoService = new PedidoService(repositorioPedido, repositorioInventario);
		when(this.repositorioPedido.consultaPedidosRealizados(personaJuridica.getNit())).thenReturn(pedidosAnteriores);
		
		//Act //Assert
		BasePrueba.assertThrows(() -> pedidoService.validarPagoClienteEnPedidosAnteriores(pedidoReciente), ExcepcionFaltaDePago.class, Constantes.FALTA_PAGO);
	}
	
	@Test
	public void validarDescuentoDeProductosEnInventario() {
		//Arrange
		List<LineaPedido> lineas = new ArrayList<>();
		LineaPedido lineaPedido2 = new LineaPedidoTestDataBuilder().conCantidad(6).build();
		lineas.add(lineaPedido2);
		ProductoOriginario productoOriginario = (ProductoOriginario) lineaPedido2.getProducto();
		
		PedidoService pedidoService = new PedidoService(repositorioPedido, repositorioInventario);
		when(this.repositorioInventario.cantidadDeProductosEnStock(productoOriginario.getCategoria().getNombreCategoria())).thenReturn(20);
		//Act
		Inventario inventario = pedidoService.salidaDeProductosDelInventario(lineas);
		
		//Assert
		assertEquals(14, inventario.getCantidad(), 0);
	}
	
	@Test
	public void validarElValorTotalDeUnPedido() {
		List<LineaPedido> lineas = new ArrayList<>();
		LineaPedido lineaPedido2 = new LineaPedidoTestDataBuilder().conCantidad(100).build();
		LineaPedido lineaPedido3 = new LineaPedidoTestDataBuilder().conCantidad(51).build();
		lineas.add(lineaPedido2);
		lineas.add(lineaPedido3);
		Pedido pedido = new PedidoTestDataBuilder().build();
		ProductoOriginario productoOriginario = (ProductoOriginario) lineaPedido2.getProducto();
		
		PedidoService pedidoService = new PedidoService(repositorioPedido, repositorioInventario);
		when(this.repositorioInventario
				.cantidadDeProductosEnStock(productoOriginario.getCategoria().getNombreCategoria())).thenReturn(675);
		//Act 
		Pedido pedidoGenerado = pedidoService.guardar(pedido, lineas);
		
		float cantidadEsperada = 0;
		for (int i = 0; i < lineas.size(); i++) {
			cantidadEsperada += lineas.get(i).getProducto().getPrecioUnitario() * lineas.get(i).getCantidad();
		}
		//Assert
		assertEquals(cantidadEsperada, pedidoGenerado.getValorTotal(), 0);
	}
}
