package tdas;

import proyecto_algoritmos.ProductoCantidad;

public interface ConjuntoProductosCantidadTDA {
	void InicializarConjunto();
	ProductoCantidad Elegir();
	void Sacar(int id);
	void Agregar(ProductoCantidad productoCantidad);
	boolean Pertenece(int id);
	boolean ConjuntoVacio();
}