package tdas;

import proyecto_algoritmos.Producto;

public interface ConjuntoProductosTDA {
	void InicializarConjunto();
	Producto Elegir();
	void Sacar(int id);
	void Agregar(Producto producto);
	boolean Pertenece(int id);
	boolean ConjuntoVacio();
}