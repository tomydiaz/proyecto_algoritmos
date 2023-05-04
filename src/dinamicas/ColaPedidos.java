package dinamicas;

import tdas.ColaPedidosTDA;
import proyecto_algoritmos.Pedido;

public class ColaPedidos implements ColaPedidosTDA {
      private class Nodo {
    	  Pedido pedido;
    	  Nodo siguiente;
      }
      
      private Nodo primero;
      private Nodo ultimo;
      
      public void InicializarCola() {
    	  primero = null;
    	  ultimo = null;
      }
      
      public void Acolar(Pedido pedido) {
    	  Nodo nuevo = new Nodo();
    	  nuevo.pedido = pedido;
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
      
      public Pedido Primero() {
    	  if (primero != null) {
    		  return primero.pedido;
    	  }
    	  return null;
    	  
      }
}
