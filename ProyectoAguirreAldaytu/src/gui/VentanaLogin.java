package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblNombre,lblContrasenia;
	public JTextField tfNombre,tfContrasenia;
	public JButton bConfirmar,bRecuperarContrasenia,bBorrar;
	public JPanel pNorte,pCentro,pSur;
	
	public VentanaLogin() {
		/**
		 * Dimensiones
		 */
		JFrame ventana = this;
		ventana.setBounds(0,0,600,400);
		ventana.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ventana.setTitle("VENTANA LOGIN");
		/**
		 * Inicializamos los labels
		 */
		lblNombre = new JLabel("Nombre: ");
		lblContrasenia = new JLabel("Contraseña: ");
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
		tfNombre = new JTextField(5);
		tfContrasenia = new JTextField(5);
		/**
		 * Inicializamos los botones
		 */
		bConfirmar = new JButton("CONFIRMAR");
		bRecuperarContrasenia = new JButton("¿Has olvidado tu contraseña?");
		bBorrar = new JButton("BORRAR");
		/**
		 * Añadimos los diferentes componentes al panel Centro
		 */
		pCentro.add(lblNombre);
		pCentro.add(tfNombre);
		pCentro.add(lblContrasenia);
		pCentro.add(tfContrasenia);
		/**
		 * Añadimos los botones al panel sur (botonera)
		 */
		pSur.add(bConfirmar);
		pSur.add(bBorrar);
		pSur.add(bRecuperarContrasenia);
		/**
		 * Añadimos los diferentes paneles a la ventana
		 */
		getContentPane().add(pNorte,BorderLayout.NORTH);
		getContentPane().add(pCentro,BorderLayout.CENTER);
		getContentPane().add(pSur,BorderLayout.SOUTH);
		
		
		bConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TO DO
				
			}
		});
		
		bBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tfNombre.setText("");
				tfContrasenia.setText("");
				
			}
		});
		bRecuperarContrasenia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaRecuperarContrasenia();
				ventana.dispose();
			}
		});
		setVisible(true);
		
	}
	public static void main(String[] args) {
		VentanaLogin vp = new VentanaLogin();
	}
	
	
	
	

}
