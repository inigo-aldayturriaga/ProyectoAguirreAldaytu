package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaPiloto extends JFrame {
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
    JLabel lanyosExperiencia;
    JSpinner spinAnyosExperiencia;
    JLabel lvuelosRealizados;
    JSpinner spinVuelosRealizados;
    JButton crear;
    JButton cancelar;
    
    public VentanaPiloto() {
    	
    
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
		lanyosExperiencia = new JLabel("Años de experiencia");
		spinAnyosExperiencia = new JSpinner(new SpinnerNumberModel());
		lvuelosRealizados = new JLabel("Numero de vuelos realizados");
		spinVuelosRealizados = new JSpinner(new SpinnerNumberModel());
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
		add(lanyosExperiencia);
		add(spinAnyosExperiencia);
		add(lvuelosRealizados);
		add(spinVuelosRealizados);
		add(crear);
		add(cancelar);
		
		
		//personalizamos la ventana con el titulo, dimensiones,distribucion...y la hacemos visible y se cerrará la ventana si queremos salir de ella
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Añadir nuevo piloto");
		pack();
		setVisible(true);
    
    }
}
