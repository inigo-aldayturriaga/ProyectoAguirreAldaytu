package gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.Vuelo;

public class VentanaUsuario extends JFrame {
	private static JTable tabla;
	private static DefaultTableModel modelo;
	private static ArrayList<Vuelo> listaVuelos = new ArrayList<Vuelo>();
	
	public VentanaUsuario () {
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = new JTable (modelo);
		
		
		
		
		setVisible(true);
	}

}
