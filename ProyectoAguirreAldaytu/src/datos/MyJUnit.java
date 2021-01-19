package datos;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;


public class MyJUnit {

	@Test
	public void test() {
		/**
		 * Comprobacion de que se añaden bien los objetos a un arraylist
		 */
		ArrayList<Pasajero> listaPasajeros = new ArrayList<Pasajero>();
		Pasajero p = new Pasajero("Iñigo", "Aldayturriaga", 19, "125442523N");
		listaPasajeros.add(p);
		listaPasajeros.add(p);
		listaPasajeros.add(p);
		listaPasajeros.add(p);
		assertTrue(listaPasajeros.size()==4);
		
		
	}

}
