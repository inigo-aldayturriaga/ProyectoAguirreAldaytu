package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import datos.ClasePasajero;



public class VentanaPasajero extends JFrame {
	
	JLabel lnombre;
	JTextField tnombre;
    JLabel lapellido;
    JTextField tapellido;
    JLabel ledad;
    JSpinner spinEdad;
    JLabel ldni;
    JSpinner spinDni;
    JLabel lresidencia;
    JTextField tResidencia;
    JLabel lnumeroBillete;
    JSpinner spinNumeroBillete;
    JLabel lclase;
    JComboBox<ClasePasajero> comboClase;
    JButton crear;
    JButton cancelar;
    

    public VentanaPasajero() {
    	lnombre = new JLabel("Nombre");
		tnombre = new JTextField(20);
		lapellido = new JLabel("Apellido");
		tapellido = new JTextField(20);
		ledad = new JLabel("Edad");
		spinEdad = new JSpinner(new SpinnerNumberModel());
		ldni = new JLabel("DNI");
		spinDni = new JSpinner(new SpinnerNumberModel());
		lresidencia = new JLabel("Lugar de residencia");
		tResidencia = new JTextField(20);
		lnumeroBillete = new JLabel("Numero del billete");
		spinNumeroBillete = new JSpinner(new SpinnerNumberModel());		
		comboClase = new JComboBox<ClasePasajero>();
		comboClase.addItem(ClasePasajero.ECONOMICA);
		comboClase.addItem(ClasePasajero.ECONOMICAFLEXIBLE);
		comboClase.addItem(ClasePasajero.EJECUTIVA);
		comboClase.addItem(ClasePasajero.PRIMERA);
		comboClase.addItem(ClasePasajero.SEGUNDA);
		crear = new JButton("Crear");
		cancelar = new JButton("Cancelar");
		
		cancelar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		add(spinDni);
		add(lresidencia);
		add(tResidencia);
		add(lclase);
		add(comboClase);
		add(crear);
		add(cancelar);
		
		
		//personalizamos la ventana con el titulo, dimensiones,distribucion...y la hacemos visible y se cerrará la ventana si queremos salir de ella
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Añadir nuevo pasajero");
		pack();
		setVisible(true);
    }
    
}
