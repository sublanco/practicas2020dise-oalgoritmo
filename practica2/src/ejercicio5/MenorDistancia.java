package ejercicio5;

import java.util.Arrays;

/*
 * Ejercico 5 de la practica 2
 * Menor distancia entre dos puntos de un conjunto de puntos del plano.
 */
public class MenorDistancia {
	
	// menor distancia entre dos pares de puntos por fuerza bruta.
	public static Punto[] menorDistanciaFB(Punto[] a) {
		int n = a.length;
		if(n == 1) {
			return null;
		}
		else if (n == 2) {
			return a;
		}
		else {
			double d = Double.MAX_VALUE;
			Punto[] par = new Punto[2];
			for(int i=0; i<n-1; i++) {
				Punto p1 = a[i];
				for(int j=i+1; j<n; j++) {
					Punto p2 = a[j];
					double c = p1.distancia(p2);
					if(c < d) {
						par[0] = p1;
						par[1] = p2;
						d = c;
					}
				}
			}
			return par;
		}
	}
	
	
	// menor distancia entre dos pares de puntos por divide y venceras.
	public static Punto[] menorDistanciaDV(Punto[] a) {
		int n = a.length;
		// Caso base
		if(n == 1) {
			return null;
		}
		else if (n == 2) {
			if(a[0].x > a[1].x) {
				Punto aux = a[0];
				a[0] = a[1];
				a[1] = aux;
			}
			return a;
		}
		//Dividir
		else {
			int mitad = n/2;
			Punto[] l = Arrays.copyOfRange(a, 0, mitad);
			Punto[] r = Arrays.copyOfRange(a, mitad,n);
			Punto[] m =  min(menorDistanciaDV(l), menorDistanciaDV(r));
			Double d = Double.MAX_VALUE;
			if(m != null) {
				d = m[0].distancia(m[1]);
			}
			return min(m,menorDistanciaCruce(l,r,a,d));
		}
	}
	
	private static Punto[] min(Punto[] a, Punto[] b) {
		if((a != null)&&(b != null)) {
			if(a[0].distancia(a[1]) < b[0].distancia(b[1])) {
				return a;
			}
			else {
				return b;
			}
		}
		else if(a != null) {
			return a;
		}
		else {
			return b;
		}
	}

	private static Punto[] menorDistanciaCruce(Punto[] l, Punto[] r, Punto[] a, double d) {
		//ordenar por x
		int nl = l.length;
		int nr = r.length;
		int i = 0;
		int j = 0;
		int k = 0;
		
		while((i<nl)&&(j<nr)) {
			if(l[i].x < r[j].x) {
				a[k] = l[i];
				i++;				
			}
			else {
				a[k] = r[j];
				j++;				
			}			
			k++;
		}
		
		while(i<nl) {
			a[k] = l[i];
			i++;
			k++;
		}
		
		while(j<nr) {
			a[k] = r[j];
			j++;
			k++;
		}
		
		
		int n = a.length;
		double m = a[n/2].x;
		int tmin = n/2;
		int tmax = n/2;
		
		//buscar del centro al minimo
		while((tmin>=0)&&(m-a[tmin].x < d)) {
			tmin--;
		}
		//buscar del centro al maximo
		while((tmax<n)&&(a[tmax].x-m < d)) {
			tmax++;
		}
		
		Punto[] p = null;
		// compara cada punto con coordenada y menor que d
        for (int s = tmin+1; s < tmax-1; s++) {
            for (int t = s+1; (t < tmax) && (a[t].y - a[s].y < d); t++) {
                double distancia = a[t].distancia(a[s]);
                if (distancia < d) {
                    d = distancia;
                    p = new Punto[2];
                    p[0] = a[s];
                    p[1] = a[t];
                }
            }
        }
        return p;
	}


	// imprime los puntos de un arreglo de puntos.
	public static void print(Punto[] a) {
		if(a != null) {
			int n = a.length;
			for(int i=0; i<n; i++) {
				a[i].print();
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		
		Punto[] a = { new Punto(9,15), new Punto(2,13),new Punto(9,12), new Punto(6,13),new Punto(9,5), new Punto(2,3),new Punto(9,2), new Punto(6,3), new Punto(5,7), new Punto(8,13),new Punto(16,2), new Punto(52,1),new Punto(18,0), new Punto(2,8),new Punto(9,4), new Punto(6,9), new Punto(5,12), new Punto(8,23),new Punto(6,22), new Punto(25,11)};
		print(a);
		
		Punto[] par = menorDistanciaFB(a);
		double d = par[0].distancia(par[1]);
		
		System.out.println("Menor distancia Fuerza Bruta: ");
		
		print(par);
		System.out.println("d = "+d);

		par = menorDistanciaDV(a);
		d = par[0].distancia(par[1]);
		System.out.println("Menor distancia Divide y Venceras:  ");
		print(par);
		System.out.println("d = "+d);
		print(a);
	}

}
