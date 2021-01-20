package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import datos.DeustoAir;
import datos.Pasajero;
import datos.Tripulacion;
import datos.Vuelo;

public class VentanaAsignarPasajeros extends JFrame {
	private JList<Pasajero> listPasajeros;
	private DefaultListModel<Pasajero> modeloPasajeros;
	private JList<Vuelo> listVuelo;
	private DefaultListModel<Vuelo> modeloVuelo;
	private JPanel pCentro,pSur;
	private JScrollPane sc;
	private JButton bAniadir,bVolver;
	
	public VentanaAsignarPasajeros() {
		/**
		 * Estructura ventana
		 */
		JFrame ventana = this;
		setSize(1200, 600);
		pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(1, 3, 0, 0));
		pSur = new JPanel();
		sc = new JScrollPane();
		sc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		bAniadir = new JButton("Aniadir");
		bVolver = new JButton("Volver");
		/**
		 * Creamos los diferentes componentes
		 */
		modeloPasajeros = new DefaultListModel<Pasajero>();
		modeloVuelo = new DefaultListModel<Vuelo>();
		
		/**
		 * Obtenemos los datos de la base de datos
		 */
		for (Vuelo v : DeustoAir.getVuelos()) {
			v.setOrigen("Bilbao");
			modeloVuelo.addElement(v);
		}
		
		
		for (Pasajero p : DeustoAir.getPasajeros()) {
			modeloPasajeros.addElement(p);
		}
		
		
		listVuelo = new JList<Vuelo>(modeloVuelo);
		listPasajeros = new JList<Pasajero>(modeloPasajeros);
		
		pSur.add(bAniadir);
		pSur.add(bVolver);
		pCentro.add(listPasajeros);
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
				if (listPasajeros.getSelectedIndex() != -1) {
					if(listVuelo.getSelectedIndex()!= -1) {
						Pasajero p = modeloPasajeros.getElementAt(listPasajeros.getSelectedIndex());
						Vuelo v = modeloVuelo.getElementAt(listVuelo.getSelectedIndex());
						ArrayList<Pasajero> al = v.getListaPasajeros();
						al.add(p);
						JOptionPane.showMessageDialog(null, "Se ha añadido un pasajero correctamente.");
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

