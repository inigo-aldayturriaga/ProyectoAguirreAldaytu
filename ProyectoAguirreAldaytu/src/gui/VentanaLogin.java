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
	public JLabel lblIdLog,lblContrasenia;
	public JTextField tfIdLog,tfContrasenia;
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
		lblIdLog = new JLabel("Nombre: ");
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
		tfIdLog = new JTextField(5);
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
		pCentro.add(lblIdLog);
		pCentro.add(tfIdLog);
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
				String idLog = tfIdLog.getText();
				String contrasenia = tfContrasenia.getText();
				/**
				 * Si el nombre y la contrasenia es admin entraremos como administrador, sino en la variable resultado del metodo de la base de datos sabemos si no existe el usuario, si existe el usuario pero la contrasenia está mal o si lo ha metido bien
				 */
				if(idLog.equals("admin") && contrasenia.equals("admin")) {
					new VentanaAdmin();
					ventana.dispose();
					new VentanaPrincipal();
					
				}else {
					int resultado = BaseDeDatos.comprobarUsuario(idLog, contrasenia);
					if(resultado == 0) {
						JOptionPane.showMessageDialog(null, "Tienes que registrarte","ACCESO DENEGADO",JOptionPane.ERROR_MESSAGE);
						lblIdLog.setText("");
						lblContrasenia.setText("");
						String idLogin = JOptionPane.showInputDialog("Introduce tu ID: ");
						while(BaseDeDatos.existeUsuario(idLogin)) {
							idLogin = JOptionPane.showInputDialog("Ese nombre ya está ocupado, introduce otro nombre: ");
						}
						String contraseniaUsuario = JOptionPane.showInputDialog("Introduce una contraseña: ");
						BaseDeDatos.insertarUsuario(idLogin, contraseniaUsuario);
					}else if (resultado == 1) {
						JOptionPane.showMessageDialog(null, "La contraseña es incorrecta","ACCESO DENEGADO",JOptionPane.ERROR_MESSAGE);
						lblIdLog.setText("");
						lblContrasenia.setText("");
						ventana.dispose();
						
					}else {
						JOptionPane.showMessageDialog(null, "BIENVENIDO","ACCESO CONCEDIDO",JOptionPane.INFORMATION_MESSAGE);
						lblIdLog.setText("");
						lblContrasenia.setText("");
						ventana.dispose();
						new VentanaPrincipal();
					}	
				}
			}
		});
		
		bBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tfIdLog.setText("");
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
