package tdas;

import proyecto_algoritmos.Pedido;

public interface ColaPedidosTDA {
	void InicializarCola();
	void Acolar(Pedido pedido);
	void Desacolar();
	boolean ColaVacia();
	Pedido Primero();
}