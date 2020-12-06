package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaVuelo extends JFrame{
	
	JLabel lnumero;
    JSpinner spinNumero;
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
    JButton crear;
	JButton cancelar;
    
    public VentanaVuelo() {
    	lnumero = new JLabel("ID del avión");
		spinNumero = new JSpinner(new SpinnerNumberModel());
		lorigen = new JLabel("Origen");
		torigen = new JTextField(20);
		ldestino = new JLabel("Apellido");
		tdestino = new JTextField(20);
		lhoraSalida = new JLabel("Hora de salida");
		spinHoraSalida = new JSpinner(new SpinnerNumberModel());
		lhoraLlegada = new JLabel("Hora de llegada");
		spinHoraLlegada = new JSpinner(new SpinnerNumberModel());
		lnumeroPasajeros = new JLabel("Numero de pasajeros");
		spinNumeroPasajeros = new JSpinner(new SpinnerNumberModel());
		lnumeroMaxPasajeros = new JLabel("Capacidad máxima del avión");
		spinNumeroMaxPasajeros = new JSpinner(new SpinnerNumberModel());
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
		add(lnumero);
		add(spinNumero);
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
		add(lnumeroMaxPasajeros);
		add(spinNumeroMaxPasajeros);
		add(crear);
		add(cancelar);
		
		//personalizamos la ventana con el titulo, dimensiones,distribucion...y la hacemos visible y se cerrará la ventana si queremos salir de ella
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Añadir nuevo vuelo");
		pack();
		setVisible(true);
				
    }

}
