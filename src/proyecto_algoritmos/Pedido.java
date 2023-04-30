package proyecto_algoritmos;

import java.time.LocalDateTime;

import tdas.ConjuntoTDA;

//Cada pedido debe incluir la siguiente información:
// Identificador único del pedido. - LISTO
// Nombre del cliente. - LISTO
// Fecha y hora del pedido. - LISTO
// Lista de productos solicitados. - LISTO
// Dirección de entrega. - LISTO
// Estado. - LISTO

public class Pedido {
	public Pedido(int id, String nombreCliente, LocalDateTime fechaHora, ConjuntoTDA productos, String direccion, String estado) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nombreCliente = nombreCliente;
		this.fechaHora = fechaHora;
		this.productos = productos;
		this.direccion = direccion;
		this.estado = estado;
	}
	
	private int id;
	private String nombreCliente;
	private LocalDateTime fechaHora; // LocalDateTime.now fechaHora = LocalDateTime.now()
	private ConjuntoTDA productos;
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
	
	public ConjuntoTDA getProductos() {
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
