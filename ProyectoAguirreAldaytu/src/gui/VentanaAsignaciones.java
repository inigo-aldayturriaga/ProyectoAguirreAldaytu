package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import datos.Asignable;
import datos.DeustoAir;
import datos.Tripulacion;
import datos.Pasajero;

public class VentanaAsignaciones extends JFrame {
	
	JLabel ltripulacion;
	JComboBox<Asignable> comboTripulacion;
	JLabel lasignados;
	DefaultListModel modeloAsignados;
	JList asignados;
	JLabel lpasajeros;
	DefaultListModel modeloPasajeros;
	JList pasajeros;
	JButton asignar;
	JButton desasignar;
	
	
	
	public VentanaAsignaciones() {
		setLayout(new GridLayout(1, 3));
		
		JPanel izquierda = new JPanel(); 
		JPanel centro = new JPanel();
		JPanel derecha = new JPanel();
		
		izquierda.setLayout(new BorderLayout());
		centro.setLayout(new GridLayout(2,1));
		derecha.setLayout(new BorderLayout());
		
		ltripulacion = new JLabel("Selecciona tripulante: ");
		comboTripulacion = new JComboBox<Asignable>();
		
		//for (Trabajador trabajador : hospital.getTrabajadores()) {
		//	if (trabajador instanceof Asignable) {
		//		comboTrabajadores.addItem((Asignable) trabajador);
		//	}
		//}
		lasignados = new JLabel("Pasajeros asignados: ");
		modeloAsignados = new DefaultListModel();
		
		Asignable tripulante = (Asignable) comboTripulacion.getSelectedItem();
		
		ArrayList<Pasajero> pacientesAsignados = DeustoAir.getAsignaciones().get(tripulante);
		
		modeloAsignados.clear();
		if (pasajerosAsignados != null) {
			for(Pasajero pasajero : pasajerosAsignados) {
				modeloAsignados.addElement(pasajero);
			}
		}
		asignados = new JList(modeloAsignados);
		lpasajeros = new JLabel("Todos los pasajeros: ");
		modeloPasajeros = new DefaultListModel();
		
		for (Pasajero pasajero: deustoAir.getPasajeros()) {
			modeloPasajero.addElement(pasajero);
		}
		pasajeros = new JList(modeloPasajeros);
		asignar = new JButton("<-");
		desasignar = new JButton("->");
		
		asignar.addActionListener(new ActionListener() {
			//TODO
		});
		desasignar.addActionListener(new ActionListener() {
			//TODO
		});
		comboTrabajadores.addItemListener(new ItemListener() {
			//TODO
		});
		
		JPanel arribaIzquierda = new JPanel();
		arribaIzquierda.setLayout(new GridLayout(3,1));
		
		arribaIzquierda.add(ltripulantes);
		arribaIzquierda.add(comboTripulantes);
		arribaIzquierda.add(lasignados);
		
		JScrollPane scrollAsignados = new JScrollPane(asignados);
		
		izquierda.add(arribaIzquierda, BorderLayout.NORTH);
		izquierda.add(scrollAsignados);
				
		JPanel panelAsignar = new JPanel();
		JPanel panelDesasignar = new JPanel();
		
		panelAsignar.setLayout(new BorderLayout());
		panelDesasignar.setLayout(new BorderLayout());
		
		panelAsignar.add(asignar, BorderLayout.SOUTH);
		panelDesasignar.add(desasignar, BorderLayout.NORTH);
		
		centro.add(panelAsignar);
		centro.add(panelDesasignar);
		
		JScrollPane scrollPacientes = new JScrollPane(pasajeros);
		
		derecha.add(lpacientes, BorderLayout.NORTH);
		derecha.add(scrollPasajeros);
		
		add(izquierda);
		add(centro);
		add(derecha);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Gestión de asignaciones");
		setSize(800, 800);
		setVisible(true);
		

	}

}
