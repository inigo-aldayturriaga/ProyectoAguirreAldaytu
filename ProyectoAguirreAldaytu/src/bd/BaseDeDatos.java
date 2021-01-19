package bd;

import datos.Persona;
import datos.Vuelo;

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
	public static Statement crearTablasBD( Connection con ) {
		try {
			st = con.createStatement();
			st.executeUpdate("create table Persona "+
						   "(nombre string, "+
						   " contrasenia string)");
			return st;
		} catch (SQLException e) {
			return null;
		}
	}
	public static Statement usarCrearTablasBD( Connection con ) {
		try {
			st = con.createStatement();
			st.executeUpdate("create table Vuelo "+
						   "(horaSalida string, "+
						   " idAvion string, "+
						   " destino string, "+
						   " horaLLegada string, "+
						   " puerta int, "+
						   "observacion string)");
				return st;
		} catch (SQLException e) {
			return null;
		}
	}
	
	/** Reinicia en blanco las tablas de la base de datos. 
	 * @param con	Conexión creada
	 * @return	sentencia de trabajo si se borra correctamente
	 */
	public static Statement reiniciarBD( Connection con ) {
		try {
			st = con.createStatement();
			st.executeUpdate("drop table if exists Persona");
			return crearTablasBD( con );
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
		String sql = "SELECT * FROM Persona WHERE nombre ='"+nombre+"'";
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
		String s = "SELECT * FROM Persona WHERE nombre = '"+nombre+"'";
		
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
	public static void insertarUsuario(String nombre, String contrasenia) {
		
		String s = "INSERT INTO Persona VALUES('"+nombre+"','"+contrasenia+"')";
		con = BaseDeDatos.inicializarBD("deustoAirport.db");
		try {
			st = con.createStatement();
			st.executeUpdate(s);
			cerrarBD(con, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	/**
	* Metodo para insertar vuelos en la base de datos
	*/
	}
	public static void insertarVuelo(Vuelo v) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:mm aaa");
		String s = "INSERT INTO Vuelo VALUES('"+sdf.format(v.getHoraSalida())+"','"+v.getIdAvion()+"','"+v.getDestino()+"','"+sdf.format(v.getHoraLLegada())+"',"+v.getPuerta()+",'"+v.getObservacion()+"')";
		con = inicializarBD("deustoAirport.db");
		try {
			st = con.createStatement();
			st.executeUpdate(s);
			cerrarBD(con, st);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<Vuelo> obtenerArrayDeVuelos(){
		String sql = "SELECT * FROM Vuelo";
		con = inicializarBD("deustoAirport.db");		
		ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
		ResultSet rs = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:mm aaa");
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				String horaSalida = sdf.format(rs.getString("horaSalida"));
				String idAvion = rs.getString("idAvion");
				String destino = rs.getString("destino");
				String horaLlegada = sdf.format(rs.getString("horaLlegada"));
				int puerta = rs.getInt("puerta");	
				String observacion = rs.getString("observacion");

				Vuelo v1 = new Vuelo(idAvion, null, destino, Date.valueOf(horaSalida),Date.valueOf(horaLlegada), null,observacion,puerta);
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