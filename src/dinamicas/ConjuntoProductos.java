package dinamicas;

import tdas.ConjuntoProductosTDA;
import proyecto_algoritmos.Producto;

public class ConjuntoProductos implements ConjuntoProductosTDA {
	private class Nodo {
		Producto producto;
		Nodo siguiente;
	}
	
	private Nodo inicio;
	
	public void InicializarConjunto() {
		inicio = null;
	}
	
	public Producto Elegir() {
		return inicio.producto;
	}
	
	public void Sacar(int id) {
		if (inicio != null) {
			if (inicio.producto.getId() == id) {
				inicio = inicio.siguiente;
			} else {
				Nodo aux = inicio;
				while (aux.siguiente != null && aux.siguiente.producto.getId() != id) {
					aux = aux.siguiente;
				}
				if (aux.siguiente != null) {
					aux.siguiente = aux.siguiente.siguiente;
				}
			}
		} 
	}
	
	public void Agregar(Producto producto) {
		if (!this.Pertenece(producto.getId())) {
			Nodo nuevo = new Nodo();
			nuevo.producto = producto;
			nuevo.siguiente = inicio;
			inicio = nuevo;
		}
	}
	
	public boolean Pertenece(int id) {
		Nodo aux = inicio;
		while (aux != null && aux.producto.getId() != id) {
			aux = aux.siguiente;
		}
		return (aux != null);
	}
	
	public boolean ConjuntoVacio() {
		return inicio == null;
	}
	
	

}
