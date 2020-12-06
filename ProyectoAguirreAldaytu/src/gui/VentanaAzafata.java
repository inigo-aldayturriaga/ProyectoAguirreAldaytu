package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class VentanaAzafata extends JFrame {
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
    JButton crear;
    JButton cancelar;
    
    public VentanaAzafata() {
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
		crear = new JButton("Crear");
		cancelar = new JButton("Cancelar");
		
		cancelar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		});
		
		this.setLayout(new GridLayout(5, 2));
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
		add(crear);
		add(cancelar);
		
		
		//personalizamos la ventana con el titulo, dimensiones,distribucion...y la hacemos visible y se cerrará la ventana si queremos salir de ella
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Añadir nueva azafata");
		pack();
		setVisible(true);
    }
	
}

