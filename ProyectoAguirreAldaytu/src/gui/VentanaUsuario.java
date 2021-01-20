package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.lang.*;


import bd.BaseDeDatos;
import datos.DeustoAir;
import datos.Vuelo;

public class VentanaUsuario extends JFrame {
	private JTable tablaVuelos;
	private DefaultTableModel modelo;
	private ArrayList<Vuelo> listaVuelos = new ArrayList<Vuelo>();
	private JPanel pCentro,pSur,pAnimacion;
	private JScrollPane sc;
	private JLabel lblAvion1,lblAvion2,lblBoom;
	private int anchoVentana,xinicial,xfinal;
	private GridLayout gridlayout;
	
	private JButton btnGenerarFichero;
	private int filaSeleccionada;
	
	public VentanaUsuario () {
		super();
		setSize(800, 600);
		pCentro = new JPanel();
		gridlayout = new GridLayout(2,1);
		pCentro.setLayout(gridlayout);
		pSur = new JPanel();
		pAnimacion = new JPanel();
		
		//TABLA VUELOS
		DefaultTableModel modeloVuelos = new DefaultTableModel();
		Object[] cabeceras = {"Hora Salida","Vuelo","Destino","Hora Llegada","Puerta","Observacion"};
		modeloVuelos.setColumnIdentifiers(cabeceras);
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		for (Vuelo v : DeustoAir.getVuelos()) {
			String[] fila = {sdf.format(v.getHoraSalida()),v.getIdAvion(),v.getDestino(),sdf.format(v.getHoraLlegada()),String.valueOf(v.getPuerta()),v.getObservacion()};
			modeloVuelos.addRow(fila);
		}
		ImageIcon imBoom = new ImageIcon("imagenes/boom.jpg");
		lblBoom = new JLabel(imBoom);
		lblBoom.setBounds(84, 31, 267, 144);
		lblBoom.setVisible(false);
		
		
		
		ImageIcon im1 =  new ImageIcon("imagenes/avionDerecha.jpg");
		lblAvion1 = new JLabel(im1);
		lblAvion1.setBounds(20, 41, 86, 83);
		
		
		ImageIcon im2 =  new ImageIcon("imagenes/avionIzquierda.jpg");
		lblAvion2 = new JLabel(im2);
		lblAvion2.setBounds(300, 41, 77, 83);
		
		

		
		tablaVuelos = new JTable (modeloVuelos);
		sc = new JScrollPane(tablaVuelos);
		pCentro.add(sc);
		
		pAnimacion.add(lblBoom);
		pAnimacion.add(lblAvion1);
		pAnimacion.add(lblAvion2);
		
		pCentro.add(pAnimacion);
		
		btnGenerarFichero = new JButton("IMPRIMIR DATOS VUELO");
		pSur.add(btnGenerarFichero);
		getContentPane().add(pSur,BorderLayout.SOUTH);
		getContentPane().add(pCentro,BorderLayout.CENTER);
		
		
		tablaVuelos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				filaSeleccionada = tablaVuelos.getSelectedRow();
			}
		});
		tablaVuelos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				Date d;
				try {
					d = (Date) sdf.parse((String) modeloVuelos.getValueAt(row, 0));
					if(d.getTime()-System.currentTimeMillis()< 3600000) {
						c.setForeground(Color.RED);
					}else {
						c.setForeground(Color.BLACK);
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/**
				 * Si queda menos de una hora para el vuelo se pone en rojo
				 */
				return c;
			}
		});
		 
		
		btnGenerarFichero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(filaSeleccionada!=-1) {
						PrintWriter pw = new PrintWriter("InformacionVuelo.txt");
						String hs = (String) modeloVuelos.getValueAt(filaSeleccionada, 0);
						String v = (String) modeloVuelos.getValueAt(filaSeleccionada, 1);
						String d = (String) modeloVuelos.getValueAt(filaSeleccionada, 2);
						String hl = (String) modeloVuelos.getValueAt(filaSeleccionada, 3);
						String p = (String) modeloVuelos.getValueAt(filaSeleccionada, 4);
						String o = (String) modeloVuelos.getValueAt(filaSeleccionada, 5);
						pw.println("HORA DE SALIDA: "+hs);
						pw.println("VUELO: "+v);
						pw.println("DESTINO: "+d);
						pw.println("HORA DE LLEGADA: "+hl);
						pw.println("PUERTA: "+p);
						pw.println("OBSERVACIONES: "+o);
						pw.flush();
						pw.close();
						JOptionPane.showMessageDialog(null, "Se ha generado la información correctamente.");
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Runnable r =new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int x1 = lblAvion1.getX();
				int y1 = lblAvion1.getY();
				
				int x2 = lblAvion2.getX();
				int y2 = lblAvion2.getY();
				
				while(x1+lblAvion1.getWidth() < x2) {
					x1 = x1 + 1;
					lblAvion1.setLocation(x1, y1);
					x2 = x2 - 1;
					lblAvion2.setLocation(x2, y2);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				lblAvion1.setVisible(false);
				lblAvion2.setVisible(false);
				for(int i=0;i<3;i++) {
					lblBoom.setVisible(true);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					lblBoom.setVisible(false);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		Thread t = new Thread(r);
		t.start();
		setVisible(true);
	}

}
