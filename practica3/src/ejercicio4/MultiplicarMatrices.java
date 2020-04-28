package ejercicio4;

import java.util.ArrayList;

public class MultiplicarMatrices {
	
	public static ArrayList<Matriz> multiplicar(ArrayList<Matriz> a) {
		if(a == null) {
			throw new IllegalArgumentException("vector de matriz = null ");
		} else {
			int n = a.size();
			if( n == 1 ) {
				return a;
			} else if (n == 2){
				Matriz x = a.get(0);
				Matriz y = a.get(1);
				a.remove(x);
				a.remove(y);
				Matriz m = x.multiplicar(y);
				a.add(m);
				return multiplicar(a);
			} else {
				Matriz x = a.get(0);
				Matriz y = a.get(1);				
				if(x.filas < y.filas) {
					Matriz m = x.multiplicar(y);
					a.remove(x);
					a.remove(y);
					a.add(0, m);;
				} else {
					System.out.println("cambio");
					Matriz z = a.get(2);
					a.remove(y);
					a.remove(z);
					Matriz m = y.multiplicar(z);
					a.add(1,m);
				}				
				return multiplicar(a);
			}
		}
	}

	public static void main(String[] args) {
		
		int [] [] a = {{1,2,4}, {5,6,7}};
		Matriz m = new Matriz(a);
		m.print();
		
		int [] [] b = {{1,2}, {3,4}, {5,6}};
		Matriz n = new Matriz(b);
		n.print();
		
		int [] [] c = {{5,2}, {3,4}};
		Matriz p = new Matriz(c);
		p.print();
		
		ArrayList<Matriz> l = new ArrayList<Matriz>();
		l.add(m);
		l.add(n);
		l.add(p);
		Matriz r = multiplicar(l).get(0);
		System.out.println(r.count);
		r.print();
		r.count = 0;
		r = m.multiplicar(n.multiplicar(p));
		System.out.println(r.count);
		r.print();
	}

}
