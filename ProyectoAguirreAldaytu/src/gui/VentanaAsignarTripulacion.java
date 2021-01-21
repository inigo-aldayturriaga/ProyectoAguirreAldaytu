package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bd.BaseDeDatos;
import datos.DeustoAir;
import datos.Tripulacion;
import datos.Vuelo;
import datos.Pasajero;

public class VentanaAsignarTripulacion extends JFrame {
	private JList<Tripulacion> listTripulacion;
	private DefaultListModel<Tripulacion> modeloTripulacion;
	private JList<Vuelo> listVuelo;
	private DefaultListModel<Vuelo> modeloVuelo;
	private JPanel pCentro,pSur;
	private JScrollPane sc;
	private JButton bAniadir,bVolver;
	
	
	public VentanaAsignarTripulacion() {
		/**
		 * Estructura ventana
		 */
		JFrame ventana = this;
		setSize(500, 500);
		pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(1, 3, 0, 0));
		pSur = new JPanel();
		sc = new JScrollPane();
		sc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		bAniadir = new JButton("Añadir");
		bVolver = new JButton("Volver");
		/**
		 * Creamos los diferentes componentes
		 */
		modeloTripulacion = new DefaultListModel<Tripulacion>();
		modeloVuelo = new DefaultListModel<Vuelo>();
		
		/**
		 * Obtenemos los datos de la base de datos
		 */
		for (Vuelo v : DeustoAir.getVuelos()) {
			v.setOrigen("Bilbao");
			modeloVuelo.addElement(v);
		}
		
		
		for (Tripulacion t : DeustoAir.getTripulacion()) {
			modeloTripulacion.addElement(t);
		}
		
		
		listVuelo = new JList<Vuelo>(modeloVuelo);
		listTripulacion = new JList<Tripulacion>(modeloTripulacion);
		
		pSur.add(bAniadir);
		pSur.add(bVolver);
		pCentro.add(listTripulacion);
		pCentro.add(listVuelo);
		getContentPane().add(pCentro,BorderLayout.CENTER);
		getContentPane().add(pSur,BorderLayout.SOUTH);
		setVisible(true);
		/**
		 * Eventos
		 */
		bAniadir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (listTripulacion.getSelectedIndex() != -1) {
					if(listVuelo.getSelectedIndex()!= -1) {
						Tripulacion t = modeloTripulacion.getElementAt(listTripulacion.getSelectedIndex());
						Vuelo v = modeloVuelo.getElementAt(listVuelo.getSelectedIndex());
						ArrayList<Tripulacion> al = v.getListaTripulacion();
						al.add(t);
						JOptionPane.showMessageDialog(null, "Se ha añadido un tripulante correctamente.");
					}
				}
					
			}
		});
		bVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				new VentanaPrincipal();
				
			}
		});
	}
	
}