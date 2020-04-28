package ejercicio5;

public class Punto {
	
	public double x;
	public double y;
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distancia(Punto p) {
		return Math.sqrt(Math.pow((p.x-x),2)+Math.pow((p.y-y),2));
	}
	
	public void print() {
		String strx = String.format("%.0f", x); 
		String stry = String.format("%.0f", y);
		System.out.print("("+strx+" , "+stry+") ");
	}
}
