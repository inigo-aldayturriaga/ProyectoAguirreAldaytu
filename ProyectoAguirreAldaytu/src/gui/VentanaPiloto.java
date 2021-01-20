package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import datos.Piloto;
import datos.Persona;
import datos.Tripulacion;

import datos.TipoPiloto;

import javax.swing.*;

public class VentanaPiloto extends JFrame {
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
	JComboBox<TipoPiloto> tipoPiloto;
    JButton crear;
    JButton cancelar;
    
	

    
    public VentanaPiloto(Piloto piloto) {
    	
    
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
		tipoPiloto = new JComboBox<TipoPiloto>();
		tipoPiloto.addItem(TipoPiloto.COMERCIAL);
		tipoPiloto.addItem(TipoPiloto.PRIVADO);

		crear = new JButton("Crear");
		
		if (piloto != null) {
			crear.setText("Guardar datos");
			tnombre.setText(piloto.getNombre());
			tapellido.setText(piloto.getApellido());
			spinEdad.setValue(piloto.getEdad());
			tdni.setText(piloto.getDni());
			spinAnyosExperiencia.setValue(piloto.getAnyosExperiencia());
			spinVuelosRealizados.setValue(piloto.getVuelosRealizados());
			tnacionalidad.setText(piloto.getNacionalidad());
			tipoPiloto.setSelectedItem(piloto.getTipo());
			
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
				Piloto nuevoPiloto;
				
				if (piloto != null) {
					nuevoPiloto = piloto;
				} else {
					nuevoPiloto = new Piloto();
				}
				
				nuevoPiloto.setNombre(tnombre.getText());
				nuevoPiloto.setApellido(tapellido.getText());
				nuevoPiloto.setEdad((Integer) spinEdad.getValue());
				nuevoPiloto.setDni(tdni.getText());
				nuevoPiloto.setAnyosExperiencia((Integer) spinAnyosExperiencia.getValue());
				nuevoPiloto.setVuelosRealizados((Integer) spinVuelosRealizados.getValue());
				nuevoPiloto.setNacionaldidad(tnacionalidad.getText());
				nuevoPiloto.setTipo((TipoPiloto) tipoPiloto.getSelectedItem());
			
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
		add(lanyosExperiencia);
		add(spinAnyosExperiencia);
		add(lvuelosRealizados);
		add(spinVuelosRealizados);
		add(lnacionalidad);
		add(tnacionalidad);
		add(crear);
		add(cancelar);
		
		
		//personalizamos la ventana con el titulo, dimensiones,distribucion...y la hacemos visible y se cerrará la ventana si queremos salir de ella
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Añadir nuevo piloto");
		pack();
		setVisible(true);
		
    
    }
			
}



