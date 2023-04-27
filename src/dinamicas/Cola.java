package dinamicas;

import tdas.ColaTDA;

public class Cola implements ColaTDA {
      private class Nodo {
    	  int data;
    	  Nodo siguiente;
      }
      
      private Nodo primero;
      private Nodo ultimo;
      
      public void InicializarCola() {
    	  primero = null;
    	  ultimo = null;
      }
      
      public void Acolar(int x) {
    	  Nodo nuevo = new Nodo();
    	  nuevo.data = x;
    	  nuevo.siguiente = null;
    	  if (ultimo != null) {
    		  ultimo.siguiente = nuevo;
    	  }
    	  ultimo = nuevo;
    	  if (primero == null) {
    		  primero = ultimo;
    	  }
      }
      
      public void Desacolar() {
    	  primero = primero.siguiente;
    	  if (primero == null) {
    		  ultimo = null;
    	  }
      }
      
      public boolean ColaVacia() {
    	  return ultimo == null;
      }
      
      public int Primero() {
    	  return primero.data;
      }
}
