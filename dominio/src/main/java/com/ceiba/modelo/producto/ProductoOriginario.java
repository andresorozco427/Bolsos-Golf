package com.ceiba.modelo.producto;

public class ProductoOriginario extends AbstractProducto{
	private static final String CATEGORIA_OBLIGATORIO = "La categoria del producto es obligatoria";

	private Categoria categoria;
	private Integer cantidad;
	private boolean estado;
	
	public ProductoOriginario(String nombre, String descripcion, float precioUnitario,
			Categoria categoria, Integer cantidad) {
		super(nombre, descripcion, precioUnitario);
		ValidarArgumentosProducto.validarArgumentoCategoria(categoria.getNombreCategoria(), CATEGORIA_OBLIGATORIO);
		
		this.categoria = categoria;
		this.cantidad = cantidad;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
