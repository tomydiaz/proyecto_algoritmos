package dinamicas;

import tdas.ConjuntoProductosCantidadTDA;
import proyecto_algoritmos.ProductoCantidad;

public class ConjuntoProductosCantidad implements ConjuntoProductosCantidadTDA {
	private class Nodo {
		ProductoCantidad productoCantidad;
		Nodo siguiente;
	}
	
	private Nodo inicio;
	
	public void InicializarConjunto() {
		inicio = null;
	}
	
	public ProductoCantidad Elegir() {
		if (inicio != null) {
  		  return inicio.productoCantidad;
  	  	}
  	  	return null;
	}
	
	public void Sacar(int id) {
		if (inicio != null) {
			if (inicio.productoCantidad.getId() == id) {
				inicio = inicio.siguiente;
			} else {
				Nodo aux = inicio;
				while (aux.siguiente != null && aux.siguiente.productoCantidad.getId() != id) {
					aux = aux.siguiente;
				}
				if (aux.siguiente != null) {
					aux.siguiente = aux.siguiente.siguiente;
				}
			}
		} 
	}
	
	public void Agregar(ProductoCantidad productoCantidad) {
		if (!this.Pertenece(productoCantidad.getId())) {
			Nodo nuevo = new Nodo();
			nuevo.productoCantidad = productoCantidad;
			nuevo.siguiente = inicio;
			inicio = nuevo;
		}
	}
	
	public boolean Pertenece(int id) {
		Nodo aux = inicio;
		while (aux != null && aux.productoCantidad.getId() != id) {
			aux = aux.siguiente;
		}
		return (aux != null);
	}
	
	public boolean ConjuntoVacio() {
		return inicio == null;
	}
	
	

}
