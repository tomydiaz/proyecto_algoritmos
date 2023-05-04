package proyecto_algoritmos;

import java.time.LocalDateTime;

import tdas.ConjuntoProductosTDA;

//Cada pedido debe incluir la siguiente información:
// Identificador único del pedido. - LISTO
// Nombre del cliente. - LISTO
// Fecha y hora del pedido. - LISTO
// Lista de productos solicitados. - LISTO
// Dirección de entrega. - LISTO
// Estado. - LISTO

public class Pedido {
	static int generador = 1;
	
	public Pedido(String nombreCliente, LocalDateTime fechaHora, ConjuntoProductosTDA productos, String direccion) {
		// TODO Auto-generated constructor stub
		this.id = generador++;
		this.nombreCliente = nombreCliente;
		this.fechaHora = fechaHora;
		this.productos = productos;
		this.direccion = direccion;
		this.estado = "Pendiente";
	}
	
	private int id;
	private String nombreCliente;
	private LocalDateTime fechaHora; // LocalDateTime.now fechaHora = LocalDateTime.now()
	private ConjuntoProductosTDA productos;
	private String direccion;
	private String estado;
	
	public int getId() {
		return id;
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public LocalDateTime getFechaHora() {
		return  fechaHora;
	}
	
	public ConjuntoProductosTDA getProductos() {
		return productos;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getEstado() {
		return estado;
	}
	
	// Actualizar el estado de los pedidos al momento de cambiar el estado (al momento de cambiarlo de lista).
	public void actualizarEstado(String estado) {
		this.estado = estado;
	}
}
