package proyecto_algoritmos;

public class ProductoCantidad {
		public ProductoCantidad(Producto producto, int cantidad) {
			// TODO Auto-generated constructor stub
			this.id = producto.getId();
			this.producto = producto;
			this.cantidad = cantidad;
		}
		
		private int id;
		private Producto producto;
		private int cantidad;
		
		public int getId() {
		 	return id;
		}
		
		public Producto getProducto() {
		 	return producto;
		}
		
		public int getCantidad() {
		 	return cantidad;
		}
}
