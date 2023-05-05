package proyecto_algoritmos;

import java.time.LocalDateTime;

import dinamicas.ColaPedidos;
import dinamicas.ConjuntoPedidos;
import dinamicas.ConjuntoProductos;
import dinamicas.DiccionarioSimplePedidos;
import dinamicas.PilaPedidos;
import tdas.ColaPedidosTDA;
import tdas.ConjuntoPedidosTDA;
import tdas.ConjuntoProductosTDA;
import tdas.DiccionarioSimplePedidosTDA;
import tdas.PilaPedidosTDA;

public class SistemaPizzeria {
	
	private static ColaPedidosTDA pedidosPendientes = new ColaPedidos(); 
	private static ConjuntoPedidosTDA pedidosEnPreparacion = new ConjuntoPedidos();
	private static PilaPedidosTDA pedidosCompletados = new PilaPedidos(); 
	private static DiccionarioSimplePedidosTDA historialPedidos = new DiccionarioSimplePedidos();
	private static ConjuntoProductosTDA productosDisponibles = new ConjuntoProductos();
	
	public Pedido crearPedido(String nombreCliente, LocalDateTime fechaHora, int[] idsProductos,
			String direccion) {

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

	 
	public static void main(String[] args) {
		
		pedidosPendientes.InicializarCola();
		pedidosEnPreparacion.InicializarConjunto();
		pedidosCompletados.InicializarPila();
		historialPedidos.InicializarDiccionario();
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
	}
}
