package dinamicas;

import tdas.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
	private class Nodo {
		int data;
		Nodo siguiente;
	}
	
	private Nodo inicio;
	
	public void InicializarConjunto() {
		inicio = null;
	}
	
	public int Elegir() {
		return inicio.data;
	}
	
	public void Sacar(int x) {
		if (inicio != null) {
			if (inicio.data == x) {
				inicio = inicio.siguiente;
			} else {
				Nodo aux = inicio;
				while (aux.siguiente != null && aux.siguiente.data != x) {
					aux = aux.siguiente;
				}
				if (aux.siguiente != null) {
					aux.siguiente = aux.siguiente.siguiente;
				}
			}
		} 
	}
	
	public void Agregar(int x) {
		if (!this.Pertenece(x)) {
			Nodo nuevo = new Nodo();
			nuevo.data = x;
			nuevo.siguiente = inicio;
			inicio = nuevo;
		}
	}
	
	public boolean Pertenece(int x) {
		Nodo aux = inicio;
		while (aux != null && aux.data != x) {
			aux = aux.siguiente;
		}
		return (aux != null);
	}
	
	public boolean ConjuntoVacio() {
		return inicio == null;
	}
	
	

}
