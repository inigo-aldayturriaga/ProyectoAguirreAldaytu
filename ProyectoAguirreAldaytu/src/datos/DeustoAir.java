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
	static ArrayList<Pasajero> pasajeros;
	public static Connection con = BaseDeDatos.inicializarBD("deustoAirport.db");
	public DeustoAir() {
		/**
		 * Creacion de tablas
		 */
		BaseDeDatos.con = BaseDeDatos.inicializarBD("deustoAirport.db");
		BaseDeDatos.crearTablaPasajeroBD(BaseDeDatos.con);
		BaseDeDatos.crearTablaVueloBD(BaseDeDatos.con);
		BaseDeDatos.crearTablaPilotoBD(BaseDeDatos.con);
		BaseDeDatos.crearTablaAzafataBD(BaseDeDatos.con);
		
		/**
		 * Creamos algunos vuelos
		 */
		
		Pasajero p1 = new Pasajero("Iñigo", "Aldayturriaga", 19, "125442523N",54234,ClasePasajero.ECONOMICA,"1234");
		Pasajero p2 = new Pasajero("Lander", "Aguirre", 19, "125442523N",54234,ClasePasajero.ECONOMICA,"1234");
		Pasajero p3 = new Pasajero("Juan", "Lopez", 19, "125442523X",54234,ClasePasajero.ECONOMICA,"1234");
		Pasajero p4 = new Pasajero("Iñigo", "Martinez", 19, "125442523Z",54234,ClasePasajero.ECONOMICA,"1234");
		BaseDeDatos.insertarPasajero(p1);
		BaseDeDatos.insertarPasajero(p2);
		BaseDeDatos.insertarPasajero(p3);
		BaseDeDatos.insertarPasajero(p4);
		
	    Date d1 = new Date(1611152103);
	    Date d2 = new Date(16111521);
	    
		Vuelo v1 = new Vuelo("ALX162", "Bilbao", "Madrid", d1,d2,null,null, "Llamada", 2);
		Vuelo v2 = new Vuelo("BLX162", "Bilbao", "Madrid", d1,d2,null,null, "Llamada", 3);
		Vuelo v3 = new Vuelo("CLX163", "Bilbao", "Estocolmo", d1,d2,null,null, "Última Llamada", 4);
		Vuelo v4 = new Vuelo("DLX164", "Bilbao", "Helsinki", d1,d2,null,null, "Última Llamada", 5);
		Vuelo v5 = new Vuelo("EX165", "Bilbao", "Oslo", d1,d2,null,null, "Retrasado", 6);
		Vuelo v6 = new Vuelo("FLX166", "Bilbao", "Berlin", d1,d2,null,null, "Llamada", 7);
		Vuelo v7 = new Vuelo("GLX167", "Bilbao", "Barcelona", d1,d2,null,null, "Última Llamada", 8);
		BaseDeDatos.insertarVuelo(v1);
		BaseDeDatos.insertarVuelo(v2);
		BaseDeDatos.insertarVuelo(v3);
		BaseDeDatos.insertarVuelo(v4);
		BaseDeDatos.insertarVuelo(v5);
		BaseDeDatos.insertarVuelo(v6);
		
		Piloto t1 = new Piloto("Lander", "Aguirre", 25, "79442144N",22,224,"Espanya",TipoPiloto.COMERCIAL);
		Piloto t2 = new Piloto("Iñigo", "Aldayturriaga", 22, "79442144X",22,224,"Brasil",TipoPiloto.COMERCIAL);
		Piloto t3 = new Piloto("Luigi", "Lopez", 46, "79442144J",22,224,"Portugal",TipoPiloto.COMERCIAL);
		Azafata a = new Azafata("Carlos", "Campo", 54, "625463643J", 34, 345, "Lituania", 156, 93);
		BaseDeDatos.insertarPiloto(t1);
		BaseDeDatos.insertarPiloto(t2);
		BaseDeDatos.insertarPiloto(t3);
		BaseDeDatos.insertarAzafata(a);
		
	}
	public static ArrayList<Vuelo> getVuelos() {
		ArrayList<Vuelo> vuelos = BaseDeDatos.obtenerArrayDeVuelos();
		return vuelos;
	}
	public static ArrayList<Tripulacion> getTripulacion() {
		ArrayList<Tripulacion> tripulacion = BaseDeDatos.obtenerArrayDeTripulacion();
		return tripulacion;
	}
	public static ArrayList<Pasajero> getPasajeros() {
		pasajeros = BaseDeDatos.obtenerArrayDePasajeros();
		return pasajeros;
	}
	public static void anyadePasajero(Pasajero p) {
		pasajeros.add(p);
		
	}

}
