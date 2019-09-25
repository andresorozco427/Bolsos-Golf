package com.ceiba.modelo;

public enum Estados {
	
	//Estado pendiente de un pedido
	PENDIENTE,
	
	//Estado que indica que la cantidad actual en inventario es minima para el pedido
	EN_ESPERA,
	
	//Estado que indica el fin de un pedido
	TERMINADA,
	
	//Estado que indica que ya el pedido ha sido pagado y facturado
	PAGADO
}
