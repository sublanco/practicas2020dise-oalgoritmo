package ejercicio1;

import java.util.Arrays;

public class Inversiones {
	
	// calculo de inversiones por fuerza bruta
	public static int inversionesFB(int[] a) {
		int n = a.length;
		int cont = 0;
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(a[i]>a[j]) {
					cont++;
				}
			}
		}
		
		return cont;
	}
	
	// calculo de inversiones por divide y venceras
	// se basa en el mergesort
	public static int inversionesDV(int[] a) {
		int n = a.length;
		if(n<=1) {
			return 0;
		}
		else {
			int mitad = n/2;
			int[] left = Arrays.copyOfRange(a, 0, mitad);
			int[] right = Arrays.copyOfRange(a, mitad,n);
			int i = inversionesDV(left)+inversionesDV(right)+calcDV(left,right, a);
			return i;
		}
	}
	
	public static int calcDV(int[] l, int[] r, int[] m) {
		
		int nl = l.length;
		int nr = r.length;
		int i = 0;
		int j = 0;
		int k = 0;
		int count = 0;
		
		while((i<nl)&&(j<nr)) {
			// no hay inversion entonces pego l[i] directamente.
			if(l[i]<r[j]) {
				m[k]=l[i];
				i++;
			}
			//hay inversiones son nl-i aumento entonces el contador esa cantidad y pego r[j]
			else {
				m[k]=r[j];
				j++;
				count += nl-i; 
			}			
			k++;
		}
		
		//pego el resto de l
		while(i<nl) {
			m[k] = l[i];
			i++;
			k++;
		}
		
		//o pego el resto de r
		while(j<nr) {
			m[k] = r[j];
			j++;
			k++;
		}
		return count;
	}
	
	public static void print(int[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = {8,2,3,4,1,5};
		
		print(a);
		
		System.out.println("Calculo Inversiones por Fuerza Bruta: "+inversionesFB(a));
		System.out.println("Calculo Inversiones por Divide y Venceras: "+inversionesDV(a));
		
		print(a);
	}

}
