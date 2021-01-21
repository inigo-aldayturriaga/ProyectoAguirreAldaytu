package gui;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

import datos.Vuelo;

public class VentanaVuelo extends JFrame{
	
	JLabel lnumero;
    JTextField tnumero;
	JLabel lorigen;
    JTextField torigen;
    JLabel ldestino;
    JTextField tdestino;
    JLabel lhoraSalida;
    JSpinner spinHoraSalida;
    JLabel lhoraLlegada;
    JSpinner spinHoraLlegada;
    JLabel lnumeroPasajeros;
    JSpinner spinNumeroPasajeros;
    JLabel lnumeroMaxPasajeros;
    JSpinner spinNumeroMaxPasajeros;
    JLabel lpuerta;
    JSpinner spinPuerta;
    JLabel lobservacion;
    JTextField tobservacion;
    JButton crear;
	JButton cancelar;
	Vuelo vuelo;
    
    public VentanaVuelo() {
    	lnumero = new JLabel("ID del avión");
    	tnumero = new JTextField(20);
		lorigen = new JLabel("Origen");
		torigen = new JTextField(20);
		ldestino = new JLabel("Apellido");
		tdestino = new JTextField(20);
		lhoraSalida = new JLabel("Hora de salida");
		spinHoraSalida = new JSpinner(new SpinnerNumberModel());
		lhoraLlegada = new JLabel("Hora de llegada");
		spinHoraLlegada = new JSpinner(new SpinnerNumberModel());
		lnumeroPasajeros = new JLabel("Lista de pasajeros");
		spinNumeroPasajeros = new JSpinner(new SpinnerNumberModel());
		lpuerta = new JLabel("Numero puerta de embarque");
		spinPuerta = new JSpinner(new SpinnerNumberModel());
		lobservacion = new JLabel("Observacion");
		tobservacion = new JTextField(20);
		crear = new JButton("Crear");
		
		if (vuelo != null) {
			crear.setText("Guardar datos");
			tnumero.setText(vuelo.getIdAvion());
			torigen.setText(vuelo.getOrigen());
			tdestino.setText(vuelo.getDestino());
			spinHoraSalida.setValue(vuelo.getHoraSalida());
			spinHoraLlegada.setValue(vuelo.getHoraLlegada());
			spinNumeroPasajeros.setValue(vuelo.getListaPasajeros());
			spinPuerta.setValue(vuelo.getPuerta());
			tobservacion.setText(vuelo.getObservacion());
			
			
			
		}
		
		cancelar = new JButton("Cancelar");
		
		cancelar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		});
		
		crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vuelo nuevoVuelo;
				nuevoVuelo = new Vuelo();
				nuevoVuelo.setIdAvion(tnumero.getText());
				nuevoVuelo.setOrigen(torigen.getText());
				nuevoVuelo.setDestino(tdestino.getText());
				Date d1 = new Date((long) spinHoraSalida.getValue());
				nuevoVuelo.setHoraSalida(d1);
				Date d2 = new Date((long) spinHoraLlegada.getValue());
				nuevoVuelo.setHoraLlegada(d2);
				nuevoVuelo.setPuerta((Integer) spinPuerta.getValue());
				nuevoVuelo.setObservacion(tobservacion.getText());
				VentanaBarraProgreso vh = new VentanaBarraProgreso("vuelo");
				vh.setVisible(true);
				dispose();
			}
		});
    
		this.setLayout(new GridLayout(10, 2));
		//añadimos las etiquetas, spinners y combobox a la ventana
		add(lnumero);
		add(tnumero);
		add(lorigen);
		add(torigen);
		add(ldestino);
		add(tdestino);
		add(lhoraSalida);
		add(spinHoraSalida);
		add(lhoraLlegada);
		add(spinHoraLlegada);
		add(lnumeroPasajeros);
		add(spinNumeroPasajeros);
		add(lpuerta);
		add(spinPuerta);
		add(lobservacion);
		add(tobservacion);
		add(crear);
		add(cancelar);
		
		//personalizamos la ventana con el titulo, dimensiones,distribucion...y la hacemos visible y se cerrará la ventana si queremos salir de ella
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Añadir nuevo vuelo");
		setSize(500, 500);
		setVisible(true);
				
    }

}
