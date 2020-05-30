package EasyBooking.LP;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DateTimeFormatter formatter;
	private Controller controller;
	private String origen;
	private String destino;
	private long precio;
	private LocalDateTime hora;
	private long asientos;
	private String emailJP;
	private int viajeros;
	/**
	 * Create the panel.
	 */
	public JPanelVuelo(Controller controller, String origen, String destino, long precio, long asientos, LocalDateTime hora, String email) {
		this.controller=controller;
		this.destino=destino;
		this.origen=origen;
		this.precio=precio;
		this.hora=hora;
		this.asientos=asientos;
		emailJP= email;
		InsertarJPanelVuelo();
		

	}
	
	public void InsertarJPanelVuelo()
	{
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setSize(1064, 265);
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setLayout(null);

		JPanel panelDeArriba = new JPanel();
		panelDeArriba.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDeArriba.setBackground(Color.WHITE);
		panelDeArriba.setBounds(682, 0, 382, 265);
		add(panelDeArriba);
		panelDeArriba.setLayout(null);

		String precioVuelo = Long.toString(precio);

		JLabel lblPrecio = new JLabel(precioVuelo + "€");
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
		lblDestino.setBounds(283, 89, 192, 52);
		add(lblDestino);

		JLabel lblFlecha = new JLabel("-");
		lblFlecha.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblFlecha.setBounds(277, 109, 69, 20);
		add(lblFlecha);

		JLabel lblQuedanDisponibles = new JLabel("Quedan        disponibles");
		lblQuedanDisponibles.setForeground(Color.GRAY);
		lblQuedanDisponibles.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblQuedanDisponibles.setBounds(30, 217, 201, 20);
		add(lblQuedanDisponibles);

		String numAsientos = Long.toString(asientos);

		JLabel lblNumeroDisponible = new JLabel(numAsientos);
		lblNumeroDisponible.setForeground(Color.GRAY);
		lblNumeroDisponible.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNumeroDisponible.setBounds(96, 217, 69, 20);
		add(lblNumeroDisponible);

		formatter = DateTimeFormatter.ISO_DATE_TIME;

		String formattedDateTime = hora.format(formatter);

		JLabel lblHoraSalida = new JLabel(formattedDateTime);
		lblHoraSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoraSalida.setBounds(233, 169, 140, 37);
		add(lblHoraSalida);
		this.setVisible(true);
		

		btnVerVuelos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String name = JOptionPane.showInputDialog("Introduzca numero de viajeros");
				viajeros = Integer.parseInt(name);
				Pago a = new Pago(controller, origen, destino, precio, formattedDateTime, emailJP, viajeros);
				a.setVisible(true);
			}
		});

	}
}
