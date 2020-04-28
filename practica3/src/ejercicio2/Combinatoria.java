package ejercicio2;

public class Combinatoria {

	public static int combR(int m, int n) {
		if((n < 0) || (m < 0)) {
			return 0;
		} else {
			if((n == 0) || (n == m)) {
				return  1;
			} else { 
				return combR(m - 1, n) + combR(m - 1 ,n - 1);
			}
		}
	}
	
	static int[][] comb = new int [100][100];
	
	public static void tablaComb(int n){		
		for (int i = 0; i <= n; i++) {
			comb[i][0]  = 1;
			comb[i][i]  = 1;
			for(int k = 1;  k < i ; k++){
				comb[i][k] = comb[i-1][k]  + comb[i-1][k-1];
			}
		}
	}
	
	public static void print(int n) {
		for(int i = 0; i<=n; i++) {
			for(int j = 0; j<=n; j++) {
				System.out.print(comb[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("combinatora de comb(4,3) = " + combR(4,3));
		tablaComb(25);
		System.out.println("combinatora de tablaComb(25,4) = " + comb[25][4]);
		print(25);
	}

}
