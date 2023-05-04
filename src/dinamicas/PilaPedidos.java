package dinamicas;

import tdas.PilaPedidosTDA;
import proyecto_algoritmos.Pedido;

public class PilaPedidos implements PilaPedidosTDA {
	private class Nodo {
		Pedido pedido;
		Nodo siguiente;
	}
	
	private Nodo primero;
	
	public void InicializarPila() {
		primero = null;
	}
	
	public void Apilar(Pedido pedido) {
		Nodo nuevo = new Nodo();
		nuevo.pedido = pedido;
		nuevo.siguiente = primero;
		primero = nuevo;
	}
	public void Desapilar() {
		primero = primero.siguiente;
	}
	
	public boolean PilaVacia() {
		return primero == null;
	}
	
	public Pedido Tope() {
		if (primero != null) {
			return primero.pedido;
		}
		return null;
		
	}
}
