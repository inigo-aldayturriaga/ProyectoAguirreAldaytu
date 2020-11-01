package gui;

import java.awt.BorderLayout;
import bd.BaseDeDatos;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		
		/**
		 * Eventos
		 */
		bConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = tfNombre.getText();
				String contrasenia = tfContrasenia.getText();
				/**
				 * Si el nombre y la contrasenia es admin entraremos como administrador, sino en la variable resultado del metodo de la base de datos sabemos si no existe el usuario, si existe el usuario pero la contrasenia está mal o si lo ha metido bien
				 */
				if(nombre.equals("admin") && contrasenia.equals("admin")) {
					new VentanaAdmin();
					ventana.dispose();
				}else {
					int resultado = BaseDeDatos.comprobarUsuario(nombre, contrasenia);
					if(resultado == 0) {
						JOptionPane.showMessageDialog(null, "Tienes que registrarte","ACCESO DENEGADO",JOptionPane.ERROR_MESSAGE);
						String nombreUsuario = JOptionPane.showInputDialog("Introduce tu nombre: ");
						while(BaseDeDatos.existeUsuario(nombreUsuario)) {
							nombreUsuario = JOptionPane.showInputDialog("Ese nombre ya está ocupado, introduce otro: ");
						}
						String contraseniaUsuario = JOptionPane.showInputDialog("Introduce una contraseña: ");
						BaseDeDatos.insertarUsuario(nombreUsuario, contraseniaUsuario);
					}else if (resultado == 1) {
						JOptionPane.showMessageDialog(null, "La contraseña es incorrecta","ACCESO DENEGADO",JOptionPane.ERROR_MESSAGE);
						ventana.dispose();
						
					}else {
						JOptionPane.showMessageDialog(null, "BIENVENIDO","ACCESO PERMITIDO",JOptionPane.INFORMATION_MESSAGE);
						ventana.dispose();
					}	
				}
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
	}
}
