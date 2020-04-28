package ejercicio3;

public class Fibonacci {
	
	public static int fib(int n) {
		if(n == 0) {
			return 1;
		} else if(n == 1) {
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}
	
	public static int fibD(int n) {
		int[] fib = new int[n + 1];
		fib[0] = 1;
		fib[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		
		return fib[n];
	}
	
	public static int fibM(int n) {
		int a = 1;
		int b = 1;
		int r = 1;
		for (int i = 2; i <= n; i++) {
			r = a + b;
			b = a;
			a = r;
		}		
		return r;
	}

	public static void main(String[] args) {
		
		int x = 25;
		System.out.println("fib  = " + fib(x));
		System.out.println("fibD = " + fibD(x));
		System.out.println("fibM = " + fibM(x));

	}

}
