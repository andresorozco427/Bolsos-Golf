package com.ceiba.puerto.repositorio;

import java.util.List;

import com.ceiba.modelo.Pedido;

public interface RepositorioPedido {
	
	public void guardar(Pedido pedido);

	public void actualizarPedido(Pedido pedido);
	
	public List<Pedido> consultaPedidosRealizados(String identificacionCliente);
}
