package com.ceiba.consulta.servicio;

import java.util.List;
import java.util.stream.Collectors;

import com.ceiba.modelo.Estados;
import com.ceiba.modelo.Pedido;
import com.ceiba.puerto.repositorio.RepositorioInventario;
import com.ceiba.puerto.repositorio.RepositorioPedido;

public class PedidoConsultaService {
	
	private RepositorioPedido repositorioPedido;
	private RepositorioInventario repositorioInventario;
	
	public PedidoConsultaService(RepositorioPedido repositorioPedido, RepositorioInventario repositorioInventario) {
		this.repositorioPedido = repositorioPedido;
		this.repositorioInventario = repositorioInventario;
	}	
	
	public void validacionAutomatizadaDeProductosEnCola(List<Pedido> pedidos) {
		pedidos.stream().filter(h -> h.getEstado() == Estados.EN_ESPERA).collect(Collectors.toList());		
		for (Pedido pedido : pedidos) {
			pedido.setEstado(Estados.PENDIENTE);
			this.repositorioPedido.actualizarPedido(pedido);			
		}
	}
	
}
