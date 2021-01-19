package gui;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import bd.BaseDeDatos;
import datos.Vuelo;

public class VentanaUsuario extends JFrame {
	private static JTable tablaVuelos;
	private static DefaultTableModel modelo;
	private static ArrayList<Vuelo> listaVuelos = new ArrayList<Vuelo>();
	private static JPanel pCentro;
	
	
	public VentanaUsuario () {
		super();
		setSize(600,400);
		pCentro = new JPanel();
		ArrayList<Vuelo> al;
		
		BaseDeDatos.con = BaseDeDatos.inicializarBD("deustoAirport.db");
		BaseDeDatos.crearTablasBD(BaseDeDatos.con);
		BaseDeDatos.usarCrearTablasBD(BaseDeDatos.con);
		al = BaseDeDatos.obtenerArrayDeVuelos();
		
		
		//TABLA VUELOS
		DefaultTableModel modeloVuelos = new DefaultTableModel();
		String cabeceras[] = {"Hora Salida","Vuelo","Destino","Hora Llegada","Puerta","Observacion"};
		modeloVuelos.setColumnIdentifiers(cabeceras);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:mm aaa");
		for (Vuelo v : al) {
			String[] fila = {sdf.format(v.getHoraSalida()),v.getIdAvion(),v.getDestino(),sdf.format(v.getHoraLLegada()),String.valueOf(v.getPuerta()),v.getObservacion()};
			modeloVuelos.addRow(fila);
		}
		
		tablaVuelos = new JTable (modeloVuelos);
		pCentro.add(tablaVuelos);
		getContentPane().add(pCentro,BorderLayout.CENTER);
		BaseDeDatos.cerrarBD(BaseDeDatos.con, BaseDeDatos.st);
		setVisible(true);
	}

}
