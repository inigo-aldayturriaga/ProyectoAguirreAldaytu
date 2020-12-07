package datos;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;


public class MyJUnit {

	@Test
	public void test() {
		ArrayList<Pasajero> listaPasajeros = new ArrayList<Pasajero>();
		Pasajero p = new Pasajero();
		listaPasajeros.add(p);
		listaPasajeros.add(p);
		listaPasajeros.add(p);
		listaPasajeros.add(p);
		assertTrue(listaPasajeros.size()==4);
	}

}
