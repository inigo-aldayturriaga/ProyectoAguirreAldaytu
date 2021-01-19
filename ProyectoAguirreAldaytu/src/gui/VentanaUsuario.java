package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;


import bd.BaseDeDatos;
import datos.Vuelo;

public class VentanaUsuario extends JFrame {
	private JTable tablaVuelos;
	private DefaultTableModel modelo;
	private ArrayList<Vuelo> listaVuelos = new ArrayList<Vuelo>();
	private JPanel pCentro,pSur;
	private JScrollPane sc;
	
	private JButton btnGenerarFichero;
	private int filaSeleccionada;
	
	public VentanaUsuario () {
		super();
		setSize(600,400);
		pCentro = new JPanel();
		pSur = new JPanel();
		ArrayList<Vuelo> al;
		
		
		BaseDeDatos.con = BaseDeDatos.inicializarBD("deustoAirport.db");
		BaseDeDatos.crearTablasBD(BaseDeDatos.con);
		BaseDeDatos.crearTablaVueloBD(BaseDeDatos.con);
		al = BaseDeDatos.obtenerArrayDeVuelos();
		
		
		//TABLA VUELOS
		DefaultTableModel modeloVuelos = new DefaultTableModel();
		Object[] cabeceras = {"Hora Salida","Vuelo","Destino","Hora Llegada","Puerta","Observacion"};
		modeloVuelos.setColumnIdentifiers(cabeceras);
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		for (Vuelo v : al) {
			String[] fila = {sdf.format(v.getHoraSalida()),v.getIdAvion(),v.getDestino(),sdf.format(v.getHoraLLegada()),String.valueOf(v.getPuerta()),v.getObservacion()};
			modeloVuelos.addRow(fila);
		}
		
		tablaVuelos = new JTable (modeloVuelos);
		sc = new JScrollPane(tablaVuelos);
		getContentPane().add(sc,BorderLayout.CENTER);
		
		btnGenerarFichero = new JButton("IMPRIMIR DATOS VUELO");
		pSur.add(btnGenerarFichero);
		getContentPane().add(pSur,BorderLayout.SOUTH);
		
		tablaVuelos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				filaSeleccionada = tablaVuelos.getSelectedRow();
			}
		});
		
		btnGenerarFichero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(filaSeleccionada!=-1) {
						PrintWriter pw = new PrintWriter("InformacionVuelo.txt");
						String hs = (String) modeloVuelos.getValueAt(filaSeleccionada, 0);
						String v = (String) modeloVuelos.getValueAt(filaSeleccionada, 1);
						String d = (String) modeloVuelos.getValueAt(filaSeleccionada, 2);
						String hl = (String) modeloVuelos.getValueAt(filaSeleccionada, 3);
						String p = (String) modeloVuelos.getValueAt(filaSeleccionada, 4);
						String o = (String) modeloVuelos.getValueAt(filaSeleccionada, 5);
						pw.println("HORA DE SALIDA: "+hs);
						pw.println("VUELO: "+v);
						pw.println("DESTINO: "+d);
						pw.println("HORA DE LLEGADA: "+hl);
						pw.println("PUERTA: "+p);
						pw.println("OBSERVACIONES: "+o);
						pw.flush();
						pw.close();
						JOptionPane.showMessageDialog(null, "Se ha generado la información correctamente.");
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		BaseDeDatos.cerrarBD(BaseDeDatos.con, BaseDeDatos.st);
		setVisible(true);
	}

}
