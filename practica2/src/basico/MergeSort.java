package basico;

import java.util.Arrays;

public class MergeSort {
	
	public static int[] sort(int [] a){
		int n = a.length;
		// 1. caso base un arreglo que tiene 1 elemento o nimguno esta ordenado
		// entonces se devuelve el mismo arreglo.
		if(n<=1) {
			return a;
		}
		// 2. se divide el arreglo en dos mitades l(0..n/2) y r(n/2...n)
		else {
			int mitad = n/2;
			int [] l = Arrays.copyOfRange(a, 0, mitad);
			int [] r = Arrays.copyOfRange(a, mitad, n);
		// 3. se mezcla los dos arreglos ordenados sort(l) y sort(r)
			return merge(sort(l),sort(r));
		}
	}
	
	// mezcla de dos arreglos ordenados
	public static int[] merge(int[] l, int[] r) {
		int nl = l.length;
		int nr = r.length;
		int[] m = new int[nl+nr];
		int i = 0;
		int j = 0;
		int k = 0;
		while((i<nl)&&(j<nr)) {
			if(l[i]<r[j]) {
				m[k]=l[i];
				i++;
			}
			else {
				m[k]=r[j];
				j++;
			}			
			k++;
		}
		if(i<nl) {
			while(i<nl) {
				m[k] = l[i];
				i++;
				k++;
			}
		}
		else if(j<nr){
			while(j<nr) {
				m[k] = r[j];
				j++;
				k++;
			}
		}
		return m;
	}
	
	public static void print(int[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = {8, 3, 6 ,0 ,1 ,5,2,7,4};
		print(a);
		print(sort(a));
	}

}
