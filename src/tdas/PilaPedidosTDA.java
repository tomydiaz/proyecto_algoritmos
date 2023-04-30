package tdas;

import proyecto_algoritmos.Pedido;

public interface PilaPedidosTDA {
	void InicializarPila();
	void Apilar(Pedido pedido);
	void Desapilar();
	boolean PilaVacia();
	int Tope();
}
