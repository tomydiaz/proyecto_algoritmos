package dinamicas;

import tdas.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
	private class NodoPrioridad {
		int data;
		int prioridad;
		NodoPrioridad siguiente;
	}

	private NodoPrioridad primero;

	public void InicializarCola() {
		primero = null;
	}

	public void AcolarPrioridad(int x, int prioridad) {
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.data = x;
		nuevo.prioridad = prioridad;
		if (primero == null || primero.prioridad < prioridad) {
			nuevo.siguiente = primero;
			primero = nuevo;
		} else {
			NodoPrioridad aux = primero;
			while (aux.siguiente != null && aux.siguiente.prioridad >= prioridad) {
				aux=aux.siguiente;
			}
			nuevo.siguiente = aux.siguiente;
			aux.siguiente = nuevo;
		}
	}
	
	public void Desacolar() {
		primero = primero.siguiente;
	}
	
	public boolean ColaVacia() {
		return primero == null;
	}
	
	public int Primero() {
		return primero.data;
	}
	
	public int Prioridad() {
		return primero.prioridad;
	}


}
