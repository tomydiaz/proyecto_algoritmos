package proyecto_algoritmos;

import java.time.LocalDateTime;
import dinamicas.ConjuntoPedidos;
import tdas.ConjuntoPedidosTDA;

public class ProyectoAlgoritmos {
	public static void main(String[] args) {
		// Escenario: Pizzería
		
		SistemaPizzeria sistema = new SistemaPizzeria();
		
		int[] idsProductos = { 1,1,2,3,4 };
		
		Pedido pedido = sistema.crearPedido(1, "Tomas Diaz", LocalDateTime.now(), idsProductos, "Copacabana 183"); // Creando pedido y poniendolo como pendiente
		
		int[] idsProductos2 = { 1,1,1,1,6 };
		
		Pedido pedido2 = sistema.crearPedido(2, "Tomas Diaz", LocalDateTime.now(), idsProductos2, "Copacabana 183"); // Creando pedido y poniendolo como pendiente
		
		int[] idsProductos3 = { 1,1,2,2,3,3,4,4,5,5,6,6};
		
		Pedido pedido3 = sistema.crearPedido(3, "Tomas Diaz", LocalDateTime.now(), idsProductos3, "Copacabana 183"); // Creando pedido y poniendolo como pendiente
		
		
		sistema.pasarPedidoAPreparacion(); // Pasando el siguiente pendiente a preparacion
		sistema.pasarPedidoAPreparacion();// Pasando el siguiente pendiente a preparacion
		
		sistema.pasarPedidoACompletado(pedido.getId()); // Pasando uno en especifico de preparacion a completado
		sistema.pasarPedidoACompletado(pedido2.getId());
		sistema.pasarPedidoACompletado(pedido3.getId());
		sistema.pasarPedidoACompletado(20);
		
		System.out.println("Pendientes vacio: " + sistema.pedidosPendientes.ColaVacia()); // estos atributos deberian ser privados, estan publicos para testeo sistema.blabla
		
		System.out.println("En preparacion vacio: " + sistema.pedidosEnPreparacion.ConjuntoVacio()); // estos atributos deberian ser privados, estan publicos para testeo sistema.blabla
		
		System.out.println("Completados vacio: " + sistema.pedidosCompletados.PilaVacia()); // estos atributos deberian ser privados, estan publicos para testeo sistema.blabla
		
		
		/* aca ver que productos se agregaron */
	}
}
