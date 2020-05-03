package ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class sala101test {

	@Test
	void test() {
		 LinkedList<Clase> materias = new  LinkedList<Clase>();
		 Clase c1 = new Clase("algoritmos", 9, 12);
		 Clase c2 = new Clase("analisis", 11, 15);
		 Clase c3 = new Clase("algoritmos 2", 13, 16);
		 Clase c4 = new Clase("ingenieria", 6, 8);
		 materias.add(c1);
		 materias.add(c2);
		 materias.add(c3);
		 materias.add(c4);
		 LinkedList<Clase> compatibles = Sala101.compatibles(materias);
		 assertTrue(compatibles.contains(c4));
		 assertTrue(compatibles.contains(c1));
		 assertTrue(compatibles.contains(c3));
		 
	}

}
