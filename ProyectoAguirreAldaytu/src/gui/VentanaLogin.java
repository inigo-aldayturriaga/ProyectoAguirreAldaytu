package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import bd.BaseDeDatos;
import datos.Pasajero;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblNombre,lblContrasenia;
	public JTextField tfNombre;
	public JPasswordField pfContrasenia;
	public JButton bConfirmar,bRecuperarContrasenia,bBorrar;
	public JPanel pNorte,pCentro,pSur;
	
	public VentanaLogin() {
		/**
		 * Dimensiones
		 */
		JFrame ventana = this;
		//ventana.setBounds(0,0,600,400);
		setSize(500, 500);
		ventana.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ventana.setTitle("VENTANA LOGIN");
		Color color1 = new Color(48, 163, 255);
		Color color2 = new Color(14,105,179);
		/**
		 * Inicializamos los labels
		 */
		lblNombre = new JLabel("        Nombre: ");
		lblNombre.setForeground(Color.WHITE);
		lblContrasenia = new JLabel("      Contraseña: ");
		lblContrasenia.setForeground(Color.WHITE);
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
		pfContrasenia = new JPasswordField(30);
		/**
		 * Inicializamos los botones
		 */
		bConfirmar = new JButton("CONFIRMAR");
		bConfirmar.setForeground(Color.WHITE);
		bConfirmar.setBackground(color2);
		bRecuperarContrasenia = new JButton("¿Has olvidado tu contraseña?");
		bRecuperarContrasenia.setForeground(Color.WHITE);
		bRecuperarContrasenia.setBackground(color2);
		bBorrar = new JButton("BORRAR");
		bBorrar.setForeground(Color.WHITE);
		bBorrar.setBackground(color2);
		/**
		 * Añadimos los diferentes componentes al panel Centro
		 */
		pCentro.add(lblNombre);
		pCentro.add(tfNombre);
		pCentro.add(lblContrasenia);
		pCentro.add(pfContrasenia);
		pCentro.setBackground(color1);
		pSur.setBackground(color1);
		pNorte.setBackground(color1);
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
		
		/**
		 * Eventos
		 */
		bConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = tfNombre.getText();
				String contrasenia = pfContrasenia.getText();
				/**
				 * Si el nombre y la contrasenia es admin entraremos como administrador(trabajador de la aerolinea), sino en la variable resultado del metodo de la base de datos sabemos si no existe el usuario, si existe el usuario pero la contrasenia está mal o si lo ha metido bien
				 */
				if(nombre.equals("admin") && contrasenia.equals("admin")) {
					ventana.dispose();
					new VentanaPrincipal();
					
				}else {
					int resultado = BaseDeDatos.comprobarUsuario(nombre, contrasenia);
					if(resultado == 0) {
						JOptionPane.showMessageDialog(null, "Tienes que registrarte","ACCESO DENEGADO",JOptionPane.ERROR_MESSAGE);
						lblNombre.setText("");
						lblContrasenia.setText("");
						String nuevonombre = JOptionPane.showInputDialog("Introduce tu nombre: ");
						while(BaseDeDatos.existeUsuario(nuevonombre)) {
							nuevonombre = JOptionPane.showInputDialog("Ese nombre ya está ocupado, introduce otro nombre: ");
						}
						String contraseniaUsuario = JOptionPane.showInputDialog("Introduce una contraseña: ");
						Pasajero p = new Pasajero(nuevonombre,contraseniaUsuario);
						BaseDeDatos.insertarPasajero(p);
					}else if (resultado == 1) {
						JOptionPane.showMessageDialog(null, "La contraseña es incorrecta","ACCESO DENEGADO",JOptionPane.ERROR_MESSAGE);
						lblNombre.setText("");
						lblContrasenia.setText("");
						ventana.dispose();
						
					}else {
						JOptionPane.showMessageDialog(null, "BIENVENIDO","ACCESO CONCEDIDO",JOptionPane.INFORMATION_MESSAGE);
						lblNombre.setText("");
						lblContrasenia.setText("");
						ventana.dispose();
						new VentanaUsuario();
					}	
				}
			}
		});
		
		bBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tfNombre.setText("");
				pfContrasenia.setText("");
				
			}
		});
		bRecuperarContrasenia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaRecuperarContrasenia();
				ventana.dispose();
			}
		});	
	}
}
