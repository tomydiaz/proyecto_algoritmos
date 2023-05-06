package proyecto_algoritmos;

import java.time.LocalDateTime;

import tdas.ConjuntoProductosCantidadTDA;

public class Pedido {
	static int generador = 1;
	
	public Pedido(String nombreCliente, LocalDateTime fechaHora, ConjuntoProductosCantidadTDA productosCantidad, String direccion) {
		// TODO Auto-generated constructor stub
		this.id = generador++;
		this.nombreCliente = nombreCliente;
		this.fechaHora = fechaHora;
		this.productosCantidad = productosCantidad;
		this.direccion = direccion;
		this.estado = "Pendiente";
	}
	
	private int id;
	private String nombreCliente;
	private LocalDateTime fechaHora; // LocalDateTime.now fechaHora = LocalDateTime.now()
	private ConjuntoProductosCantidadTDA productosCantidad;
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
	
	public ConjuntoProductosCantidadTDA getProductosCantidad() {
		return productosCantidad;
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
