package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import datos.ClasePasajero;
import datos.Pasajero;





public class VentanaPasajero extends JFrame {
	
	JLabel lnombre;
	JTextField tnombre;
    JLabel lapellido;
    JTextField tapellido;
    JLabel ledad;
    JSpinner spinEdad;
    JLabel ldni;
    JTextField tdni;
    JLabel lnumeroBillete;
    JSpinner spinNumeroBillete;
    JLabel lclase;
    JComboBox<ClasePasajero> comboClase;
    JLabel lcontrasenia;
	JTextField tcontrasenia;
    JButton crear;
    JButton cancelar;
    Pasajero pasajero;

    public VentanaPasajero() {
    	lnombre = new JLabel("Nombre");
		tnombre = new JTextField(20);
		lapellido = new JLabel("Apellido");
		tapellido = new JTextField(20);
		ledad = new JLabel("Edad");
		spinEdad = new JSpinner(new SpinnerNumberModel());
		ldni = new JLabel("DNI");
		tdni = new JTextField(20);
		lnumeroBillete = new JLabel("Numero del billete");
		spinNumeroBillete = new JSpinner(new SpinnerNumberModel());		
		comboClase = new JComboBox<ClasePasajero>();
		comboClase.addItem(ClasePasajero.ECONOMICA);
		comboClase.addItem(ClasePasajero.ECONOMICAFLEXIBLE);
		comboClase.addItem(ClasePasajero.EJECUTIVA);
		comboClase.addItem(ClasePasajero.PRIMERA);
		comboClase.addItem(ClasePasajero.SEGUNDA);
		lcontrasenia = new JLabel("Contraseña");
		tcontrasenia = new JTextField(20);
		
		
		crear = new JButton("Crear");
		if (pasajero != null) {
			crear.setText("Guardar datos");
			tnombre.setText(pasajero.getNombre());
			tapellido.setText(pasajero.getApellido());
			spinEdad.setValue(pasajero.getEdad());
			tdni.setText(pasajero.getDni());
			spinNumeroBillete.setValue(pasajero.getNumeroBillete());
			comboClase.setSelectedItem(pasajero.getClase());
			tcontrasenia.setText(pasajero.getContrasenia());
			
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
				Pasajero nuevoPasajero;
				
				if (pasajero != null) {
					nuevoPasajero = pasajero;
					nuevoPasajero.setNombre(tnombre.getText());
					nuevoPasajero.setApellido(tapellido.getText());
					nuevoPasajero.setEdad((Integer) spinEdad.getValue());
					nuevoPasajero.setDni(tdni.getText());
					nuevoPasajero.setNumeroBillete((Integer) spinNumeroBillete.getValue());
					nuevoPasajero.setClase((ClasePasajero) comboClase.getSelectedItem());
					nuevoPasajero.setContrasenia(tcontrasenia.getText());
				}
				VentanaBarraProgreso vh = new VentanaBarraProgreso("pasajero");
				vh.setVisible(true);
				dispose();
			
			}
		});
		
		
		this.setLayout(new GridLayout(8, 2));
		//añadimos las etiquetas, spinners y combobox a la ventana
		add(lnombre);
		add(tnombre);
		add(lapellido);
		add(tapellido);
		add(ledad);
		add(spinEdad);
		add(ldni);
		add(tdni);
		add(lnumeroBillete);
		add(spinNumeroBillete);
		add(lclase);
		add(comboClase);
		add(lcontrasenia);
		add(tcontrasenia);
		add(crear);
		add(cancelar);
		
		
		//personalizamos la ventana con el titulo, dimensiones,distribucion...y la hacemos visible y se cerrará la ventana si queremos salir de ella
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Añadir nuevo pasajero");
		setSize(500, 500);
		setVisible(true);
    }
    
}
