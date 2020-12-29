package gui;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaUsuario {
	private JTable tabla;
	private DefaultTableModel modelo;
	
	public VentanaUsuario () {
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = new JTable (modelo);
	}

}
