package datos;

import static org.junit.Assert.assertEquals;
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
		Pasajero p = new Pasajero("Iñigo", "Martinez", 19, "125442523Z",54234,ClasePasajero.ECONOMICA,"1234");
		Piloto p1 = new Piloto("Lander", "Aguirre", 25, "79442144N",22,224,"Espanya",TipoPiloto.COMERCIAL);
		listaPasajeros.add(p);
		listaPasajeros.add(p);
		listaPasajeros.add(p);
		listaPasajeros.add(p);
		assertTrue(listaPasajeros.size()==4);
		assertEquals(TipoPiloto.COMERCIAL,p1.getTipo());
		assertEquals(ClasePasajero.ECONOMICA, p.getClase());
		
		
	}

}
