package proyecto_algoritmos;

import java.time.LocalDateTime;

import dinamicas.ColaPedidos;
import dinamicas.ConjuntoPedidos;
import dinamicas.PilaPedidos;
import dinamicas.DiccionarioSimplePedidos;
import dinamicas.ConjuntoProductos;

import tdas.ColaPedidosTDA;
import tdas.ConjuntoPedidosTDA;
import tdas.PilaPedidosTDA;
import tdas.DiccionarioSimplePedidosTDA;
import tdas.ConjuntoProductosTDA;

// PREGUNTAR:
// como manejar el tema del incrementador de ID's de pedidos
// ver pedidos con productos repetidos // clase producto heredada, productopedido con atributo cantidad
// ver tema de extraer metodos en otras clases

public class ProyectoAlgoritmos {

	static public Pedido crearPedido(int id, String nombreCliente, LocalDateTime fechaHora, int[] idsProductos,
			String direccion, ConjuntoProductosTDA productosDisponibles) {

		ConjuntoProductosTDA auxProductosDisponibles = productosDisponibles;
		ConjuntoProductosTDA misProductos = new ConjuntoProductos();

		while (!auxProductosDisponibles.ConjuntoVacio()) {
			Producto productoElegido = auxProductosDisponibles.Elegir();

			for (int idProducto : idsProductos) {
				if (idProducto == productoElegido.getId()) {
					misProductos.Agregar(productoElegido);
				}
			}
			auxProductosDisponibles.Sacar(productoElegido.getId());
		}
		
		Pedido pedido = new Pedido(id, nombreCliente, fechaHora, misProductos, direccion);
		return pedido;
	}

	static public void pasarPedidoAPreparacion(ColaPedidosTDA pedidosPendientes, ConjuntoPedidosTDA pedidosEnPreparacion) {
		Pedido miPedido = pedidosPendientes.Primero();
		pedidosPendientes.Desacolar();
		miPedido.actualizarEstado("En Preparacion");
		pedidosEnPreparacion.Agregar(miPedido);
		
	}
	
	static public void pasarPedidoACompletado(int id, ConjuntoPedidosTDA pedidosEnPreparacion, PilaPedidosTDA pedidosCompletados) {
		ConjuntoPedidosTDA auxPedidosEnPreparacion = pedidosEnPreparacion;
		Pedido aux = pedidosEnPreparacion.Elegir();
		
		while (aux != null && aux.getId() != id) { // NO ES EL QUE BUSCAMOS
			auxPedidosEnPreparacion.Sacar(aux.getId());
			aux = pedidosEnPreparacion.Elegir();
		}
		if (aux != null) {
			pedidosEnPreparacion.Sacar(aux.getId());
			aux.actualizarEstado("Completado");
			pedidosCompletados.Apilar(aux);
		}
	}

	public static void main(String[] args) {
		// Escenario: Pizzería

		// Se debe utilizar una cola para gestionar los pedidos pendientes. - LISTO
		ColaPedidosTDA pedidosPendientes = new ColaPedidos(); // Pendientes
		pedidosPendientes.InicializarCola();

		// Conjunto para pedidos en preparacion. - LISTO
		ConjuntoPedidosTDA pedidosEnPreparacion = new ConjuntoPedidos(); // En Preparacion
		pedidosEnPreparacion.InicializarConjunto();

		// Pedidos completados: se debe utilizar una pila para almacenar los pedidos
		// completados. - LISTO
		PilaPedidosTDA pedidosCompletados = new PilaPedidos(); // Completados
		pedidosCompletados.InicializarPila();

		// Consulta de historial de pedidos: el sistema debe permitir acceder a un
		// historial de pedidos anteriores,
		// incluyendo detalles como el identificador único del pedido, la fecha y hora
		// del pedido, la lista de productos
		// solicitados y el estado de la entrega. Se debe utilizar un diccionario para
		// almacenar la información de los pedidos.
		DiccionarioSimplePedidosTDA historialPedidos = new DiccionarioSimplePedidos();
		historialPedidos.InicializarDiccionario();

		// Productos disponibles: se debe utilizar un conjunto para almacenar los
		// productos disponibles en el menú. - LISTO
		ConjuntoProductosTDA productosDisponibles = new ConjuntoProductos();
		productosDisponibles.InicializarConjunto();

		Producto pizzaMargarita = new Producto(1, "Pizza Margarita", 10);
		Producto pizzaNapolitana = new Producto(2, "Pizza Napolitana", 10);
		Producto pizzaCalabresa = new Producto(3, "Pizza Calabresa", 10);
		Producto pizzaCuatroQuesos = new Producto(4, "Pizza Cuatro Quesos", 10);
		Producto pizzaVegetariana = new Producto(5, "Pizza Vegetariana", 10);
		Producto bebidaGaseosa = new Producto(6, "Bebida Gaseosa", 10);

		// aca creamos el menu
		productosDisponibles.Agregar(pizzaMargarita);
		productosDisponibles.Agregar(pizzaNapolitana);
		productosDisponibles.Agregar(pizzaCalabresa);
		productosDisponibles.Agregar(pizzaCuatroQuesos);
		productosDisponibles.Agregar(pizzaVegetariana);
		productosDisponibles.Agregar(bebidaGaseosa);

		// aca abajo jugar con el sistema y probar

		// ver si esto se unifica o que onda (INICIO)
		int[] idsProductos = { 1, 1, 2, 3, 4 }; // no se estan agregando repetidos, leer arriba
		Pedido nuevoPedido = crearPedido(20, "Tomas Diaz", LocalDateTime.now(), idsProductos, "Copacabana 183",
				productosDisponibles);
		pedidosPendientes.Acolar(nuevoPedido);
		historialPedidos.Agregar(nuevoPedido);
		// ver si esto se unifica o que onda (FINAL)
		
		System.out.println("pendientes vacio: " + pedidosPendientes.ColaVacia());
		System.out.println("en preparacion vacio: " + pedidosEnPreparacion.ConjuntoVacio());
		System.out.println("completados vacio: " + pedidosCompletados.PilaVacia());
		System.out.println("-----");

		System.out.println(historialPedidos.Recuperar(nuevoPedido.getId()).getEstado());
		
		pasarPedidoAPreparacion(pedidosPendientes, pedidosEnPreparacion);
		
		System.out.println("pendientes vacio: " + pedidosPendientes.ColaVacia());
		System.out.println("en preparacion vacio: " + pedidosEnPreparacion.ConjuntoVacio());
		System.out.println("completados vacio: " + pedidosCompletados.PilaVacia());
		System.out.println("-----");
		
		System.out.println(historialPedidos.Recuperar(nuevoPedido.getId()).getEstado());
		
		pasarPedidoACompletado(nuevoPedido.getId(), pedidosEnPreparacion, pedidosCompletados);
		
		System.out.println("pendientes vacio: " + pedidosPendientes.ColaVacia());
		System.out.println("en preparacion vacio: " + pedidosEnPreparacion.ConjuntoVacio());
		System.out.println("completados vacio: " + pedidosCompletados.PilaVacia());
		System.out.println("-----");
		
		System.out.println(historialPedidos.Recuperar(nuevoPedido.getId()).getEstado());
		
		System.out.println("Chequear si un producto esta en el pedido: " + historialPedidos.Recuperar(nuevoPedido.getId()).getProductos().Pertenece(1));
	}

}
