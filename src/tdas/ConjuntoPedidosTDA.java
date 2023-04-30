package tdas;

import proyecto_algoritmos.Pedido;

public interface ConjuntoPedidosTDA {
	void InicializarConjunto();
	int Elegir();
	void Sacar(Pedido pedido);
	void Agregar(Pedido pedido);
	boolean Pertenece(Pedido pedido);
	boolean ConjuntoVacio();

}
