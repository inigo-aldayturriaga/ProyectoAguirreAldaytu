package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import bd.BaseDeDatos;
import datos.DeustoAir;


public class VentanaPrincipal extends JFrame {
	
	JMenuBar barra;//Una barra arriba que contendra diferentes Items
	JMenu pasajeros;//Dentro de la barra un menu pasajeros
	JMenu tripulacion;//Dentro de la barra un menu tripulacion
	JMenu vuelos;//Dentro de la barra un menu vuelos
	JMenuItem asignacionTripulacion,asignacionPasajeros;
	
	public VentanaPrincipal() {
		JFrame ventana = this;
		//Creamos todos los componentes y les asignamos un nombre
		barra = new JMenuBar();
		pasajeros = new JMenu("Pasajeros del avión");
		tripulacion = new JMenu("Tripulación del vuelo");
		vuelos = new JMenu("Vuelos del aeropuerto");
		asignacionTripulacion = new JMenuItem("Asignar Tripulacion");
		asignacionPasajeros = new JMenuItem("Asignar Pasajeros");
		
		//Añadimos a la barra los diferentes menus y al menu tripulacion los items pilotos y azafatas
		barra.add(pasajeros);
		barra.add(tripulacion);
		barra.add(vuelos);
		pasajeros.add(asignacionPasajeros);
		tripulacion.add(asignacionTripulacion);
		
		this.setJMenuBar(barra);
		//Personalizamos la ventana y la hacemos visible
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Deusto Airport");
		setSize(900, 900);
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
