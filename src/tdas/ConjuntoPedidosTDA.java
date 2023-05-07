package tdas;

import proyecto_algoritmos.Pedido;

public interface ConjuntoPedidosTDA {
	void InicializarConjunto();
	Pedido Elegir();
	void Sacar(int id);
	void Agregar(Pedido pedido);
	boolean Pertenece(int id);
	boolean ConjuntoVacio();
}
