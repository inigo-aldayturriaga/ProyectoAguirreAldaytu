package gui;

import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import bd.BaseDeDatos;



public class VentanaPrincipal extends JFrame {
	
	JMenuBar barra;//Una barra arriba que contendra diferentes Items
	JMenu pasajeros;//Dentro de la barra un menu pasajeros
	JMenu tripulacion;//Dentro de la barra un menu tripulacion
	JMenu vuelos;//Dentro de la barra un menu vuelos
	JMenuItem pilotos;//Dentro de la tripulacion un item de pilotos
	JMenuItem azafatas;//Dentro de la tripulacion un item de azafatas
	JPanel contentPane;
	JPanel panelCentral;
	JTable tabla;
	DefaultTableModel modeloTabla;
	
	public VentanaPrincipal() {
		//Creamos todos los componentes y les asignamos un nombre
		barra = new JMenuBar();
		pasajeros = new JMenu("Pasajeros del avión");
		tripulacion = new JMenu("Tripulación del vuelo");
		vuelos = new JMenu("Vuelos del aeropuerto");
		pilotos = new JMenuItem("Piloto del vuelo");
		azafatas = new JMenuItem("Azafatas del vuelo");
		
		//Añadimos a la barra los diferentes menus y al menu tripulacion los items pilotos y azafatas
		barra.add(pasajeros);
		barra.add(tripulacion);
		barra.add(vuelos);
		tripulacion.add(pilotos);
		tripulacion.add(azafatas);
		this.setJMenuBar(barra);
		
		//Personalizamos la ventana y la hacemos visible
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Deusto Airport");
		setSize(900, 900);
		setVisible(true);
		
		Connection con = BaseDeDatos.inicializarBD("Vuelos.db");
		Statement st = BaseDeDatos.usarCrearTablasBD(con);
		BaseDeDatos.cerrarBD(con, st);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("ID AVION");
		modeloTabla.addColumn("ORIGEN");
		modeloTabla.addColumn("DESTINO");
		modeloTabla.addColumn("HORA SALIDA");
		modeloTabla.addColumn("HORA LLEGADA");
		ArrayList<Object[]> vuelos = BaseDeDatos.obtenerArrayDeVuelos();
		for(Object[] fila: vuelos)
			modeloTabla.addRow(fila);
		
		
		modeloTabla.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				int fila = e.getFirstRow();
				System.out.println("Fila modificada: "+fila);
				modeloTabla = (DefaultTableModel) tabla.getModel();
				String a = String.valueOf(modeloTabla.getValueAt(fila, 0));
				String b = String.valueOf(modeloTabla.getValueAt(fila, 1));
				String c = String.valueOf(modeloTabla.getValueAt(fila, 2));
				int horaSalida = Integer.parseInt(String.valueOf(modeloTabla.getValueAt(fila, 3)));
				int horaLLegada = Integer.parseInt(String.valueOf(modeloTabla.getValueAt(fila, 3)));
				BaseDeDatos.modificarVuelo(a, b, c, horaSalida, horaLLegada);
			}
		});
		
		
	}
	//Main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin vl = new VentanaLogin();
					vl.setVisible(true);
				}catch (Exception e){
					e.printStackTrace();	
				}
			}
		});
	}
}
