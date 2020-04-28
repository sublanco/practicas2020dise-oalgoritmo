package ejercicio9;

public class Multiplicar {
	
	// multiplicacion de primario
	public static int multiplicarFB(int a, int b) {
		int m = a;
		int r = 0;
		int s = 1;
		while(m > 9) {
			int d = digito(m);
			m = despalazarDer(m);
			r += d*b*s;
			s = desplazarIzq(s);
		}
		r += m*b*s;
		return r;
	}
	
	public static int digito(int m) {
		int d = m % 10;
		return d;
	}
	
	public static int despalazarDer(int m) {
		m = m/10;
		return m;
	}
	
	public static int desplazarIzq(int s) {
		s *= 10;
		return s;
	}
	
	//algoritmo de karatsuba para la multiplicación rápida usando el algoritmo Divide and Conquer
	public static int multiplicarDV(int a, int b) {
		return 0;
	}
	
	public static void main(String[] args) {
		
		System.out.println(multiplicarFB(141, 24));
		
	}

}


