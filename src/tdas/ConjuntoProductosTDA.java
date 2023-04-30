package tdas;

import proyecto_algoritmos.Producto;

public interface ConjuntoProductosTDA {
	void InicializarConjunto();
	int Elegir();
	void Sacar(Producto producto);
	void Agregar(Producto producto);
	boolean Pertenece(Producto producto);
	boolean ConjuntoVacio();

}