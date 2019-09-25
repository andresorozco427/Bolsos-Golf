package com.ceiba;

public final class Constantes {
	
	private Constantes() {
		
	}
	
	//Productos
	public static final String NOMBRE_OBLIGATORIO = "El nombre del producto es obligatorio";
	public static final String PRECIO_OBLIGATORIO = "El precio del producto es obligatorio";
	public static final String CATEGORIA_OBLIGATORIO = "La categoria del producto es obligatoria";
	public static final int CANTIDAD_MAXIMA_PRODUCTOS_ORIGINARIOS = 41;
	
	//Personas
	public static final String NOMBRE_PERSONA_OBLIGATORIO = "El nombre es obligatorio";
	public static final String TELEFONO_OBLIGATORIO = "El telefono es obligatorio";
	public static final String DIRECCION_OBLIGATORIO = "La direccion es obligatorio";
	public static final String EMAIL_INVALIDO = "La direccion de email es invalida";
	public static final String TIPOPERSONA_OBLIGATORIO = "El tipo de persona es obligatorio";
	public static final String CIUDAD_OBLIGATORIO = "La ciudad es obligatoria";
	
	//Natural
	public static final String CEDULA_OBLIGATORIA = "La cedula es obligatoria";
	public static final String CEDULA_INVALIDA = "La cedula ingresada es invalida";
	public static final String PERSONA_YA_EXISTENTE = "La persona ingresada ya es existente en la base de datos";
	public static final String CEDULA = "71672415";	
	
	//Juridica
	public static final String NIT_OBLIGATORIO = "El nit es obligatorio";
	public static final String NIT_INVALIDO = "El nit ingresado es invalido";
	public static final String NIT = "99223445-4";
	public static final String PERSONA_JURIDICA = "juridica";
	
	//Proveedor
	public static final String MATERIAL_OBLIGATORIO = "El material es obligatorio";
	public static final String PRECIO_MATERIAL_OBLIGATORIO = "El precio es obligatorio";
	public static final String PERSONA_PROVEEDOR = "proveedor";
	
	//Categorias
	public static final String CATEGORIA_EXISTENTE= "La categoria ya existe";
	
	
	//Excepciones	
	public static final String VALIDACION_CANTIDAD_SUPERA_STOCK = "la cantidad pedida supera la cantidad almacenada en stock";
	public static final String LINEAS_OBLIGATORIAS = "El pedido debe tener lineas de pedido";
	public static final String VALIDACION_PRODUCTOS_MINIMOS = "El pedido debe tener como minimo 50 prodcutos";
	public static final String FALTA_PAGO = "El pedido debe tener lineas de pedido";
}
