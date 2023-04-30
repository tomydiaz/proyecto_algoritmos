package dinamicas;

import tdas.PilaPedidosTDA;

public class PilaPedidos implements PilaPedidosTDA {
	private class Nodo {
		int data;
		Nodo siguiente;
	}
	
	private Nodo primero;
	
	public void InicializarPila() {
		primero = null;
	}
	
	public void Apilar(int x) {
		Nodo nuevo = new Nodo();
		nuevo.data = x;
		nuevo.siguiente = primero;
		primero = nuevo;
	}
	public void Desapilar() {
		primero = primero.siguiente;
	}
	
	public boolean PilaVacia() {
		return primero == null;
	}
	
	public int Tope() {
		return primero.data;
	}
}
