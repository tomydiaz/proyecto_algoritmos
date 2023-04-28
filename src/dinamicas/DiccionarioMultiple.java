package dinamicas;

import tdas.ConjuntoTDA;
import tdas.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {
	private class NodoValor {
		int valor;
		NodoValor siguiente;
	}
	
	private class NodoClave {
		int clave;
		NodoValor valores;
		NodoClave siguiente;
	}
	
	private NodoClave inicio;
	
	public void InicializarDiccionario() {
		inicio = null;
	}
	
	private NodoClave ObtenerNodoClave(int clave) {
		NodoClave aux = inicio;
		while (aux != null && aux.clave != clave) {
			aux = aux.siguiente;
		}
		return aux;
	}
	
	public void Agregar(int clave, int valor) {
		NodoClave nodo = ObtenerNodoClave(clave);
		if (nodo == null) {
			nodo = new NodoClave();
			nodo.clave = clave;
			nodo.valores = null; // Agrego la clave SIN valores inicialmente
			nodo.siguiente = inicio;
			inicio = nodo;
		}
		NodoValor aux = nodo.valores;
		while (aux != null && aux.valor != valor) {
			aux = aux.siguiente;
		};
		if (aux == null) {
			NodoValor nuevoNodo = new NodoValor();
			nuevoNodo.valor = valor;
			nuevoNodo.siguiente = nodo.valores;
			nodo.valores = nuevoNodo;
		}
	}
	
	public void Eliminar(int clave) {
		if (inicio != null) {
			if (inicio.clave == clave) {
				inicio = inicio.siguiente;
			} else {
				NodoClave aux = inicio;
				while (aux.siguiente != null && aux.siguiente.clave != clave) {
					aux = aux.siguiente;
				}
				if (aux.siguiente != null) {
					aux.siguiente = aux.siguiente.siguiente;
				}
			}
		}
	}
	
	private void EliminarValorEnNodo(NodoClave nodo, int valor) {
		if (nodo.valores != null) {
			if (nodo.valores.valor == valor) {
				nodo.valores = nodo.valores.siguiente;
			} else {
				NodoValor aux = nodo.valores;
				while (aux.siguiente != null && aux.siguiente.valor != valor) {
					aux = aux.siguiente;
				}
				if (aux.siguiente != null) {
					aux.siguiente = aux.siguiente.siguiente;
				}
			}
		}
	}
	
	public void EliminarValor(int clave, int valor) {
		if (inicio != null) {
			if (inicio.clave == clave) {
				EliminarValorEnNodo(inicio, valor);
				if (inicio.valores == null) {
					inicio = inicio.siguiente;
				}
			} else {
				NodoClave aux = inicio;
				while (aux.siguiente != null && aux.siguiente.clave != clave) {
					aux = aux.siguiente;
				}
				if (aux.siguiente != null) {
					EliminarValorEnNodo(aux.siguiente, valor);
					if (aux.siguiente.valores == null) {
						aux.siguiente = aux.siguiente.siguiente;
					}
				}
			}
		}
	}
	
	public ConjuntoTDA Recuperar(int clave) {
		NodoClave nodo = ObtenerNodoClave(clave);
		ConjuntoTDA valores = new Conjunto();
		valores.InicializarConjunto();
		if (nodo != null) {
			NodoValor aux = nodo.valores;
			while (aux != null) {
				valores.Agregar(aux.valor);
				aux = aux.siguiente;
			}
		}
		return valores;
	}
	
	public ConjuntoTDA Claves() {
		ConjuntoTDA claves = new Conjunto();
		claves.InicializarConjunto();
		NodoClave aux = inicio;
		while (aux != null) {
			claves.Agregar(aux.clave);
			aux = aux.siguiente;
		}
		return claves;
	}

}
