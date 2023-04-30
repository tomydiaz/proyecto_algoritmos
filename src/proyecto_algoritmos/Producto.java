package proyecto_algoritmos;

public class Producto {
	public Producto(int id, String nombre, int stock) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nombre = nombre;
		this.stock = stock;
	}
	
	private int id;
	private String nombre;
	private int stock;
	
	public int getId() {
	 	return id;
	}
	
	public String getNombre() {
	 	return nombre;
	}
	
	public int getStock() {
	 	return stock;
	}
	
	public void actualizarStock() {
		stock--;
	}
}
