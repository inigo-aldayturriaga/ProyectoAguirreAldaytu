package datos;

import java.sql.Date;
import java.text.SimpleDateFormat;

import bd.BaseDeDatos;

public class DeustoAir {
	/*
	 * Clase Contenedora
	 */
	
	public DeustoAir() {
		Persona p1 = new Pasajero();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:mm aaa"); // El formato de fecha está especificado 
	    Date d1 = (Date) new java.util.Date(2021,1,18,16,36);
	    Date d2 = (Date) new java.util.Date(2021,1,18,18,36);
		Vuelo v1 = new Vuelo("XLX162", "Bilbao", "Madrid", d1,d2,null, "Llamada", 2);
		BaseDeDatos.con = BaseDeDatos.inicializarBD("deustoAirport.db");
		BaseDeDatos.insertarVuelo(v1);
		BaseDeDatos.cerrarBD(BaseDeDatos.con, BaseDeDatos.st);
		
	}

}
