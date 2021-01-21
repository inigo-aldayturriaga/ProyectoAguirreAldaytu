package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel{
	private String fondo;
	
	/**
	 * Contructor y dimensiones del panel
	 * @param fondo
	 */
	
	public PanelFondo(String fondo){
		this.setSize(450, 300);
		this.setLayout(new BorderLayout());
		this.fondo = fondo;
	}
	/**
	 * Con este metodo hacemos que las dimensiones del panel al que le vayamos a meter el fondo sean iguales a nuestro Panel
	 */
	public void paintComponent(Graphics g){
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(fondo);
		g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, this);
		setOpaque(false);//Para que funcione tendremos que ponerlo en todos los paneles de la ventana a la que le vayamos a poner una foto de fondo.
		super.paintComponent(g);
		
	}
}
