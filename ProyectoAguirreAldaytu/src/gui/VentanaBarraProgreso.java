package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;



public class VentanaBarraProgreso extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Creamos la barra de progreso, un boton y una etiqueta y declaramos i como 0
	JProgressBar pb;
	JButton btn;
	JLabel creado;
	int i=0;
	//Definimos como va a ser la ventana y sus caracteristicas
	public VentanaBarraProgreso(String persona) {
		setUndecorated(true);
		//altura y anchura de la ventana
		int altura =  200;
		int anchura = 400;
		setSize(anchura, altura);
		//dimensiones de la ventana y en que lugar esta localizado
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( screenSize.width/2 - anchura/2, screenSize.height/2 - altura/2);  
		//se cerrara la ventana al salir
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		//creamos el panel donde estara el boton, la etiqueta...
		JPanel pCentro = new JPanel();
		add(pCentro);
		//Definimos las caracteristicas de la etiqueta, el boton, el panel...
		pCentro.setLayout(null);
		JLabel l = new JLabel("Creando "+persona+"...");
		l.setBounds(110, 10, 200, 20);
		pCentro.add(l);
		l.setFont(new Font("Arial",Font.PLAIN,20));
		btn =new JButton("Aceptar");
		pCentro.add(btn);
		btn.setEnabled(false);
		btn.setBounds(314, 175, 80, 20);
		pb = new JProgressBar(0,2000);
		pCentro.add(pb);
		pb.setStringPainted(true);
		pb.setBounds(100, 90, 200, 20);
		pb.setValue(0);
		creado = new JLabel("Creado!");
		creado.setFont(new Font("Arial",Font.PLAIN,20));
		creado.setBounds(169, 125, 80, 20);
		pCentro.add(creado);
		creado.setVisible(false);
		setVisible(true);

		//accion que hace el boton que hemos creado
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});	
		
		//funcionalidad de la ventana
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				Thread t = new Thread() { //hacemos un hilo
					public void run() {
						while(i<=2000){    //mientras que la barra de progreso sea menor que 2000...
							pb.setValue(i); //declramos el valor de i (0)
							i=i+20;  //vamos sumando de 20 en 20 hasta llegar a 2000
							repaint();
							try{Thread.sleep(25);}catch(Exception ex){} //ritmo de la barra
						}
						
						btn.setEnabled(true);
						creado.setVisible(true);
					}

				};
				t.start(); //empezamos el hilo

			}

		});

	}



}