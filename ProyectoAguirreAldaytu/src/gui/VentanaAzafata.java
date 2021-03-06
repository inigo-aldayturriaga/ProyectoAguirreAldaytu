package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import bd.BaseDeDatos;
import datos.Persona;
import datos.Azafata;
import datos.Tripulacion;



public class VentanaAzafata extends JFrame {
	JLabel lnombre;
	JTextField tnombre;
    JLabel lapellido;
    JTextField tapellido;
    JLabel ledad;
    JSpinner spinEdad;
    JLabel ldni;
    JTextField tdni;
    JLabel lanyosExperiencia;
    JSpinner spinAnyosExperiencia;
    JLabel lvuelosRealizados;
    JSpinner spinVuelosRealizados;
    JLabel lnacionalidad;
	JTextField tnacionalidad;
	JLabel laltura;
    JSpinner spinAltura;
    JLabel lpeso;
    JSpinner spinPeso;
    JButton crear;
    JButton cancelar;
    Azafata azafata;
    
    public VentanaAzafata() {
    	lnombre = new JLabel("Nombre");
		tnombre = new JTextField(20);
		lapellido = new JLabel("Apellido");
		tapellido = new JTextField(20);
		ledad = new JLabel("Edad");
		spinEdad = new JSpinner(new SpinnerNumberModel());
		ldni = new JLabel("DNI");
		tdni = new JTextField(20);
		lanyosExperiencia = new JLabel("Años de experiencia");
		spinAnyosExperiencia = new JSpinner(new SpinnerNumberModel());
		lvuelosRealizados = new JLabel("Numero de vuelos realizados");
		spinVuelosRealizados = new JSpinner(new SpinnerNumberModel());
		lnacionalidad = new JLabel("Nacionalidad");
		tnacionalidad = new JTextField(20);	
		laltura = new JLabel("Altura");
		spinAltura = new JSpinner(new SpinnerNumberModel());
		lpeso = new JLabel("Peso");
		spinPeso = new JSpinner(new SpinnerNumberModel());
		crear = new JButton("Crear");
		
		if (azafata != null) {
			crear.setText("Guardar datos");
			tnombre.setText(azafata.getNombre());
			tapellido.setText(azafata.getApellido());
			spinEdad.setValue(azafata.getEdad());
			tdni.setText(azafata.getDni());
			spinAnyosExperiencia.setValue(azafata.getAnyosExperiencia());
			spinVuelosRealizados.setValue(azafata.getVuelosRealizados());
			tnacionalidad.setText(azafata.getNacionalidad());
			spinAltura.setValue(azafata.getAltura());
			spinPeso.setValue(azafata.getPeso());
			
			
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
				Azafata nueva;
				nueva = new Azafata();
				nueva.setNombre(tnombre.getText());
				nueva.setApellido(tapellido.getText());
				nueva.setEdad((Integer) spinEdad.getValue());
				nueva.setDni(tdni.getText());
				nueva.setAnyosExperiencia((Integer) spinAnyosExperiencia.getValue());
				nueva.setVuelosRealizados((Integer) spinVuelosRealizados.getValue());
				nueva.setNacionalidad(tnacionalidad.getText());
				nueva.setAltura((Integer) spinAltura.getValue());
				nueva.setPeso((Integer) spinPeso.getValue());
				BaseDeDatos.insertarAzafata(nueva);
				VentanaBarraProgreso vh = new VentanaBarraProgreso("azafata");
				vh.setVisible(true);
				dispose();
			}
		});

		
		this.setLayout(new GridLayout(10, 2));
		//añadimos las etiquetas, spinners y combobox a la ventana
		add(lnombre);
		add(tnombre);
		add(lapellido);
		add(tapellido);
		add(ledad);
		add(spinEdad);
		add(ldni);
		add(tdni);
		add(lanyosExperiencia);
		add(spinAnyosExperiencia);
		add(lvuelosRealizados);
		add(spinVuelosRealizados);
		add(lnacionalidad);
		add(tnacionalidad);
		add(laltura);
		add(spinAltura);
		add(lpeso);
		add(spinPeso);
		add(crear);
		add(cancelar);
		
		
		//personalizamos la ventana con el titulo, dimensiones,distribucion...y la hacemos visible y se cerrará la ventana si queremos salir de ella
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Añadir nueva azafata");
		setSize(500, 500);
		setVisible(true);
		Color color1 = new Color(48, 163, 255);
		Color color2 = new Color(14,105,179);
		crear.setBackground(color1);
		cancelar.setBackground(color2);
		
    }
	
}

