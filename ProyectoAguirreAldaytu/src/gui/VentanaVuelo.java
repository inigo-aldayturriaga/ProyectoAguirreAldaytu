package gui;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import bd.BaseDeDatos;
import datos.Pasajero;
import datos.Tripulacion;
import datos.Vuelo;

public class VentanaVuelo extends JFrame{
	
	JLabel lnumero;
    JTextField tnumero;
	JLabel lorigen;
    JTextField torigen;
    JLabel ldestino;
    JTextField tdestino;
    JLabel lhoraSalida;
    JTextField txtHoraSalida;
    JLabel lhoraLlegada;
    JTextField txtHoraLlegada;
    JLabel lpuerta;
    JSpinner spinPuerta;
    JLabel lobservacion;
    JTextField tobservacion;
    JButton crear;
	JButton cancelar;
	Vuelo vuelo;
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    public VentanaVuelo() {
    	lnumero = new JLabel("ID del avión");
    	tnumero = new JTextField(20);
		lorigen = new JLabel("Origen");
		torigen = new JTextField(20);
		ldestino = new JLabel("Destino");
		tdestino = new JTextField(20);
		lhoraSalida = new JLabel("Hora de salida");
		txtHoraSalida = new JTextField(20);
		lhoraLlegada = new JLabel("Hora de llegada");
		txtHoraLlegada = new JTextField(20);
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
			txtHoraSalida.setText(sdf.format(vuelo.getHoraSalida()));
			txtHoraLlegada.setText(sdf.format(vuelo.getHoraLlegada()));
			spinPuerta.setValue(vuelo.getPuerta());
			tobservacion.setText(vuelo.getObservacion());
			
			
			
		}
		
		cancelar = new JButton("Cancelar");
		
		cancelar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaPrincipal();
			}
		});
		
		crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/**
				 * Por defecto cuando creamos ambas listas están vacias
				 */
				
					try {
						Vuelo nuevoVuelo;
						nuevoVuelo = new Vuelo();
						nuevoVuelo.setIdAvion(tnumero.getText());
						nuevoVuelo.setOrigen(torigen.getText());
						nuevoVuelo.setDestino(tdestino.getText());
						Date d1 = sdf.parse(txtHoraLlegada.getText());
						nuevoVuelo.setHoraSalida(d1);
						Date d2 = sdf.parse(txtHoraSalida.getText());
						nuevoVuelo.setHoraLlegada(d2);
						nuevoVuelo.setPuerta((Integer) spinPuerta.getValue());
						nuevoVuelo.setObservacion(tobservacion.getText());
						ArrayList<Pasajero> listaPasajeros = new ArrayList<Pasajero>();
						ArrayList<Tripulacion> listaTripulacion = new ArrayList<Tripulacion>();
						nuevoVuelo.setListaPasajeros(listaPasajeros);
	
						nuevoVuelo.setListaTripulacion(listaTripulacion);
						BaseDeDatos.insertarVuelo(nuevoVuelo);
						VentanaBarraProgreso vh = new VentanaBarraProgreso("vuelo");
						vh.setVisible(true);
					} catch (ParseException e1) {
						
						JOptionPane.showMessageDialog(null, "ERROR!! El formato de la hora no es correcto");
					}
		
				dispose();
				new VentanaPrincipal();
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
		add(txtHoraSalida);
		add(lhoraLlegada);
		add(txtHoraLlegada);
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
		Color color1 = new Color(48, 163, 255);
		Color color2 = new Color(14,105,179);
		crear.setBackground(color1);
		cancelar.setBackground(color2);
				
    }

}
