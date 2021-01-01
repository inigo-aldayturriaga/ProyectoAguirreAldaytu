package bd;

import datos.Persona;
import datos.Vuelo;

import java.sql.*;
import java.util.ArrayList;

public class BaseDeDatos {

	/** Inicializa una BD SQLITE y devuelve una conexión con ella
	 * @param nombreBD	Nombre de fichero de bd
	 * @return	Conexión con la base de datos indicada
	 */
	
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
			Statement statement = con.createStatement();
			statement.executeUpdate("create table Persona "+
						   "(nombre string, "+
						   " contrasenia string)");
			return statement;
		} catch (SQLException e) {
			return null;
		}
	}
	public static Statement usarCrearTablasBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.executeUpdate("create table Vuelo "+
						   "(idAvion string, "+
						   " origen string, "+
						   " destino string, "+
						   " horaSalida int, "+
						   " horaLLegada int )");
				return statement;
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
			Statement statement = con.createStatement();
			statement.executeUpdate("drop table if exists Persona");
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
	/**
	 * COMPROBACIONES CON LA TABLA PERSONA!
	 */
	public static boolean existeUsuario(String nombre) {
		boolean existeUsuario = false;
		String sql = "SELECT * FROM Persona WHERE nombre ='"+nombre+"'";
		Connection con = inicializarBD("deustoAirport.db");
		Statement st;
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
		
		Connection c = inicializarBD("deustoAirport.db");
		try {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(s);
			if(rs.next()) { 
				String contrasenia2 = rs.getString("contrasenia");
				if(contrasenia.equals(contrasenia2))
					resultado = 2;
				else
					resultado = 1;
			}
			cerrarBD(c, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
		
	}
	
	public static void insertarUsuario(String nombre, String contrasenia) {
		
		String s = "INSERT INTO Persona VALUES('"+nombre+"','"+contrasenia+"')";
		Connection c = BaseDeDatos.inicializarBD("deustoAirport.db");
		try {
			Statement st = c.createStatement();
			st.executeUpdate(s);
			cerrarBD(c, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	/**
	* COMPROBACIONES CON LA TABLA VUELOS!
	*/
	
	}
	public static void añadirVuelos(ArrayList<Vuelo> al) {
		for (Vuelo vuelo :  al) {
			
		}
		
	}
	public static ArrayList<Object[]> obtenerArrayDeVuelos(){
		String sql = "SELECT * FROM Vuelo";
		Connection con = inicializarBD("Vuelos.db");
		Statement st = null;
		ArrayList<Object[]> vuelos = new ArrayList<Object[]>();
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				String idAvion = rs.getString("dni");
				String origen = rs.getString("origen");
				String destino = rs.getString("destino");
				int horaSalida = rs.getInt("hora de salida");
				int horaLlegada = rs.getInt("hora de llegada");
				Object[] fila = {idAvion,origen,destino,horaSalida,horaLlegada};
				vuelos.add(fila);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				cerrarBD(con, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
		return vuelos;		
	}
	
	public static void modificarVuelo(String a, String b, String c, int d, int e) {
		String sql = "UPDATE Vuelo SET idAvion='"+a+"',origen="+b+"',destino='"+c+"',horaSalida="+d.intValue()+",horaLlegada="+e.intValue()";
		Connection con = inicializarBD("Vuelos.db");
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			cerrarBD(con, st);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}