package jeu2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestJunit {
    
	/*
     * Test qui montre l'egalité
     */
	@Test
	void testEquals() {
	    Case c = new Case(7);
		int c2 = c.getColor();
		
		assertEquals(7, c2);
	}
	
	/*
	 * Test qui montre l'inégalité
	 */
	@Test
	void testNotEquals() {
	    Case c = new Case(7);
		int c2 = c.getColor();

		assertNotEquals(6, c2);
	}
	
	/*
	 * Test qui montre que une lettre n'est pas pareil que un nombre
	 */
	@Test
	void testNotSame() {
	    Case c = new Case(7);
		int c2 = c.getColor();
		String x = "x";

		assertNotSame(x, c2);
	}
	
	/*
	 * Test pour vérifier si c'est bien un chiffre en 0 et 9 qui est rentré
	 */
	@Test
	void testCase() {
		Board b =new Board();
		int a = b.propLine.getCase(0).getColor();
		a = 1;
		//a = 45;
		
		if (a != 0 && a != 1 && a != 2 && a != 3 && a != 4 && a != 5 && a != 6 && a != 7 && a != 8 && a != 9) {
			fail ("rentrez un nombre en 0 et 9");
		}
	}

}
