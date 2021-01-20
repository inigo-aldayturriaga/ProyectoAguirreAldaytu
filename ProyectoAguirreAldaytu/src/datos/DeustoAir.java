package datos;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bd.BaseDeDatos;

public class DeustoAir {
	/**
	 * Clase Contenedora
	 */
	public static Connection con = BaseDeDatos.inicializarBD("deustoAirport.db");
	public DeustoAir() {
		/**
		 * Creacion de tablas
		 */
		BaseDeDatos.con = BaseDeDatos.inicializarBD("deustoAirport.db");
		BaseDeDatos.reiniciarBDVuelo(BaseDeDatos.con);
		BaseDeDatos.crearTablasBD(BaseDeDatos.con);
		BaseDeDatos.crearTablaVueloBD(BaseDeDatos.con);
		BaseDeDatos.crearTablaTripulacionBD(BaseDeDatos.con);
		
		/**
		 * Creamos algunos vuelos
		 */
		
		ArrayList<Pasajero> al1 = new ArrayList<Pasajero>();
		Pasajero p1 = new Pasajero("Iñigo", "Aldayturriaga", 19, "125442523N");
		al1.add(p1); 
	    Date d1 = new Date(System.currentTimeMillis()+3600005);
	    Date d2 = new Date(System.currentTimeMillis()+3600000);
	    
		Vuelo v1 = new Vuelo("ALX162", "Bilbao", "Madrid", d1,d2,al1,null, "Llamada", 2);
		Vuelo v2 = new Vuelo("BLX162", "Bilbao", "Madrid", d1,d2,al1,null, "Llamada", 2);
		Vuelo v3 = new Vuelo("CLX163", "Bilbao", "Estocolmo", d1,d2,al1,null, "Llamada", 2);
		Vuelo v4 = new Vuelo("DLX164", "Bilbao", "Helsinki", d1,d2,al1,null, "Llamada", 2);
		Vuelo v5 = new Vuelo("EX165", "Bilbao", "Oslo", d1,d2,al1,null, "Llamada", 2);
		Vuelo v6 = new Vuelo("FLX166", "Bilbao", "Berlin", d1,d2,al1,null, "Llamada", 2);
		Vuelo v7 = new Vuelo("GLX167", "Bilbao", "Barcelona", d1,d2,al1,null, "Llamada", 2);
		BaseDeDatos.insertarVuelo(v1);
		BaseDeDatos.insertarVuelo(v2);
		BaseDeDatos.insertarVuelo(v3);
		BaseDeDatos.insertarVuelo(v4);
		BaseDeDatos.insertarVuelo(v5);
		BaseDeDatos.insertarVuelo(v6);
		
		
	}
	public static ArrayList<Vuelo> getVuelos() {
		ArrayList<Vuelo> vuelos = BaseDeDatos.obtenerArrayDeVuelos();
		return vuelos;
	}
	public static ArrayList<Tripulacion> getTripulacion() {
		ArrayList<Tripulacion> tripulacion = BaseDeDatos.obtenerArrayDeTripulacion();
		return tripulacion;
	}

}
