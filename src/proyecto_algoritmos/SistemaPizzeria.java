package proyecto_algoritmos;

import java.time.LocalDateTime;

import dinamicas.ColaPedidos;
import dinamicas.ConjuntoPedidos;
import dinamicas.ConjuntoProductos;
import dinamicas.ConjuntoProductosCantidad;
import dinamicas.DiccionarioSimplePedidos;
import dinamicas.PilaPedidos;

import tdas.ColaPedidosTDA;
import tdas.ConjuntoPedidosTDA;
import tdas.ConjuntoProductosTDA;
import tdas.ConjuntoProductosCantidadTDA;
import tdas.DiccionarioSimplePedidosTDA;
import tdas.PilaPedidosTDA;

public class SistemaPizzeria {
	
	private static ColaPedidosTDA pedidosPendientes = new ColaPedidos(); 
	private static ConjuntoPedidosTDA pedidosEnPreparacion = new ConjuntoPedidos();
	private static PilaPedidosTDA pedidosCompletados = new PilaPedidos(); 
	private static DiccionarioSimplePedidosTDA historialPedidos = new DiccionarioSimplePedidos();
	private static ConjuntoProductosTDA productosDisponibles = new ConjuntoProductos();
	
	public SistemaPizzeria() {
		System.out.println("Inicializando conjuntos, pilas, colas y diccionarios");
		pedidosPendientes.InicializarCola();
		pedidosEnPreparacion.InicializarConjunto();
		pedidosCompletados.InicializarPila();
		historialPedidos.InicializarDiccionario();
		productosDisponibles.InicializarConjunto();
		System.out.println("Todo inicializado");
		
		
		// aca creamos los productos del menu
		Producto pizzaMargarita = new Producto(1, "Pizza Margarita");
		Producto pizzaNapolitana = new Producto(2, "Pizza Napolitana");
		Producto pizzaCalabresa = new Producto(3, "Pizza Calabresa");
		Producto pizzaCuatroQuesos = new Producto(4, "Pizza Cuatro Quesos");
		Producto pizzaVegetariana = new Producto(5, "Pizza Vegetariana");
		Producto bebidaGaseosa = new Producto(6, "Bebida Gaseosa");

		// aca lo agregamos al menu
		productosDisponibles.Agregar(pizzaMargarita);
		productosDisponibles.Agregar(pizzaNapolitana);
		productosDisponibles.Agregar(pizzaCalabresa);
		productosDisponibles.Agregar(pizzaCuatroQuesos);
		productosDisponibles.Agregar(pizzaVegetariana);
		productosDisponibles.Agregar(bebidaGaseosa);
		
	}
	
	public Pedido crearPedido(String nombreCliente, LocalDateTime fechaHora, int[] idsProductos,
			String direccion) {

		System.out.println("Creando pedido...");
		ConjuntoProductosTDA auxProductosDisponibles = new ConjuntoProductos();
		auxProductosDisponibles.InicializarConjunto();
		ConjuntoProductosCantidadTDA misProductos = new ConjuntoProductosCantidad();
		misProductos.InicializarConjunto();
		
		
		System.out.println("Menu vacio: " + productosDisponibles.ConjuntoVacio());
		
		System.out.println("A punto de entrar al while (crearPedido)");
		
		while(!productosDisponibles.ConjuntoVacio()) { // por cada producto disponible en el menu itero
			
			
			Producto aux = productosDisponibles.Elegir(); // elijo un producto del menu
			int cantidad = 0; // inicializo una cantidad
			for (int idProducto : idsProductos) { // por cada elemento de la lista de productos elegidos, comparo
				if (aux.getId() == idProducto) { // si encuentra coincidencia, suma 1, esto es lo que permite repetidos
					cantidad++;
				}
			}
			
			System.out.println("Agregue " + cantidad + " " + aux.getNombre()); // que agregue al pedido? que cantidad?
			
			ProductoCantidad productoCantidad = new ProductoCantidad(aux, cantidad); // crea el producto con su respectiva cantidad
			
			misProductos.Agregar(productoCantidad); // agrega el producto + cantindad al conjunto de mis productos cantidad
			
			auxProductosDisponibles.Agregar(aux); // agrega el producto original del menu al conjunto auxiliar para no perder la informacion de ese producto
			productosDisponibles.Sacar(aux.getId()); // saca ese producto original del conjunto original para seguir iterando con un producto diferente
		}
		
		System.out.println("Productos disponibles vacio? (deberia ser true, esto es antes de reasignarlo): " + productosDisponibles.ConjuntoVacio());
		productosDisponibles = auxProductosDisponibles;
		System.out.println("Productos disponibles vacio? (deberia ser false, esto es despues de reasignarlo): " + productosDisponibles.ConjuntoVacio());
		
		System.out.println("Acaba de terminar el while (crear pedido)");
		
		 // sobreescribe el conjunto original con el auxiliar para no perder los productos disponibles
		
		Pedido pedido = new Pedido(nombreCliente, fechaHora, misProductos, direccion); 
		
		pedidosPendientes.Acolar(pedido);
		historialPedidos.Agregar(pedido);
		return pedido;
	}

	public void pasarPedidoAPreparacion() {
		Pedido miPedido = pedidosPendientes.Primero();
		if (miPedido != null) {
			pedidosPendientes.Desacolar();
			miPedido.actualizarEstado("En Preparacion");
			pedidosEnPreparacion.Agregar(miPedido);
		}
	}
	
	public void pasarPedidoACompletado(int id){
		ConjuntoPedidosTDA auxPedidosEnPreparacion = new ConjuntoPedidos();
		auxPedidosEnPreparacion.InicializarConjunto();
		Pedido aux = pedidosEnPreparacion.Elegir();
		
		while (aux != null) {
			if (aux.getId() == id) {
				// caso positivo, encontrado		
				aux.actualizarEstado("Completado");
				pedidosCompletados.Apilar(aux);
			} else {
				// caso negativo, no encontrado	
				auxPedidosEnPreparacion.Agregar(aux);
			}
			pedidosEnPreparacion.Sacar(aux.getId());
			aux = pedidosEnPreparacion.Elegir();
		}
		
		aux = auxPedidosEnPreparacion.Elegir();
		while (aux != null) {
			pedidosEnPreparacion.Agregar(aux);
			auxPedidosEnPreparacion.Sacar(aux.getId());
			aux = auxPedidosEnPreparacion.Elegir();
		}
	}

}
