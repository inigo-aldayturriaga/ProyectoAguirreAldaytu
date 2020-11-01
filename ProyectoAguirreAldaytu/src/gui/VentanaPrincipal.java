package gui;

import java.awt.*;
import javax.swing.*;


public class VentanaPrincipal extends JFrame {
	
	JMenuBar barra;//Una barra arriba que contendra diferentes Items
	JMenu pasajeros;//Dentro de la barra un menu pasajeros
	JMenu tripulacion;//Dentro de la barra un menu tripulacion
	JMenu vuelos;//Dentro de la barra un menu vuelos
	JMenuItem pilotos;//Dentro de la tripulacion un item de pilotos
	JMenuItem azafatas;//Dentro de la tripulacion un item de azafatas
	
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
