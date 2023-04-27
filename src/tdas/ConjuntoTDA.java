package tdas;

public interface ConjuntoTDA {
	void InicializarConjunto();
	int Elegir();
	void Sacar(int x);
	void Agregar(int x);
	boolean Pertenece(int x);
	boolean ConjuntoVacio();

}
