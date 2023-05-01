package tdas;

import proyecto_algoritmos.Pedido;

public interface DiccionarioSimplePedidosTDA {
	void InicializarDiccionario();
	void Agregar(Pedido pedido);
	void Eliminar(int clave);
	Pedido Recuperar(int clave);
	ConjuntoTDA Claves();
}
