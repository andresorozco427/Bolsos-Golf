package com.ceiba.modelo;

import java.time.LocalDateTime;

public class Factura {
	
	private String codigo;
	private LocalDateTime fecha;
	private float valorTotal;
	private String descripcion;
	private Pedido pedido;	
	
	public Factura(String codigo, LocalDateTime fecha, float valorTotal, String descripcion, Pedido pedido) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.valorTotal = valorTotal;
		this.descripcion = descripcion;
		this.pedido = pedido;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Pedido getPedido() {
		return pedido;
	}
	
	
}
