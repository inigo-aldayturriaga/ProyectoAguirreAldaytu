package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import bd.BaseDeDatos;
import datos.DeustoAir;
import datos.Tripulacion;
import datos.Vuelo;
import datos.Pasajero;

public class VentanaAsignaciones extends JFrame {
	private JList<Tripulacion> listTripulacion;
	private DefaultListModel<Tripulacion> modeloTripulacion;
	private JList<Vuelo> listVuelo;
	private DefaultListModel<Vuelo> modeloVuelo;
	private JPanel pCentro;
	private JScrollPane sc;
	
	
	public VentanaAsignaciones() {
		/**
		 * Estructura ventana
		 */
		setSize(1200, 600);
		pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(1, 3, 0, 0));
		sc = new JScrollPane();
		sc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
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
			System.out.println(t);
		}
		
		
		listVuelo = new JList<Vuelo>(modeloVuelo);
		listTripulacion = new JList<Tripulacion>(modeloTripulacion);

		
		pCentro.add(listVuelo);
		pCentro.add(listTripulacion);
		getContentPane().add(pCentro,BorderLayout.CENTER);
	}
}