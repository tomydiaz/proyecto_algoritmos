package proyecto_algoritmos;

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

public class ProyectoAlgoritmos {

	public static void main(String[] args) {
		// Escenario: Pizzería
		
		// Se debe utilizar una cola para gestionar los pedidos pendientes. - LISTO
		ColaPedidosTDA pedidosPendientes = new ColaPedidos(); // Pendientes
		pedidosPendientes.InicializarCola();
		
		// Conjunto para pedidos en preparacion. - LISTO
		ConjuntoPedidosTDA pedidosEnPreparacion = new ConjuntoPedidos(); // En Preparacion
		pedidosEnPreparacion.InicializarConjunto();
		
		// Pedidos completados: se debe utilizar una pila para almacenar los pedidos completados. - LISTO
		PilaPedidosTDA pedidosCompletados = new PilaPedidos(); // Entregados
		pedidosCompletados.InicializarPila();
		
		// Consulta de historial de pedidos: el sistema debe permitir acceder a un historial de pedidos anteriores,
		// incluyendo detalles como el identificador único del pedido, la fecha y hora del pedido, la lista de productos
		// solicitados y el estado de la entrega. Se debe utilizar un diccionario para almacenar la información de los pedidos. 
		DiccionarioSimplePedidosTDA historialPedidos = new DiccionarioSimplePedidos(); // Entregados
		historialPedidos.InicializarDiccionario();
		
		// Productos disponibles: se debe utilizar un conjunto para almacenar los productos disponibles en el menú. - LISTO
		// PREGUNTAR PROFE SI SE PUEDE USAR DICCIONARIO
		ConjuntoProductosTDA productosDisponibles = new ConjuntoProductos();
		productosDisponibles.InicializarConjunto();
		
		Producto pizzaMargarita = new Producto(1, "Pizza Margarita", 10);
		Producto pizzaNapolitana = new Producto(2, "Pizza Napolitana", 10);
		Producto pizzaCalabresa = new Producto(3, "Pizza Calabresa", 10);
		Producto pizzaCuatroQuesos = new Producto(4, "Pizza Cuatro Quesos", 10);
		Producto pizzaVegetariana = new Producto(5, "Pizza Vegetariana", 10);
		Producto bebidaGaseosa = new Producto(6, "Bebida Gaseosa", 10);
		
		productosDisponibles.Agregar(pizzaMargarita);
		productosDisponibles.Agregar(pizzaNapolitana);
		productosDisponibles.Agregar(pizzaCalabresa);
		productosDisponibles.Agregar(pizzaCuatroQuesos);
		productosDisponibles.Agregar(pizzaVegetariana);
		productosDisponibles.Agregar(bebidaGaseosa);
		
		
		// aca abajo jugar con el sistema y probar
		
	}

}
