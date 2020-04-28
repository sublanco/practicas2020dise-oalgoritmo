package ejercicio4;

public class Matriz {
	
	public int filas;
	public int columnas;
	public int[][] a;
	public static int count = 0;
	
	public Matriz(int f, int c) {
		this.filas = f;
		this.columnas = c;
		this.a = new int [filas][columnas];
	}
	
	public Matriz( int[][] b) {
		this.filas = b.length;
		this.columnas = b[0].length;
		this.a = b;
	}
	
	public boolean compatible(Matriz b) {
		return (this.columnas == b.filas);
	}
	
	public int get(int i, int j) {
		return a[i][j];
	}
	
	public void set(int i, int j, int x) {
		a[i][j] = x;
	}
	
	public Matriz ordenMult(Matriz b) {
		return new Matriz(this.filas, b.columnas);
	}
	
	public Matriz multiplicar(Matriz b) {
		if(b == null) {
			throw new IllegalArgumentException(" otra matriz = null ");
		} else if (!compatible(b)){
			throw new IllegalArgumentException(" las matrices no son compatibles ");		
		} else {
			int n = this.filas;
			int m = b.columnas;
			int s = this.columnas;
			Matriz c = new Matriz(n, m);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int r = 0;
					for (int k = 0; k < s; k++) {
						r +=  a[i][k] * b.get(k, j);
						count++;
					}
					c.set(i, j, r);
				}
			}
			return c;
		}
	}
	
	public void print() {
		int n = this.filas;
		int m = this.columnas;
		for(int i = 0; i < n; i++) {
			System.out.print("| ");
			for(int j = 0; j < m; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println("|");
		}
		System.out.println();
	}

}
