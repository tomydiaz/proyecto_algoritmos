package tdas;

import proyecto_algoritmos.Pedido;

public interface DiccionarioSimplePedidosTDA {
	void InicializarDiccionario();
	void Agregar(int clave, Pedido pedidos);
	void Eliminar(int clave);
	int Recuperar(int clave);
	ConjuntoTDA Claves();
}
