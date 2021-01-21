package bd;

import datos.Azafata;
import datos.ClasePasajero;
import datos.Pasajero;
import datos.Persona;
import datos.Piloto;
import datos.Tripulacion;
import datos.Vuelo;

import java.io.ObjectInputStream.GetField;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BaseDeDatos {

	/** Inicializa una BD SQLITE y devuelve una conexión con ella
	 * @param nombreBD	Nombre de fichero de bd
	 * @return	Conexión con la base de datos indicada
	 */
	public static Connection con;
	public static Statement st;
	
	public static Connection inicializarBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
		    return con;
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	
	/** Crea las tablas de la base de datos
	 * @param con	Conexión creada
	 * @return	sentencia de trabajo si se crea correctamente
	 */
	public static Statement crearTablaPasajeroBD( Connection con ) {
		try {
			st = con.createStatement();
			st.executeUpdate("create table Pasajero "+
						   "(nombre string, "+
						   "apellido string, "+
						   "edad int, "+
						   "dni string, "+
						   "numeroBillete int, "+
						   " contrasenia string)");
			return st;
		} catch (SQLException e) {
			return null;
		}
	}
	public static Statement crearTablaVueloBD( Connection con ) {
		try {
			st = con.createStatement();
			st.executeUpdate("create table Vuelo "+
						   "(horaSalida bigint, "+
						   " idAvion string, "+
						   " destino string, "+
						   " horaLLegada bigint, "+
						   " puerta int, "+
						   "observacion string)");
				return st;
		} catch (SQLException e) {
			return null;
		}
	}
	
	public static Statement crearTablaTripulacionBD( Connection con ) {
		try {
			st = con.createStatement();
			st.executeUpdate("create table Tripulacion "+
						   "(tipoTripulacion int, "+
						   "nombre string,"+
						   "apellido string, "+
						   "edad int, "+
						   "dni string,"+
						   "nacionalidad string,"+
						   "anyosExp int, "+
						   "vuelosRealizados int)");
				return st;
		} catch (SQLException e) {
			return null;
		}
	}
	
	/** Reinicia en blanco las tablas de la base de datos. 
	 * @param con	Conexión creada
	 * @return	sentencia de trabajo si se borra correctamente
	 */
	public static Statement reiniciarBDPasajero( Connection con ) {
		try {
			st = con.createStatement();
			st.executeUpdate("drop table if exists Pasajero");
			return crearTablaPasajeroBD( con );
		} catch (SQLException e) {
			return null;
		}
	}
	public static Statement reiniciarBDVuelo( Connection con ) {
		try {
			st = con.createStatement();
			st.executeUpdate("drop table if exists Vuelo");
			return crearTablaVueloBD( con );
		} catch (SQLException e) {
			return null;
		}
	}
	/**
	 * Cierra la base de datos abierta
	 * @param con
	 * @param st
	 */
	public static void cerrarBD( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
		} catch (SQLException e) {
		}
	}
	public static void cerrarCBD(Connection con) {
		try {
			if (con!=null) con.close();
		} catch (SQLException e) {
		}
	}
	/**
	 * COMPROBACIONES CON LA TABLA PERSONA!
	 */
	public static boolean existeUsuario(String nombre) {
		boolean existeUsuario = false;
		String sql = "SELECT nombre FROM Pasajero WHERE nombre ='"+nombre+"'";
		con = inicializarBD("deustoAirport.db");
		try {
			st = con.createStatement(); 
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) {
				existeUsuario = true;
			}
			cerrarBD(con, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existeUsuario;
	}
	
	/**
	 * 
	 * @param idLog id para logearse del usuario
	 * @param contrasenia contrasenia del usuario
	 * @return
	 */
	public static int comprobarUsuario(String nombre, String contrasenia) {
		int resultado = 0;
		String s = "SELECT nombre,contrasenia FROM Pasajero WHERE nombre = '"+nombre+"'";
		
		con = inicializarBD("deustoAirport.db");
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(s);
			if(rs.next()) { 
				String contrasenia2 = rs.getString("contrasenia");
				if(contrasenia.equals(contrasenia2))
					resultado = 2;
				else
					resultado = 1;
			}
			cerrarBD(con, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
		
	}
	/**
	 * Metodo para insertar personas que se pueden logear
	 */
	public static void insertarPasajero(Pasajero nuevoPasajero) {
		String s = "INSERT INTO Pasajero VALUES('"+nuevoPasajero.getNombre()+"','"+nuevoPasajero.getApellido()+"',"+nuevoPasajero.getEdad()+",'"+nuevoPasajero.getDni()+"',"+nuevoPasajero.getNumeroBillete()+",'"+nuevoPasajero.getContrasenia()+"')";
		String sql = "SELECT dni FROM Pasajero WHERE dni= '"+nuevoPasajero.getDni()+"'";
		con = BaseDeDatos.inicializarBD("deustoAirport.db");
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(!rs.next())
				st.executeUpdate(s);
			cerrarBD(con, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	/**
	* Metodo para insertar vuelos en la base de datos
	*/
	}
	public static void insertarVuelo(Vuelo nuevoVuelo) {
		String s = "INSERT INTO Vuelo VALUES("+nuevoVuelo.getHoraSalida().getTime()+",'"+nuevoVuelo.getIdAvion()+"','"+nuevoVuelo.getDestino()+"',"+nuevoVuelo.getHoraLlegada().getTime()+","+nuevoVuelo.getPuerta()+",'"+nuevoVuelo.getObservacion()+"')";
		String sql = "SELECT * FROM Vuelo WHERE idAvion ='"+nuevoVuelo.getIdAvion()+"'";
		ResultSet rs = null;
		con = inicializarBD("deustoAirport.db");
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(!rs.next())
				st.executeUpdate(s);
			cerrarBD(con, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void insertarPiloto(Piloto nuevoPiloto) {
		String s = "INSERT INTO Tripulacion VALUES("+nuevoPiloto.getTipoTripulacion()+",'"+nuevoPiloto.getNombre()+"','"+nuevoPiloto.getApellido()+"',"+nuevoPiloto.getEdad()+",'"+nuevoPiloto.getDni()+"','"+nuevoPiloto.getNacionalidad()+"',"+nuevoPiloto.getAnyosExperiencia()+","+nuevoPiloto.getVuelosRealizados()+"',"+nuevoPiloto.getTipo()+")";    
		String sql = "SELECT * FROM Tripulacion WHERE dni ='"+nuevoPiloto.getDni()+"'";
		con = inicializarBD("deustoAirport.db");
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (!rs.next())
				st.executeUpdate(s);
			cerrarBD(con, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void insertarAzafata(Azafata nueva) {
		String s = "INSERT INTO Tripulacion VALUES("+nueva.getTipoTripulacion()+",'"+nueva.getNombre()+"','"+nueva.getApellido()+"',"+nueva.getEdad()+",'"+nueva.getDni()+"','"+nueva.getNacionalidad()+"',"+nueva.getAnyosExperiencia()+","+nueva.getVuelosRealizados()+"',"+nueva.getAltura()+","+nueva.getPeso()+")"; 
		String sql = "SELECT * FROM Tripulacion WHERE dni ='"+nueva.getDni()+"'";
		con = inicializarBD("deustoAirport.db");
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (!rs.next())
				st.executeUpdate(s);
			cerrarBD(con, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<Vuelo> obtenerArrayDeVuelos(){
		String sql = "SELECT * FROM Vuelo";
		con = inicializarBD("deustoAirport.db");		
		ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Date d1 = new Date(rs.getLong("horaSalida"));
				Date horaSalida = new Date(rs.getLong("horaSalida"));
				String idAvion = rs.getString("idAvion");
				String destino = rs.getString("destino");
				Date horaLlegada = new Date(rs.getLong("horaLlegada"));
				int puerta = rs.getInt("puerta");	
				String observacion = rs.getString("observacion");
				ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();
				ArrayList<Tripulacion> tripulacion1 = new ArrayList<Tripulacion>();
				Vuelo v1 = new Vuelo(idAvion, null, destino, horaSalida,horaLlegada, pasajeros,tripulacion1,observacion,puerta);
				vuelos.add(v1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				cerrarBD(con, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
		return vuelos;		
	}
	public static ArrayList<Tripulacion> obtenerArrayDeTripulacion(){
		String sql = "SELECT * FROM Tripulacion";
		con = inicializarBD("deustoAirport.db");		
		ArrayList<Tripulacion> tripulacion = new ArrayList<Tripulacion>();
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int tipoTripulacion = rs.getInt("tipoTripulacion");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int edad = rs.getInt("edad");
				String dni = rs.getString("dni");
				String nacionalidad = rs.getString("nacionalidad");
				int anyosExperiencia = rs.getInt("anyosExp");
				int vuelosRealizados = rs.getInt("vuelosRealizados");
				if (tipoTripulacion == 0) {
					Tripulacion t1 = new Piloto(nombre, apellido, edad, dni, anyosExperiencia, vuelosRealizados, nacionalidad, tipoTripulacion,null);
					tripulacion.add(t1);
				}else {
					Tripulacion t2 = new Azafata(nombre, apellido, edad, dni, nacionalidad, anyosExperiencia, vuelosRealizados, nacionalidad, tipoTripulacion,0,0);
					tripulacion.add(t2);
				}
				
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				cerrarBD(con, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
		return tripulacion;		
	}
	public static ArrayList<Pasajero> obtenerArrayDePasajeros(){
		String sql = "SELECT * FROM Pasajero";
		con = inicializarBD("deustoAirport.db");
		ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int edad = rs.getInt("edad");
				String dni = rs.getString("dni");
				int numeroBillete = rs.getInt("numeroBillete");
				String contrasenia = rs.getString("contrasenia");
				/**
				 * Por defecto la clase del pasajero es economica
				 */
				Pasajero p = new Pasajero(nombre, apellido, edad, dni, numeroBillete,ClasePasajero.ECONOMICA, contrasenia);
				pasajeros.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pasajeros;
		
	}
	
	public static void modificarVuelo(String a, String b, String c, String d, String e) {
		String sql = "UPDATE Vuelo SET idAvion='"+a+"',origen="+b+"',destino='"+c+"',horaSalida="+d+",horaLlegada="+e;     
		con = inicializarBD("deustoAirport.db");
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			cerrarBD(con, st);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}