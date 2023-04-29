package proyecto_algoritmos;

import java.time.LocalDateTime;

import tdas.PilaTDA;
import tdas.ColaTDA;
import tdas.ConjuntoTDA;
import tdas.DiccionarioSimpleTDA;

import dinamicas.Pila;
import dinamicas.Cola;
import dinamicas.Conjunto;
import dinamicas.DiccionarioSimple;




public class ProyectoAlgoritmos {

	public static void main(String[] args) {
		// Escenario: Pizzería
		// Consigna: Sistema de gestión de pedidos para pizzería 
		// Una pizzería desea implementar un sistema informático para la gestión de sus pedidos,
		// con el objetivo de mejorar la eficiencia en la toma de pedidos,
		// la gestión de los mismos y el control de las ventas. 
		// Especificación de las funcionalidades del sistema: 
		// Registro de pedidos: el sistema debe permitir realizar los siguientes tipos de pedidos:
		// Pizza Margarita, Pizza Napolitana, Pizza Calabresa, Pizza de cuatro quesos, Pizza vegetariana y bebida gaseosa.
		
		
		// Gestión de pedidos: el sistema debe permitir acceder a una lista de pedidos pendientes y completados. - LISTO
		// y actualizar el estado de los pedidos según su estado de progreso (por ejemplo, "en preparación", "en camino", "entregado").
		// Se debe utilizar una cola para gestionar los pedidos pendientes. - LISTO
		
		// Consulta de historial de pedidos: el sistema debe permitir acceder a un historial de pedidos anteriores,
		// incluyendo detalles como el identificador único del pedido, la fecha y hora del pedido, la lista de productos
		// solicitados y el estado de la entrega. Se debe utilizar un diccionario para almacenar la información de los pedidos. 
		// Productos disponibles: se debe utilizar un conjunto para almacenar los productos disponibles en el menú. - LISTO
		// Pedidos completados: se debe utilizar una pila para almacenar los pedidos completados. - LISTO
		
		
		// Cada pedido debe incluir la siguiente información: - LISTO
		// Identificador único del pedido. - LISTO
		// Nombre del cliente. - LISTO
		// Fecha y hora del pedido. - LISTO
		// Lista de productos solicitados. - LISTO
		// Dirección de entrega. - LISTO
		@SuppressWarnings("unused")
		class Pedido {
			int id;
			String nombreCliente;
			LocalDateTime fechaHora; // LocalDateTime.now fechaHora = LocalDateTime.now()
			ConjuntoTDA productos;
			String direccion;
		}
		
		PilaTDA pedidosCompletados = new Pila();
		pedidosCompletados.InicializarPila();
		
		ColaTDA pedidosPendientes = new Cola();
		pedidosPendientes.InicializarCola();
		
		ConjuntoTDA productosDisponibles = new Conjunto();
		productosDisponibles.InicializarConjunto();
		
		DiccionarioSimpleTDA historialPedidos = new DiccionarioSimple();
		historialPedidos.InicializarDiccionario();
		
		
	}

}
