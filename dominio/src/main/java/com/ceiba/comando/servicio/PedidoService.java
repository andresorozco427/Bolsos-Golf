package com.ceiba.comando.servicio;

import java.time.LocalDateTime;
import java.util.List;

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

public class PedidoService {
	private static final int MINIMO_PRODUCTOS = 50;
	private static final String VALIDACION_PRODUCTOS_MINIMOS = "El pedido debe tener como minimo 50 prodcutos";
	private static final String VALIDACION_CANTIDAD_SUPERA_STOCK = "la cantidad pedida supera la cantidad almacenada en stock";
	private static final String LINEAS_OBLIGATORIAS = "El pedido debe tener lineas de pedido";
	private static final String FALTA_PAGO = "El pedido debe tener lineas de pedido";
	private static final String PERSONA_NATURAL = "natural";
	private static final String PERSONA_JURIDICA = "juridica";

	private RepositorioPedido repositorioPedido;
	private RepositorioInventario repositorioInventario;

	public PedidoService(RepositorioPedido repositorioPedido, RepositorioInventario repositorioInventario) {
		this.repositorioPedido = repositorioPedido;
		this.repositorioInventario = repositorioInventario;
	}

	public Pedido guardar(Pedido pedido, List<LineaPedido> lineaPedido) {
		Pedido pedidoACrear = validarCantidadDeProductosEnLaLineaDePedido(pedido, lineaPedido);
		validarCantidadDeProductosEnStock(pedido, lineaPedido);		
		validarPagoClienteEnPedidosAnteriores(pedido);
		salidaDeProductosDelInventario(lineaPedido);	
		
		LocalDateTime fechaPedido = LocalDateTime.now();
		pedidoACrear.setFechaPedido(fechaPedido);
		pedidoACrear.getValorTotal();

		this.repositorioPedido.guardar(pedidoACrear);
		return pedidoACrear;
	}

	public Inventario salidaDeProductosDelInventario(List<LineaPedido> lineaPedido) {
		Inventario inventarioProductos = null;
		for (LineaPedido productos : lineaPedido) {
			ProductoOriginario productoOriginario = (ProductoOriginario) productos.getProducto();
			int cantidadProductosEnStock = this.repositorioInventario.cantidadDeProductosEnStock(productoOriginario.getCategoria().getNombreCategoria());
			Inventario inventario = new Inventario();
			inventario.setCantidad(cantidadProductosEnStock - productos.getCantidad());			
			inventarioProductos = inventario;
			this.repositorioInventario.actualizarInventario(inventario);
		}
		return inventarioProductos;
	}

	public Pedido validarCantidadDeProductosEnLaLineaDePedido(Pedido pedido, List<LineaPedido> lineaPedido) {
		int cantidadTotalProductos = 0;
		if (lineaPedido.isEmpty()) {
			throw new ExcepcionValoresObligatorios(LINEAS_OBLIGATORIAS);
		} else {
			for (LineaPedido lineas : lineaPedido) {
				cantidadTotalProductos += lineas.getCantidad();
				pedido.agregarItemsAlPedido(lineas);
			}
		}
		if (cantidadTotalProductos < MINIMO_PRODUCTOS) {
			throw new ExcepcionCantidadMaximaProductos(VALIDACION_PRODUCTOS_MINIMOS);
		}
		return pedido;
	}

	public Pedido validarCantidadDeProductosEnStock(Pedido pedido, List<LineaPedido> lineaPedido) {
		for (LineaPedido lineas : lineaPedido) {
			ProductoOriginario productoOriginario = (ProductoOriginario) lineas.getProducto();
			int cantidadDeProductosPorCategoria = this.repositorioInventario
					.cantidadDeProductosEnStock(productoOriginario.getCategoria().getNombreCategoria());
			if (lineas.getCantidad() > cantidadDeProductosPorCategoria) {
				throw new ExcepcionCantidadDePedidoSuperaStock(VALIDACION_CANTIDAD_SUPERA_STOCK);
			}
		}
		return pedido;
	}

	public void validarPagoClienteEnPedidosAnteriores(Pedido pedido) {
		if (!elClienteDebeAlgunPago(pedido)) {
			throw new ExcepcionFaltaDePago(FALTA_PAGO);
		}
	}

	private boolean elClienteDebeAlgunPago(Pedido pedido) {
		boolean bandera = true;
		if (pedido.getPersona().getTipoPersona().contentEquals(PERSONA_NATURAL)) {
			PersonaNatural personaNatural = (PersonaNatural) pedido.getPersona();
			List<Pedido> listaPedidosClienteNatural = this.repositorioPedido
					.consultaPedidosRealizados(personaNatural.getCedula());
			bandera = consultarPagosDelCliente(listaPedidosClienteNatural);
		}
		if(pedido.getPersona().getTipoPersona().contentEquals(PERSONA_JURIDICA)) {
			PersonaJuridica personaJuridica = (PersonaJuridica) pedido.getPersona();
			List<Pedido> listaPedidosClienteNatural = this.repositorioPedido
					.consultaPedidosRealizados(personaJuridica.getNit());
			bandera = consultarPagosDelCliente(listaPedidosClienteNatural);
		}
		return bandera;
	}
	

	private boolean consultarPagosDelCliente(List<Pedido> listaPedidosClienteNatural) {
		boolean elClientePago = true;
		for (Pedido pedido : listaPedidosClienteNatural) {
			if (pedido.getEstado() != Estados.PAGADO) {
				elClientePago = false;
			}
		}
		return elClientePago;
	}
	
}
