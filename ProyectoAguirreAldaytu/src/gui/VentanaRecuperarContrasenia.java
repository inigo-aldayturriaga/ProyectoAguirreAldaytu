package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaRecuperarContrasenia extends JFrame {
	public JButton bConfirmar;
	public JTextField tfContraseniaNueva,tfContraseniaNueva2;
	public JLabel lblContraseniaNueva,lblContraseniaNueva2;
	public JPanel pNorte,pCentro,pSur;
	
	public VentanaRecuperarContrasenia() {
		/**
		 * Dimensiones
		 */
		JFrame ventana = this;
		ventana.setBounds(0,0,600,400);
		ventana.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ventana.setTitle("VENTANA RECUPERAR CONTRASEÑA");
		/**
		 * Inicializamos los paneles
		 */
		pNorte = new JPanel();
		pCentro = new JPanel();
		pCentro.setLayout(new GridLayout(2,2));
		pSur = new JPanel();
		/**
		 * Inicializamos los textfields
		 */
		tfContraseniaNueva = new JTextField(20);
		tfContraseniaNueva2 = new JTextField(20);
		/**
		 * Inicializamos los labels
		 */
		lblContraseniaNueva = new JLabel("Introduce la nueva contraseña");
		lblContraseniaNueva2 = new JLabel("Introduce de nuevo la nueva contraseña");
		/**
		 * Inicializamos los botones
		 */
		bConfirmar = new JButton("CONFIRMAR");
		/**
		 * Añadimos los componentes al panel Central
		 */
		pCentro.add(lblContraseniaNueva);
		pCentro.add(tfContraseniaNueva);
		pCentro.add(lblContraseniaNueva2);
		pCentro.add(tfContraseniaNueva2);
		/**
		 * Añadimos los diferentes paneles a la ventana
		 */
		getContentPane().add(pNorte,BorderLayout.NORTH);
		getContentPane().add(pCentro,BorderLayout.CENTER);
		getContentPane().add(pSur,BorderLayout.SOUTH);
		
		setVisible(true);
	}

}
