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

}
