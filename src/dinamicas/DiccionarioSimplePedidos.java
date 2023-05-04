package dinamicas;

import tdas.DiccionarioSimplePedidosTDA;
import proyecto_algoritmos.Pedido;
import tdas.ConjuntoTDA;

public class DiccionarioSimplePedidos implements DiccionarioSimplePedidosTDA {
	private class NodoClave {
		int clave;
		Pedido pedido;
		NodoClave siguiente;
	}
	
	private NodoClave inicio;
	
	public void InicializarDiccionario() {
		inicio = null;
	}
	
	public void Agregar(Pedido pedido) {
		NodoClave nodo = ObtenerNodoClave(pedido.getId());
		if (nodo == null) {
			nodo = new NodoClave();
			nodo.clave = pedido.getId();
			nodo.siguiente = inicio;
			inicio = nodo;
		}
		nodo.pedido = pedido;
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
	
	public Pedido Recuperar(int clave) {
		NodoClave nodo = ObtenerNodoClave(clave);
		if (nodo != null) {
			return nodo.pedido;
  	  	}
  	  	return null;
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
