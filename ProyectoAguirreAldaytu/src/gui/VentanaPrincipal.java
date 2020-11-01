package gui;

import java.awt.*;
import javax.swing.*;


public class VentanaPrincipal extends JFrame {
	
	JMenuBar barra;
	JMenu pasajeros;
	JMenu tripulacion;
	JMenu vuelos;
	JMenuItem pilotos;
	JMenuItem azafatas;
	
	public VentanaPrincipal() {
		barra = new JMenuBar();
		pasajeros = new JMenu("Pasajeros del avión");
		tripulacion = new JMenu("Tripulación del vuelo");
		vuelos = new JMenu("Vuelos del aeropuerto");
		pilotos = new JMenuItem("Piloto del vuelo");
		azafatas = new JMenuItem("Azafatas del vuelo");
		
		barra.add(pasajeros);
		barra.add(tripulacion);
		barra.add(vuelos);
		tripulacion.add(pilotos);
		tripulacion.add(azafatas);
		
		this.setJMenuBar(barra);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Deusto Airport");
		setSize(900, 900);
		setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaPrincipal();
			}
		});
	}
}
