package proyecto_algoritmos;

import java.time.LocalDateTime;

// ver pedidos con productos repetidos // clase productocantidad atributos: Producto, int cantidad (prioridad alta)

public class ProyectoAlgoritmos {
	public static void main(String[] args) {
		// Escenario: Pizzería
		
		
		SistemaPizzeria sistema = new SistemaPizzeria();
		
		int[] idsProductos = { 1,1,2,3,4 };
		
		Pedido pedido = sistema.crearPedido("Tomas Diaz", LocalDateTime.now(), idsProductos, "Copacabana 183"); // Creando pedido y poniendolo como pendiente
		
		int[] idsProductos2 = { 1,1,1,1,6 };
		
		Pedido pedido2 = sistema.crearPedido("Tomas Diaz", LocalDateTime.now(), idsProductos2, "Copacabana 183"); // Creando pedido y poniendolo como pendiente
		
		int[] idsProductos3 = { 1,1,2,2,3,3,4,4,5,5,6,6};
		
		Pedido pedido3 = sistema.crearPedido("Tomas Diaz", LocalDateTime.now(), idsProductos3, "Copacabana 183"); // Creando pedido y poniendolo como pendiente
		
		sistema.pasarPedidoAPreparacion(); // Pasando el siguiente pendiente a preparacion
		
		sistema.pasarPedidoACompletado(pedido.getId()); // Pasando uno en especifico de preparacion a completado
		
		/* aca ver que productos se agregaron */
	}
}
