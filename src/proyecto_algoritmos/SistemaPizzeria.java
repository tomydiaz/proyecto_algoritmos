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
		// System.out.println("Inicializando conjuntos, pilas, colas y diccionarios");
		pedidosPendientes.InicializarCola();
		pedidosEnPreparacion.InicializarConjunto();
		pedidosCompletados.InicializarPila();
		historialPedidos.InicializarDiccionario();
		productosDisponibles.InicializarConjunto();
		// System.out.println("Todo inicializado");
		
		
		// aca creamos los productos del menu
		Producto pizzaMargarita = new Producto(1, "Pizza Margarita");
		Producto pizzaNapolitana = new Producto(2, "Pizza Napolitana");
		Producto pizzaCalabresa = new Producto(3, "Pizza Calabresa");
		Producto pizzaCuatroQuesos = new Producto(4, "Pizza Cuatro Quesos");
		Producto pizzaVegetariana = new Producto(5, "Pizza Vegetariana");
		Producto bebidaGaseosa = new Producto(6, "Bebida Gaseosa");

		// aca los agregamos al menu
		productosDisponibles.Agregar(pizzaMargarita);
		productosDisponibles.Agregar(pizzaNapolitana);
		productosDisponibles.Agregar(pizzaCalabresa);
		productosDisponibles.Agregar(pizzaCuatroQuesos);
		productosDisponibles.Agregar(pizzaVegetariana);
		productosDisponibles.Agregar(bebidaGaseosa);
		
	}
	
	public Pedido crearPedido(int id, String nombreCliente, LocalDateTime fechaHora, int[] idsProductos,
			String direccion) {
		
		ConjuntoProductosTDA copiaProductosDisponibles = copiarConjuntoProductos(productosDisponibles);
		
		ConjuntoProductosCantidadTDA misProductos = new ConjuntoProductosCantidad();
		misProductos.InicializarConjunto();
		
		
		
		System.out.println("Creando el pedido numero " + id);
		System.out.print("Productos: ");
		
		while(!copiaProductosDisponibles.ConjuntoVacio()) { // por cada producto disponible en el menu itero
			Producto aux = copiaProductosDisponibles.Elegir(); // elijo un producto del menu
			int cantidad = 0; // inicializo una cantidad
			for (int idProducto : idsProductos) { // por cada elemento de la lista de productos elegidos, comparo
				if (aux.getId() == idProducto) { // si encuentra coincidencia, suma 1, esto es lo que permite repetidos
					cantidad++;
				}
			}
			
			System.out.print(cantidad + " " + aux.getNombre() + ", "); // que agregue al pedido? que cantidad?
			
			
			ProductoCantidad productoCantidad = new ProductoCantidad(aux, cantidad); // crea el producto con su respectiva cantidad
			misProductos.Agregar(productoCantidad);
			copiaProductosDisponibles.Sacar(aux.getId());
		}
		System.out.println();
		
		
		Pedido pedido = new Pedido(id, nombreCliente, fechaHora, misProductos, direccion); 
		pedidosPendientes.Acolar(pedido);
		historialPedidos.Agregar(pedido);
		
		return pedido;
	}
	
	public void pasarPedidoAPreparacion() {
		Pedido miPedido = pedidosPendientes.Primero();
		if (miPedido != null) {
			System.out.println("Pasando a preparacion el pedido - id: " + miPedido.getId());
			pedidosPendientes.Desacolar();
			miPedido.actualizarEstado("En Preparacion");
			pedidosEnPreparacion.Agregar(miPedido);
		}
	}
	
	public void pasarPedidoACompletado(int id){
		ConjuntoPedidosTDA copiaPedidosEnPreparacion = copiarConjuntoPedidos(pedidosEnPreparacion);
		
		Pedido aux = copiaPedidosEnPreparacion.Elegir();

		while (aux != null && aux.getId() != id) {
			copiaPedidosEnPreparacion.Sacar(aux.getId());
			aux = copiaPedidosEnPreparacion.Elegir();
		}
		
		if (aux != null && aux.getId() == id) {
			aux.actualizarEstado("Completado");
			pedidosEnPreparacion.Sacar(aux.getId());
			pedidosCompletados.Apilar(aux);
			System.out.println("Pase a completado el pedido - id: " + id);
		}
		
	}
	
	private ConjuntoProductosTDA copiarConjuntoProductos(ConjuntoProductosTDA conjuntoProductos) {
		ConjuntoProductosTDA copia = new ConjuntoProductos();
		copia.InicializarConjunto();
		
		ConjuntoProductosTDA conjuntoAuxiliar = new ConjuntoProductos();
		conjuntoAuxiliar.InicializarConjunto();
		
		while (!conjuntoProductos.ConjuntoVacio()) {
			Producto aux = conjuntoProductos.Elegir();
			copia.Agregar(aux);
			conjuntoAuxiliar.Agregar(aux);
			conjuntoProductos.Sacar(aux.getId());
		}
		
		while (!conjuntoAuxiliar.ConjuntoVacio()) {
			Producto aux = conjuntoAuxiliar.Elegir();
			conjuntoProductos.Agregar(aux);
			conjuntoAuxiliar.Sacar(aux.getId());
		}
		
		return copia;
	}
	
	private ConjuntoPedidosTDA copiarConjuntoPedidos(ConjuntoPedidosTDA conjuntoPedidos) {
		ConjuntoPedidosTDA copia = new ConjuntoPedidos();
		copia.InicializarConjunto();
		
		ConjuntoPedidosTDA conjuntoAuxiliar = new ConjuntoPedidos();
		conjuntoAuxiliar.InicializarConjunto();
		
		while (!conjuntoPedidos.ConjuntoVacio()) {
			Pedido aux = conjuntoPedidos.Elegir();
			copia.Agregar(aux);
			conjuntoAuxiliar.Agregar(aux);
			conjuntoPedidos.Sacar(aux.getId());
		}
		
		while (!conjuntoAuxiliar.ConjuntoVacio()) {
			Pedido aux = conjuntoAuxiliar.Elegir();
			conjuntoPedidos.Agregar(aux);
			conjuntoAuxiliar.Sacar(aux.getId());
		}
		
		return copia;
	}
}
