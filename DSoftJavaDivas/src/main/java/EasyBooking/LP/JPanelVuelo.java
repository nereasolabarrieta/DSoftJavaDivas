package EasyBooking.LP;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import EasyBooking.LD.Vuelo;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class JPanelVuelo extends JPanel {
	private Controller controller;
	private String precio;
	
	/**
	 * Create the panel.
	 */
	public JPanelVuelo(Controller controller, String origen, String destino, Date objDate, long precio) {
		
		this.controller = controller;
		this.precio = String.valueOf(precio);
		
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setSize(1064,265);
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setLayout(null);

		JPanel panelDeArriba = new JPanel();
		panelDeArriba.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDeArriba.setBackground(Color.WHITE);
		panelDeArriba.setBounds(682, 0, 382, 265);
		add(panelDeArriba);
		panelDeArriba.setLayout(null);

		JLabel lblPrecio = new JLabel(this.precio + "€");
		lblPrecio.setBounds(120, 68, 156, 46);
		panelDeArriba.add(lblPrecio);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 38));

		JButton btnVerVuelos = new JButton("VER VUELO ");
		btnVerVuelos.setBounds(120, 127, 156, 36);
		panelDeArriba.add(btnVerVuelos);
		btnVerVuelos.setBackground(new Color(0, 0, 128));
		btnVerVuelos.setForeground(Color.WHITE);
		btnVerVuelos.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel lblOrigen = new JLabel(origen);
		lblOrigen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblOrigen.setBounds(165, 93, 112, 44);
		add(lblOrigen);

		JLabel lblDestino = new JLabel(destino);
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDestino.setBounds(303, 89, 172, 52);
		add(lblDestino);
		
		JLabel lblFlecha = new JLabel("-");
		lblFlecha.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblFlecha.setBounds(273, 109, 69, 20);
		add(lblFlecha);
		
//		JLabel lblHoraSalida = new JLabel("16:00");
//		lblHoraSalida.setFont(new Font("Tahoma", Font.PLAIN, 37));
//		lblHoraSalida.setBounds(233, 169, 119, 37);
//		add(lblHoraSalida);
		this.setVisible(true);
		

	

	}
	}
