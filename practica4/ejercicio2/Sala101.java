package ejercicio2;

import java.util.LinkedList;

public class Sala101 {
	
	public static LinkedList<Clase> compatibles(LinkedList<Clase> materias){
		print(materias);

		LinkedList<Clase> result = minClas(materias);
		print(result);
		//quito las materias que no son compatibles
		int i = 0;
		while(i < result.size()) {
			Clase ci = result.get(i);
			int j = i + 1;
			while(j < result.size()) {
				Clase cj = result.get(j);
				if(! ci.compatible(cj)) {
					result.remove(cj);
				}else {
					break;
			    }
		  }
			i++;
	   }
		print(result);
		return result;
}
		
		
		private static LinkedList<Clase> minClas(LinkedList<Clase> materias){
		LinkedList<Clase >result = new  LinkedList<Clase>();
		int i = 0;
	    while(materias.size() > 0) {	
	    	Clase m = materias.get(0);
	    	int j = 0;
	    	while(j < materias.size()) {
	    		Clase mi = materias.get(j);
	    		if(mi.inicio < m.inicio){
	    			m = mi;
		        }
		        j++;
	         }
	   materias.remove(m);
	   result.add(i, m);
	   i++;
	  }
	return result;
}
	private static void print(LinkedList<Clase> materias) {
		int n = materias.size();
		for(int i = 0; i < n; i++) {
			System.out.println(materias.get(i).nombre + "");
		}
		System.out.println();
	}	
}
