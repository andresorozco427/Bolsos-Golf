package com.ceiba.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ceiba.modelo.persona.AbstractPersona;

public class Pedido{	
	
	private LocalDateTime fechaPedido;
	private String tipoPedido;
	private float valorTotal;
	private AbstractPersona persona;
	private List<LineaPedido> lineaPedido;	
	private Estados estado;

	public Pedido(LocalDateTime fechaPedido, String tipoPedido, AbstractPersona persona) {
		this.fechaPedido = fechaPedido;
		this.tipoPedido = tipoPedido;
		this.persona = persona;
		this.lineaPedido = new ArrayList<>();
		this.estado = Estados.PENDIENTE;
	}
	
	public void agregarItemsAlPedido(LineaPedido linea) {
		this.lineaPedido.add(linea);
	}

	public LocalDateTime getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDateTime fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public float getValorTotal() {
		float total = 0;
		
		int lineasDePedido = this.lineaPedido.size();
		
		for (int i = 0; i < lineasDePedido; i++) {
			total += this.lineaPedido.get(i).calcularImporte();
		}
		this.valorTotal = total;
		
    	return this.valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public AbstractPersona getPersona() {
		return persona;
	}

	public void setPersona(AbstractPersona persona) {
		this.persona = persona;
	}

	public List<LineaPedido> getLineaPedido() {
		return lineaPedido;
	}

	public void setLineaPedido(List<LineaPedido> lineaPedido) {
		this.lineaPedido = lineaPedido;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}
	
	
	
}
