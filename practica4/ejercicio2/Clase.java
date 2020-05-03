package ejercicio2;

public class Clase {
	//horarios de inicio y fin
	//rango de 0 a 24
	int inicio;
	int fin;
	
	//nombre de la clase
	String nombre;
	
	public Clase(String n, int i, int f) {
		this.nombre = n;
		this.inicio = i;
		this.fin = f;
	}
	public boolean compatible(Clase otra) {
		return(this.fin <= otra.inicio);
			
	}

}
