package dinamicas;

import tdas.ConjuntoPedidosTDA;
import proyecto_algoritmos.Pedido;

public class ConjuntoPedidos implements ConjuntoPedidosTDA {
	private class Nodo {
		Pedido pedido;
		Nodo siguiente;
	}
	
	private Nodo inicio;
	
	
	public ConjuntoPedidosTDA Copiar() {
		
		ConjuntoPedidosTDA clon = new ConjuntoPedidos();
		
		Nodo aux = inicio;
		while (aux != null) {
			clon.Agregar(aux.pedido);
			aux = aux.siguiente;
		}

		return clon;
	}
	
	public void InicializarConjunto() {
		inicio = null;
	}
	
	public Pedido Elegir() {
		if (inicio != null) {
  		  return inicio.pedido;
  	  	}
  	  	return null;
	}
	
	public void Sacar(int id) {
		if (inicio != null) {
			if (inicio.pedido.getId() == id) {
				inicio = inicio.siguiente;
			} else {
				Nodo aux = inicio;
				while (aux.siguiente != null && aux.siguiente.pedido.getId() != id) {
					aux = aux.siguiente;
				}
				if (aux.siguiente != null) {
					aux.siguiente = aux.siguiente.siguiente;
				}
			}
		} 
	}
	
	public void Agregar(Pedido pedido) {
		if (!this.Pertenece(pedido.getId())) {
			Nodo nuevo = new Nodo();
			nuevo.pedido = pedido;
			nuevo.siguiente = inicio;
			inicio = nuevo;
		}
	}
	
	public boolean Pertenece(int id) {
		Nodo aux = inicio;
		while (aux != null && aux.pedido.getId() != id) {
			aux = aux.siguiente;
		}
		return (aux != null);
	}
	
	public boolean ConjuntoVacio() {
		return inicio == null;
	}
	
	

}
