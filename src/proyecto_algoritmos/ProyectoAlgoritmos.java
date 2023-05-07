package proyecto_algoritmos;

import java.time.LocalDateTime;
import dinamicas.ConjuntoPedidos;
import tdas.ConjuntoPedidosTDA;

public class ProyectoAlgoritmos {
	public static void main(String[] args) {
		// Escenario: Pizzería
		
		SistemaPizzeria sistema = new SistemaPizzeria();
		
		int[] idsProductos = { 1,1,2,3,4 };
		
		Pedido pedido = sistema.crearPedido(1, "Tomas Diaz", LocalDateTime.now(), idsProductos, "Copacabana 1"); // Creando pedido y poniendolo como pendiente
		
		int[] idsProductos2 = { 1,1,1,1,6 };
		
		Pedido pedido2 = sistema.crearPedido(2, "Tomas2 Diaz2", LocalDateTime.now(), idsProductos2, "Copacabana 2"); // Creando pedido y poniendolo como pendiente
		
		
		sistema.pasarPedidoAPreparacion(); // Pasando el siguiente pendiente a preparacion
		
		sistema.pasarPedidoACompletado(pedido.getId()); // Pasando uno en especifico de preparacion a completado
	
		
		int[] idsProductos3 = { 1,1,2,2,3,3,4,4,5,5,6,6};
		
		Pedido pedido3 = sistema.crearPedido(3, "Tomas3 Diaz3", LocalDateTime.now(), idsProductos3, "Copacabana 3"); // Creando pedido y poniendolo como pendiente
		
		sistema.pasarPedidoAPreparacion();// Pasando el siguiente pendiente a preparacion
		
		sistema.pasarPedidoAPreparacion(); // Pasando el siguiente pendiente a preparacion
		
		sistema.pasarPedidoACompletado(pedido2.getId());
		
		int[] idsProductos4 = { 1,1,2,2,3,3,4,4,5,5,6,6};
		
		Pedido pedido4 = sistema.crearPedido(4, "Tomas4 Diaz4", LocalDateTime.now(), idsProductos4, "Copacabana 4"); // Creando pedido y poniendolo como pendiente
		
		int[] idsProductos5 = { 1,1,2,2,3,3,4,4,5,5,6,6};
		
		Pedido pedido5 = sistema.crearPedido(5, "Tomas4 Diaz5", LocalDateTime.now(), idsProductos5, "Copacabana 5"); // Creando pedido y poniendolo como pendiente
		
		int[] idsProductos6 = { 1,1,2,2,3,3,4,4,5,5,6,6};
		
		Pedido pedido6 = sistema.crearPedido(6, "Tomas4 Diaz6", LocalDateTime.now(), idsProductos5, "Copacabana 6");
		
		sistema.pasarPedidoACompletado(pedido3.getId());
		
		sistema.pasarPedidoACompletado(20);
		
	}
}
