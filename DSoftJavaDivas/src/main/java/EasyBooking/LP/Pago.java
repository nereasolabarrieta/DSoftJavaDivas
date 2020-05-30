package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.Controller;
import EasyBooking.LD.Reserva;

import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import java.awt.Choice;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;

public class Pago extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel PscrollPane;
	private JTextField txtA;
	private JTextField txtDebeCoincidirCon;
	private JTextField txtCvv;
	private Choice choiceCaducidadAnyo;
	private Choice choiceCaducidad;
	private Controller controller;
	private String origen;
	private String destino;
	private String email;
	private long precio;
	private String Date;
	private JTextField textFieldConcepto;
	private JTextField textField;
	private JButton btnCerrarSesion;
	private int numViajeros;
	private JPanel pViajeros;
	

	/**
	 * Create the frame.
	 * 
	 * @param controller
	 */
	public Pago(Controller controller, String origen, String destino, long precio, String Date, String email, int numViajeros) {
		this.controller = controller;
		this.destino=destino;
		this.origen=origen;
		this.precio=precio;
		this.Date=Date;
		this.email=email;
		this.numViajeros = numViajeros;
		initComponents();
		this.setVisible(true);

	}

	public void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/EasyBooking/Img/Avion.jpg"));
		setFont(new Font("Franklin Gothic Medium", Font.BOLD, 12));
		setTitle("EasyBooking");
		setForeground(Color.BLACK);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 740);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		JPanel pArriba = new JPanel();
		pArriba.setBackground(new Color(0, 0, 128));
		pArriba.setBounds(0, 0, 1278, 159);
		contentPane.add(pArriba);
		pArriba.setLayout(null);

		ImageIcon fot = new ImageIcon("src/main/java/EasyBooking/Img/logo.png");
		JLabel lblLogo = new JLabel();
		lblLogo.setBounds(15, 16, 202, 73);
		Icon icono = new ImageIcon(
				fot.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
		lblLogo.setIcon(icono);
		pArriba.add(lblLogo);

		JLabel lblcomoQuieresPagar = new JLabel("PAGO");
		lblcomoQuieresPagar.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblcomoQuieresPagar.setForeground(Color.WHITE);
		lblcomoQuieresPagar.setBounds(520, 43, 238, 72);
		pArriba.add(lblcomoQuieresPagar);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCerrarSesion.setForeground(Color.BLACK);
		btnCerrarSesion.setBackground(Color.WHITE);
		btnCerrarSesion.setBounds(1058, 16, 150, 29);
		pArriba.add(btnCerrarSesion);

		JPanel pDerecha = new JPanel();
		pDerecha.setBackground(new Color(0, 0, 128));
		pDerecha.setBounds(990, 155, 288, 529);
		contentPane.add(pDerecha);
		pDerecha.setLayout(null);

		JLabel lblIda = new JLabel("Ida");
		lblIda.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIda.setForeground(new Color(255, 255, 255));
		lblIda.setBounds(28, 84, 69, 20);
		pDerecha.add(lblIda);

		JLabel lblBiobcn = new JLabel("     _____    ");
		lblBiobcn.setForeground(new Color(255, 255, 255));
		lblBiobcn.setBounds(67, 100, 130, 49);
		pDerecha.add(lblBiobcn);

		JLabel lblFecha = new JLabel(Date);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setBounds(38, 165, 218, 20);
		pDerecha.add(lblFecha);
		
		long total = precio * numViajeros;
		String precioVuelo = Long.toString(total);
		
		
		JLabel lblPrecio = new JLabel(precioVuelo + "€");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrecio.setForeground(new Color(255, 255, 255));
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setBounds(66, 216, 85, 20);
		pDerecha.add(lblPrecio);

		JLabel lblBio = new JLabel(origen);
		lblBio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBio.setForeground(Color.WHITE);
		lblBio.setBounds(28, 120, 69, 20);
		pDerecha.add(lblBio);

		JLabel lblBcn = new JLabel(destino);
		lblBcn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBcn.setForeground(Color.WHITE);
		lblBcn.setBounds(149, 120, 69, 20);
		pDerecha.add(lblBcn);

		JLabel lblDetalles = new JLabel("DETALLES");
		lblDetalles.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDetalles.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetalles.setForeground(Color.WHITE);
		lblDetalles.setBounds(15, 16, 188, 44);
		pDerecha.add(lblDetalles);

		JLabel label = new JLabel("===============================");
		label.setForeground(new Color(0, 153, 255));
		label.setBounds(0, 185, 273, 20);
		pDerecha.add(label);
	
		
		JPanel pUsuario = new JPanel();
		pUsuario.setBackground(Color.WHITE);
		pUsuario.setBounds(0, 159, 990, 159);
		contentPane.add(pUsuario);
		pUsuario.setLayout(null);
		
		JLabel lblNmeroDeTarjeta = new JLabel("Numero de tarjeta");
		lblNmeroDeTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmeroDeTarjeta.setBounds(50, 30, 256, 20);
		pUsuario.add(lblNmeroDeTarjeta);

		txtA = new JTextField();
		txtA.setForeground(Color.BLACK);
		txtA.setToolTipText("");
		txtA.setBounds(300, 30, 206, 20);
		pUsuario.add(txtA);

		JLabel lblNombreDelTitular = new JLabel("Nombre del titular de la tarjeta");
		lblNombreDelTitular.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreDelTitular.setBounds(50, 80, 256, 20);
		pUsuario.add(lblNombreDelTitular);

		txtDebeCoincidirCon = new JTextField();
		txtDebeCoincidirCon.setForeground(Color.BLACK);
		txtDebeCoincidirCon.setBounds(300, 80, 206, 20);
		pUsuario.add(txtDebeCoincidirCon);

//		JLabel lblFechaDeCaducidad = new JLabel("Fecha de caducidad");
//		lblFechaDeCaducidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblFechaDeCaducidad.setBounds(50, 130, 162, 20);
//		pUsuario.add(lblFechaDeCaducidad);

//		JLabel lblCdigoDeSeguridad = new JLabel("Codigo de seguridad");
//		lblCdigoDeSeguridad.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblCdigoDeSeguridad.setBounds(300, 130, 206, 20);
//		pUsuario.add(lblCdigoDeSeguridad);
//
//		txtCvv = new JTextField();
//		txtCvv.setForeground(Color.BLACK);
//		txtCvv.setBounds(450, 130, 206, 20);
//		pUsuario.add(txtCvv);
		

//		choiceCaducidad = new Choice();
//		choiceCaducidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		choiceCaducidad.setBounds(200, 459, 64, 25);
//		choiceCaducidad.add("1");
//		choiceCaducidad.add("2");
//		choiceCaducidad.add("3");
//		choiceCaducidad.add("4");
//		choiceCaducidad.add("5");
//		choiceCaducidad.add("6");
//		choiceCaducidad.add("7");
//		choiceCaducidad.add("8");
//		choiceCaducidad.add("9");
//		choiceCaducidad.add("9");
//		choiceCaducidad.add("10");
//		choiceCaducidad.add("11");
//		choiceCaducidad.add("12");
//		pUsuario.add(choiceCaducidad);
//
//		choiceCaducidadAnyo = new Choice();
//		choiceCaducidadAnyo.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		choiceCaducidadAnyo.setBounds(217, 459, 82, 26);
//		choiceCaducidadAnyo.add("2020");
//		choiceCaducidadAnyo.add("2021");
//		choiceCaducidadAnyo.add("2022");
//		choiceCaducidadAnyo.add("2023");
//		choiceCaducidadAnyo.add("2024");
//		choiceCaducidadAnyo.add("2025");
//		choiceCaducidadAnyo.add("2026");
//		choiceCaducidadAnyo.add("2027");
//		choiceCaducidadAnyo.add("2028");
//		choiceCaducidadAnyo.add("2029");
//		choiceCaducidadAnyo.add("2030");
//		choiceCaducidadAnyo.add("2031");
//		choiceCaducidadAnyo.add("2032");
//		choiceCaducidadAnyo.add("2033");
//		choiceCaducidadAnyo.add("2034");
//		choiceCaducidadAnyo.add("2035");
//		choiceCaducidadAnyo.add("2036");
//		choiceCaducidadAnyo.add("2037");
//		choiceCaducidadAnyo.add("2038");
//		choiceCaducidadAnyo.add("2039");
//		choiceCaducidadAnyo.add("2040");
//		pUsuario.add(choiceCaducidadAnyo);

		
		
		JLabel lblConcepto = new JLabel("Concepto");
		lblConcepto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConcepto.setBounds(50, 130, 162, 20);
		pUsuario.add(lblConcepto);
		
		textFieldConcepto = new JTextField();
		textFieldConcepto.setBounds(300, 130, 256, 20);
		pUsuario.add(textFieldConcepto);

		JButton btnPagar = new JButton("Pagar");
		btnPagar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPagar.setBackground(new Color(0, 0, 128));
		btnPagar.setForeground(Color.WHITE);
		btnPagar.setBounds(1100, 604, 115, 29);
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numTarjeta = txtA.getText();
			
				String nomTitular = txtDebeCoincidirCon.getText();
			
				String concepto = textField.getText();
				String codigoS= txtCvv.getText();
	

				if (numTarjeta == null || nomTitular == null || concepto == null || codigoS==null) {
					JOptionPane.showMessageDialog(null, "Rellene todos los campos");
				} else {
					
					try {
					
						controller.Pagar(precio, email, concepto);
					

					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Buscar a = new Buscar(controller, email);
					a.setVisible(true);
				}
			}
		});
		pDerecha.add(btnPagar);
		pViajeros = new JPanel();
		pViajeros.setBackground(Color.WHITE);
		pViajeros.setBounds(0, 318, 990, 422);
		contentPane.add(pViajeros);
		pViajeros.setLayout(null);
	
		PscrollPane = new JPanel();
		scrollPane = new JScrollPane();
		pViajeros.add(scrollPane);
		scrollPane.getViewport().setView(PscrollPane);
		GridBagLayout gbl_PscrollPane = new GridBagLayout();
		gbl_PscrollPane.columnWidths = new int[] { 0 };
		gbl_PscrollPane.rowHeights = new int[] { 0 };
		gbl_PscrollPane.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_PscrollPane.rowWeights = new double[] { Double.MIN_VALUE };
		PscrollPane.setLayout(gbl_PscrollPane);
		
		
		InsertarCamposViajeros();
		PscrollPane.repaint();
		scrollPane.repaint();
		
		
	}
	
	public void InsertarCamposViajeros() {
		int x = 0;
		int y = 50;

		for (int i = 0; i < numViajeros; i++) {
			
			

			JLabel lblViajero = new JLabel("DATOS VIAJERO " + i);
			lblViajero.setBounds(120, 68, 156, 46);
			pViajeros.add(lblViajero);
			lblViajero.setFont(new Font("Tahoma", Font.BOLD, 26));

			JLabel lblOrigen = new JLabel("Nombre:");
			lblOrigen.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblOrigen.setBounds(165, 93, 112, 44);
			pViajeros.add(lblOrigen);

			JLabel lblDestino = new JLabel("DNI:");
			lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDestino.setBounds(165, 200, 172, 52);
			pViajeros.add(lblDestino);

			JTextField txtNom = new JTextField();
			txtNom.setFont(new Font("Tahoma", Font.PLAIN, 30));
			txtNom.setBounds(300, 93, 112, 44);
			pViajeros.add(txtNom);
			
			JTextField txtDni = new JTextField();
			txtDni.setFont(new Font("Tahoma", Font.PLAIN, 30));
			txtDni.setBounds(300, 200, 112, 44);
			pViajeros.add(txtDni);
			GridBagConstraints gbc_lblFoto = new GridBagConstraints();
			gbc_lblFoto.ipadx = 990;
			gbc_lblFoto.ipady = 422;
			gbc_lblFoto.gridx = x;
			gbc_lblFoto.gridy = y;
			PscrollPane.add(pViajeros, gbc_lblFoto);

			y = y + 100;
		}
		repaint();
	}
}
