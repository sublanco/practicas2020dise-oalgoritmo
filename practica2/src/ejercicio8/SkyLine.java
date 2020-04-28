package ejercicio8;

import java.util.Arrays;

public class SkyLine {
		
	public static Point[] toSkyLine(Building[] b, int l , int h) {
		if(l==h) {
			Point[] sk = new Point[2];
			sk[0] = new Point(b[l].left,b[l].height);
			sk[1] = new Point(b[l].right,0);
			return sk;
		}
		
		int mid = (l + h) / 2; 
		
		Point[] sl = toSkyLine(b, l, mid); 
		Point[] sr = toSkyLine(b, mid + 1, h); 
		return mergeSkyLine(sl,sr);
	}
	
	public static Point[] mergeSkyLine(Point[] sl, Point[] sr){ 
		
		int nsl = sl.length;
		int nsr = sr.length;
		
		Point[] sk = new Point[nsl + nsr]; 

		// Cargar las alturas de los dos point actuales  
		int h1 = 0, h2 = 0; 

		// Indices de los skylines sl, sr y sk.
		int i = 0, j = 0, k=0;
		while (i < nsl && j < nsr) { 
			if (sl[i].x < sr[j].x) { 
				int x1 = sl[i].x; 
				h1 = sl[i].h; 

				// Elige la mayor de las dos alturas
				int maxh = Math.max(h1, h2); 
				
				// chequeo de redundancia misma altura o misma x
				if (k > 0 && sk[k - 1].h == maxh) {					
				}
				else if (k > 0 && sk[k - 1].x == sl[i].x) { 
					sk[k - 1].h = Math.max(sk[k - 1].h, maxh); 
				}
				else { 
					sk[k] = new Point(x1, maxh); 
					k++;
				}
				i++; 
			} 
			else { 
				int x2 = sr[j].x; 
				h2 = sr[j].h; 
				int maxh = Math.max(h1, h2); 
				
				// chequeo de redundancia misma altura o misma x
				if (k > 0 && sk[k - 1].h == maxh) {					
				}
				else if (k > 0 && sk[k - 1].x == sr[j].x) { 
					sk[k - 1].h = Math.max(sk[k - 1].h, maxh); 
				}
				else { 
					sk[k] = new Point(x2, maxh); 
					k++;
				} 
				j++; 
				
			} 
		} 
		while (i < nsl) { 
			sk[k] = sl[i]; 
			i++; 
			k++;
		} 
		while (j < nsr) { 
			sk[k] = sr[j]; 
			j++; 
			k++;
		} 
		sk = Arrays.copyOfRange(sk, 0, k);
		return sk; 
	} 
	
	
	public static void print(Point[] skl) {
		int n = skl.length;
		for(int i=0; i<n; i++) {
			skl[i].print();
		}
		System.out.println();
	}
	
	public static void print(Building[] bld) {
		int n = bld.length;
		for(int i=0; i<n; i++) {
			bld[i].print();
		}
		System.out.println();
	}	
	
	public static void main(String args[]) {
		Building[] b = new Building[8];
		b[0] = new Building(1, 11, 5);		
		b[1] = new Building(2, 6, 7);
		b[2] = new Building(3, 13, 9);
		b[3] = new Building(12, 7, 16);
		b[4] = new Building(14, 3, 25);
		b[5] = new Building(19, 18, 22);
		b[6] = new Building(23, 13, 29);
		b[7] = new Building(24, 4, 28);
		
		
		print(b);
		
		Point[] skl = toSkyLine(b,0,b.length-1);
		
		print(skl);
	}

}
