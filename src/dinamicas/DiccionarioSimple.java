package dinamicas;

import tdas.ConjuntoTDA;
import tdas.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {
	private class NodoClave {
		int clave;
		int valor;
		NodoClave siguiente;
	}
	
	private NodoClave inicio;
	
	public void InicializarDiccionario() {
		inicio = null;
	}
	
	public void Agregar(int clave, int valor) {
		NodoClave nodo = ObtenerNodoClave(clave);
		if (nodo == null) {
			nodo = new NodoClave();
			nodo.clave = clave;
			nodo.siguiente = inicio;
			inicio = nodo;
		}
		nodo.valor = valor;
	}
	
	private NodoClave ObtenerNodoClave(int clave) {
		NodoClave aux = inicio;
		while (aux != null && aux.clave != clave) {
			aux = aux.siguiente;
		}
		return aux;
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
	
	public int Recuperar(int clave) {
		NodoClave nodo = ObtenerNodoClave(clave);
		return nodo.valor;
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
