package proyecto_algoritmos;

import java.time.LocalDateTime;

// ver pedidos con productos repetidos // clase productocantidad atributos: Producto, int cantidad (prioridad alta)
// ver como acceder a propiedad de SistemaPizzeria sin poder modificarlo - Gonza clase lunes - POO

public class ProyectoAlgoritmos {
	public static void main(String[] args) {
		// Escenario: Pizzería
		SistemaPizzeria sistema = new SistemaPizzeria();
		
		int[] idsProductos = { 1, 2, 3, 4 }; // no se estan agregando repetidos, leer arriba
		Pedido pedido = sistema.crearPedido("Tomas Diaz", LocalDateTime.now(), idsProductos, "Copacabana 183");
		
		sistema.pasarPedidoAPreparacion();
		
		sistema.pasarPedidoACompletado(pedido.getId());
		
		System.out.println(pedido.getId());
	}
	// LINEA PARA PROBAR EL PUSHH
}
