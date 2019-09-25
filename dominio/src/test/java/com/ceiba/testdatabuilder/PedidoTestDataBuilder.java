package com.ceiba.testdatabuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ceiba.Constantes;
import com.ceiba.modelo.Estados;
import com.ceiba.modelo.LineaPedido;
import com.ceiba.modelo.Pedido;
import com.ceiba.modelo.persona.AbstractPersona;

public class PedidoTestDataBuilder {

	private LocalDateTime fechaPedido;
	private String tipoPedido;
	private AbstractPersona persona;
	private List<LineaPedido> lineaPedido;	
	private Estados estado;
	
	public PedidoTestDataBuilder() {
		this.fechaPedido = LocalDateTime.now();
		this.tipoPedido = "mercancia de bolsos";
		this.persona = new PersonaTestDataBuilder().conCedula(Constantes.CEDULA).buildPersonaNatural();
		this.lineaPedido = new ArrayList<>();
		this.estado = Estados.PENDIENTE;
	}
	
	public PedidoTestDataBuilder conFechaPedido(LocalDateTime fechaPedido) {
		this.fechaPedido = fechaPedido;
		return this;
	}
	
	public PedidoTestDataBuilder conTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
		return this;
	}
	
	public PedidoTestDataBuilder conPersona(AbstractPersona persona) {
		this.persona = persona;
		return this;
	}
	
	public PedidoTestDataBuilder conLineasDePedido(LineaPedido linea) {
		this.lineaPedido.add(linea);
		return this;
	}
	
	public PedidoTestDataBuilder conEstado(Estados estado) {
		this.estado = estado;
		return this;
	}
	
	public Pedido build() {
		Pedido pedido = new Pedido(fechaPedido, tipoPedido, persona);
		pedido.setEstado(estado);
		return pedido;
		
	}
	
}
