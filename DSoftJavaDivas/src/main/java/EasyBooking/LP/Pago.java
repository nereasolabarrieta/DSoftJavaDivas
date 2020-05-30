package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;

public class Pago extends JFrame {

	private JPanel contentPane;
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
	

	/**
	 * Create the frame.
	 * 
	 * @param controller
	 */
	public Pago(Controller controller, String origen, String destino, long precio, String Date, String email) {
		this.controller = controller;
		this.destino=destino;
		this.origen=origen;
		this.precio=precio;
		this.Date=Date;
		this.email=email;
		
		initComponents();
		this.setVisible(true);

	}

	public void initComponents() {
		
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

		JLabel lblLogo = new JLabel();
		lblLogo.setBounds(0, 0, 185, 64);
		pArriba.add(lblLogo);


		JLabel lblcomoQuieresPagar = new JLabel("\u00BFCOMO QUIERES PAGAR?");
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

		JLabel lblBiobcn = new JLabel("   ________    ");
		lblBiobcn.setForeground(new Color(255, 255, 255));
		lblBiobcn.setBounds(67, 100, 130, 49);
		pDerecha.add(lblBiobcn);

		JLabel lblFecha = new JLabel(Date);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setBounds(38, 165, 218, 20);
		pDerecha.add(lblFecha);
		
		String precioVuelo = Long.toString(precio);
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

		ButtonGroup bttnPago = new ButtonGroup();

//		JRadioButton rdbtnTarjetaCredito = new JRadioButton("Tarjeta de credito o debito");
//		rdbtnTarjetaCredito.setBackground(new Color(255, 255, 255));
//		rdbtnTarjetaCredito.setFont(new Font("Tahoma", Font.PLAIN, 19));
//		rdbtnTarjetaCredito.setBounds(79, 219, 263, 29);
//		contentPane.add(rdbtnTarjetaCredito);
		JLabel lblTarjetaCredito = new JLabel("Tarjeta de credito o debito");
		lblTarjetaCredito.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTarjetaCredito.setBounds(79, 219, 263, 29);
		contentPane.add(lblTarjetaCredito);
		
		JLabel lblNmeroDeTarjeta = new JLabel("Numero de tarjeta");
		lblNmeroDeTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmeroDeTarjeta.setBounds(136, 267, 206, 20);
		contentPane.add(lblNmeroDeTarjeta);

		txtA = new JTextField();
		txtA.setForeground(Color.BLACK);
		txtA.setToolTipText("");
		txtA.setBounds(136, 303, 255, 26);
		contentPane.add(txtA);
		txtA.setColumns(10);

		JLabel lblNombreDelTitular = new JLabel("Nombre del titular de la tarjeta");
		lblNombreDelTitular.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreDelTitular.setBounds(136, 345, 349, 20);
		contentPane.add(lblNombreDelTitular);

		txtDebeCoincidirCon = new JTextField();
		txtDebeCoincidirCon.setForeground(Color.BLACK);
		txtDebeCoincidirCon.setBounds(136, 381, 255, 26);
		contentPane.add(txtDebeCoincidirCon);
		txtDebeCoincidirCon.setColumns(10);

		JLabel lblFechaDeCaducidad = new JLabel("Fecha de caducidad");
		lblFechaDeCaducidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaDeCaducidad.setBounds(136, 423, 162, 20);
		contentPane.add(lblFechaDeCaducidad);

		JLabel lblCdigoDeSeguridad = new JLabel("Codigo de seguridad");
		lblCdigoDeSeguridad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCdigoDeSeguridad.setBounds(316, 423, 206, 20);
		contentPane.add(lblCdigoDeSeguridad);

		txtCvv = new JTextField();
		txtCvv.setForeground(Color.BLACK);
		txtCvv.setBounds(317, 459, 74, 26);
		contentPane.add(txtCvv);
		txtCvv.setColumns(10);

//		JRadioButton rdbtnPaypal = new JRadioButton("Paypal");
//		rdbtnPaypal.setBackground(new Color(255, 255, 255));
//		rdbtnPaypal.setFont(new Font("Tahoma", Font.PLAIN, 19));
//		rdbtnPaypal.setBounds(79, 502, 92, 29);
//		contentPane.add(rdbtnPaypal);
//
//		bttnPago.add(rdbtnPaypal);
//		bttnPago.add(rdbtnTarjetaCredito);
		choiceCaducidad = new Choice();
		choiceCaducidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		choiceCaducidad.setBounds(136, 459, 64, 25);
		choiceCaducidad.add("1");
		choiceCaducidad.add("2");
		choiceCaducidad.add("3");
		choiceCaducidad.add("4");
		choiceCaducidad.add("5");
		choiceCaducidad.add("6");
		choiceCaducidad.add("7");
		choiceCaducidad.add("8");
		choiceCaducidad.add("9");
		choiceCaducidad.add("9");
		choiceCaducidad.add("10");
		choiceCaducidad.add("11");
		choiceCaducidad.add("12");
		contentPane.add(choiceCaducidad);

//		JLabel lblFotoTarjeta = new JLabel();
//		lblFotoTarjeta.setIcon(new ImageIcon(Principal.class.getResource("/EasyBooking/Img/tarjeta.png")));
//		lblFotoTarjeta.setBounds(341, 203, 168, 60);
//		contentPane.add(lblFotoTarjeta);

//		JLabel lblFotoPaypal = new JLabel();
//		lblFotoPaypal.setIcon(new ImageIcon(Principal.class.getResource("/EasyBooking/Img/PayPal.png")));
//		lblFotoPaypal.setBounds(171, 502, 98, 35);
//		contentPane.add(lblFotoPaypal);

		choiceCaducidadAnyo = new Choice();
		choiceCaducidadAnyo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		choiceCaducidadAnyo.setBounds(217, 459, 82, 26);
		choiceCaducidadAnyo.add("2020");
		choiceCaducidadAnyo.add("2021");
		choiceCaducidadAnyo.add("2022");
		choiceCaducidadAnyo.add("2023");
		choiceCaducidadAnyo.add("2024");
		choiceCaducidadAnyo.add("2025");
		choiceCaducidadAnyo.add("2026");
		choiceCaducidadAnyo.add("2027");
		choiceCaducidadAnyo.add("2028");
		choiceCaducidadAnyo.add("2029");
		choiceCaducidadAnyo.add("2030");
		choiceCaducidadAnyo.add("2031");
		choiceCaducidadAnyo.add("2032");
		choiceCaducidadAnyo.add("2033");
		choiceCaducidadAnyo.add("2034");
		choiceCaducidadAnyo.add("2035");
		choiceCaducidadAnyo.add("2036");
		choiceCaducidadAnyo.add("2037");
		choiceCaducidadAnyo.add("2038");
		choiceCaducidadAnyo.add("2039");
		choiceCaducidadAnyo.add("2040");
		contentPane.add(choiceCaducidadAnyo);

		JLabel lblTodaTuInformacion = new JLabel("Toda tu informacion esta protegida y encriptada");
		lblTodaTuInformacion.setBounds(601, 203, 387, 64);
		contentPane.add(lblTodaTuInformacion);
		lblTodaTuInformacion.setForeground(Color.BLACK);
		
		
		JLabel lblConcepto = new JLabel("Concepto");
		lblConcepto.setBounds(601, 267, 69, 20);
		contentPane.add(lblConcepto);
		
		textFieldConcepto = new JTextField();
		textFieldConcepto.setBounds(601, 303, 341, 104);
		textFieldConcepto.setColumns(10);
		

//		JLabel lblCandado = new JLabel();
//		lblCandado.setIcon(new ImageIcon(Principal.class.getResource("/EasyBooking/Img/candado.png")));
//		lblCandado.setBounds(881, 219, 37, 35);
//		contentPane.add(lblCandado);

		JButton btnPagar = new JButton("Pagar");
		btnPagar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPagar.setIcon(null);
		btnPagar.setSelectedIcon(null);
		btnPagar.setBackground(new Color(0, 0, 128));
		btnPagar.setForeground(Color.WHITE);
		btnPagar.setBounds(581, 604, 115, 29);
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
		contentPane.add(btnPagar);
		
		textField = new JTextField();
		textField.setBounds(601, 303, 341, 26);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
