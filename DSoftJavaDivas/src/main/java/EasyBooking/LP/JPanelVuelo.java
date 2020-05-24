package EasyBooking.LP;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import EasyBooking.LD.Vuelo;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class JPanelVuelo extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPanelVuelo(ArrayList <Vuelo> Lista_vuelos) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setSize(1064,265);
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setLayout(null);
		System.out.println("aqui llega");
		String[] columnNames = { "Origen", "Destino", "Precio", ""};
		DefaultTableModel modelo = new DefaultTableModel(columnNames,0);
		System.out.println(modelo.getColumnCount());
		System.out.println(modelo.getRowCount());
		JTable tabla = new JTable (modelo);
		Object[] fila = new Object[Lista_vuelos.size()];
		add(tabla);
		JButton seleccionar = new JButton("Seleccionar");
	    for(int i=0;i<Lista_vuelos.size();i++){
	    	
	    
		fila[i]=Lista_vuelos.get(i).getOrigen().getNomAeropuerto();
		System.out.println(Lista_vuelos.get(i).getOrigen().getNomAeropuerto());
		System.out.println(fila[i].toString());
		fila[i]=Lista_vuelos.get(i).getDestino().getNomAeropuerto();
		fila[i]=Lista_vuelos.get(i).getPrecio();
		fila[i]= seleccionar;
	        modelo.addRow(fila);
	    }
	   
	    //CONTADORLISTA es para agregar n Filas, y esa n lo define un contador que va sumando 1, cada vez que 
	    //se agrega una nueva persona (o sea, cada vez que se presiona el jbutton)

	    
	    add(new JScrollPane(tabla));
	

	}
//		
//		JLabel lblHoraSalida = new JLabel("6:05");
//		lblHoraSalida.setFont(new Font("Tahoma", Font.PLAIN, 42));
//		lblHoraSalida.setBounds(280, 92, 181, 36);
//		add(lblHoraSalida);
//		
//		JLabel lblHoraLlegada = new JLabel("17:00");
//		lblHoraLlegada.setFont(new Font("Tahoma", Font.PLAIN, 42));
//		lblHoraLlegada.setBounds(411, 73, 201, 75);
//		add(lblHoraLlegada);
//		
//		JLabel lblLinea = new JLabel("-");
//		lblLinea.setFont(new Font("Tahoma", Font.PLAIN, 42));
//		lblLinea.setBounds(380, 96, 69, 20);
//		add(lblLinea);
//		
//		JPanel panelDeArriba = new JPanel();
//		panelDeArriba.setBorder(new LineBorder(new Color(0, 0, 0)));
//		panelDeArriba.setBackground(Color.WHITE);
//		panelDeArriba.setBounds(682, 0, 382, 265);
//		add(panelDeArriba);
//		panelDeArriba.setLayout(null);
//		
//		JLabel lblPrecio = new JLabel("802,20\u20AC");
//		lblPrecio.setBounds(120, 68, 156, 46);
//		panelDeArriba.add(lblPrecio);
//		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 38));
//		
//		JButton btnVerVuelos = new JButton("VER VUELO ");
//		btnVerVuelos.setBounds(120, 127, 156, 36);
//		panelDeArriba.add(btnVerVuelos);
//		btnVerVuelos.setBackground(new Color(0, 0, 128));
//		btnVerVuelos.setForeground(Color.WHITE);
//		btnVerVuelos.setFont(new Font("Tahoma", Font.BOLD, 18));
//		
//		JLabel lblOrigen = new JLabel("Madrid\r\n");
//		lblOrigen.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblOrigen.setBounds(290, 144, 69, 20);
//		add(lblOrigen);
//		
//		JLabel lblNewYork = new JLabel("New York");
//		lblNewYork.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblNewYork.setBounds(421, 144, 102, 20);
//		add(lblNewYork);
////		
////		JLabel lblLogoCompania = new JLabel("New label");
////		lblLogoCompania.setIcon(new ImageIcon(JPanelVuelo.class.getResource("/EasyBooking/Img/eDreams.jpg")));
////		lblLogoCompania.setBounds(15, 72, 181, 91);
////		add(lblLogoCompania);
//		
//		JLabel lblQuedanDisponibles = new JLabel("Quedan        disponibles");
//		lblQuedanDisponibles.setForeground(Color.GRAY);
//		lblQuedanDisponibles.setFont(new Font("Tahoma", Font.ITALIC, 16));
//		lblQuedanDisponibles.setBounds(30, 217, 201, 20);
//		add(lblQuedanDisponibles);
//		
//		JLabel lblNumeroDisponible = new JLabel("10");
//		lblNumeroDisponible.setForeground(Color.GRAY);
//		lblNumeroDisponible.setFont(new Font("Tahoma", Font.ITALIC, 16));
//		lblNumeroDisponible.setBounds(96, 217, 69, 20);
//		add(lblNumeroDisponible);

	
}
