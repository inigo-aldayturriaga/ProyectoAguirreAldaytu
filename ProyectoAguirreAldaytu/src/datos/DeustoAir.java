package datos;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bd.BaseDeDatos;

public class DeustoAir {
	/*
	 * Clase Contenedora
	 */
	
	public DeustoAir() {
		BaseDeDatos.con = BaseDeDatos.inicializarBD("deustoAirport.db");
		BaseDeDatos.crearTablasBD(BaseDeDatos.con);
		BaseDeDatos.reiniciarBDVuelo(BaseDeDatos.con);
		BaseDeDatos.usarCrearTablasBD(BaseDeDatos.con);
		ArrayList<Persona> al1 = new ArrayList<Persona>();
		Persona p1 = new Pasajero();
		al1.add(p1);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:mm aaa"); // El formato de fecha está especificado 
	    Date d1 = new Date(55432524);
	    Date d2 = new Date(5423542);
		Vuelo v1 = new Vuelo("XLX162", "Bilbao", "Madrid", d1,d2,al1, "Llamada", 2);
		BaseDeDatos.insertarVuelo(v1);
		ArrayList<Vuelo> al = BaseDeDatos.obtenerArrayDeVuelos();
		for (Vuelo v : al) {
			System.out.println(v.toString());
		}
		
	}

}
