package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bd.BaseDeDatos;
import datos.DeustoAir;
import gui.VentanaAzafata;
import gui.VentanaPasajero;
import gui.VentanaPiloto;
import gui.VentanaVuelo;


public class VentanaPrincipal extends JFrame {
	
	JMenuBar barra;//Una barra arriba que contendra diferentes Items
	JMenu pasajeros;//Dentro de la barra un menu pasajeros
	JMenu tripulacion;//Dentro de la barra un menu tripulacion
	JMenu vuelos;//Dentro de la barra un menu vuelos
	JMenuItem asignacionTripulacion,asignacionPasajeros,nuevoVuelo,nuevoPasajero,nuevoPiloto,nuevaAzafata;
	PanelFondo fondo;
	JPanel pBotonera;
	JButton bVolver;
	
	
	public VentanaPrincipal() {
		JFrame ventana = this;
		//Creamos todos los componentes y les asignamos un nombre
		barra = new JMenuBar();
		pasajeros = new JMenu("Pasajeros del avión");
		tripulacion = new JMenu("Tripulación del vuelo");
		vuelos = new JMenu("Vuelos del aeropuerto");
		asignacionTripulacion = new JMenuItem("Asignar tripulacion");
		asignacionPasajeros = new JMenuItem("Asignar pasajeros");
		nuevoVuelo = new JMenuItem("Añadir nuevo vuelo");
		nuevoPasajero = new JMenuItem("Añadir nuevo pasajero");
		nuevoPiloto = new JMenuItem("Añadir nuevo piloto");
		nuevaAzafata = new JMenuItem("Añadir nueva azafata");
		fondo = new PanelFondo("imagenes/fondo.jpg");
		pBotonera = new JPanel();
		bVolver = new JButton("Volver");
		
		//Añadimos a la barra los diferentes menus y al menu tripulacion los items pilotos y azafatas
		barra.add(pasajeros);
		barra.add(tripulacion);
		barra.add(vuelos);
		pasajeros.add(asignacionPasajeros);
		pasajeros.add(nuevoPasajero);
		tripulacion.add(asignacionTripulacion);
		tripulacion.add(nuevoPiloto);
		tripulacion.add(nuevaAzafata);
		vuelos.add(nuevoVuelo);
		pBotonera.add(bVolver);
		
		this.setJMenuBar(barra);
		//Personalizamos la ventana y la hacemos visible
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Deusto Airport");
		setSize(500, 500);
		setContentPane(fondo);
		getContentPane().add(pBotonera,BorderLayout.SOUTH);
		
		bVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaLogin();
				dispose();
				
			}
		});
		asignacionPasajeros.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new VentanaAsignarPasajeros();
				ventana.dispose();
				
			}
		});
		asignacionTripulacion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaAsignarTripulacion();
				ventana.dispose();
				
			}
		});
		
		nuevoPasajero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaPasajero();
				ventana.dispose();
			}
		});
		nuevoPiloto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaPiloto();	
				ventana.dispose();
			}		
		});
		nuevaAzafata.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaAzafata();
				ventana.dispose();
			}		
		});
		nuevoVuelo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaVuelo();		
				ventana.dispose();
			}		
		});
		
		setVisible(true);
		
	}
	//Main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeustoAir da = new DeustoAir();
					VentanaLogin vl = new VentanaLogin();
					vl.setVisible(true);
				}catch (Exception e){
					e.printStackTrace();	
				}
			}
		});
	}
}
