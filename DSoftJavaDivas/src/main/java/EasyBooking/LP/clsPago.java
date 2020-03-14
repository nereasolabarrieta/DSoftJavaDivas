package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;

public class clsPago extends JFrame {

	private JPanel contentPane;
	private JTextField txtA;
	private JTextField txtDebeCoincidirCon;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtCvv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsPago frame = new clsPago();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public clsPago() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(clsPrincipal.class.getResource("/EasyBooking/Img/Avion.jpg")));
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
		ImageIcon fot = new ImageIcon(clsPrincipal.class.getResource("/EasyBooking/Img/logo.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
		lblLogo.setIcon(icono);
		
		JLabel lblcomoQuieresPagar = new JLabel("\u00BFCOMO QUIERES PAGAR?");
		lblcomoQuieresPagar.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblcomoQuieresPagar.setForeground(Color.WHITE);
		lblcomoQuieresPagar.setBounds(520, 43, 238, 72);
		pArriba.add(lblcomoQuieresPagar);
		
		JPanel pDerecha= new JPanel();
		pDerecha.setBackground(new Color(0, 0, 128));
		pDerecha.setBounds(1060, 155, 218, 529);
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
		
		JLabel lblHoraIda = new JLabel("15:40");
		lblHoraIda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHoraIda.setForeground(new Color(255, 255, 255));
		lblHoraIda.setBounds(28, 156, 69, 20);
		pDerecha.add(lblHoraIda);
		
		JLabel lblHoraVuelta = new JLabel("16:45");
		lblHoraVuelta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHoraVuelta.setForeground(new Color(255, 255, 255));
		lblHoraVuelta.setBounds(149, 156, 69, 20);
		pDerecha.add(lblHoraVuelta);
		
		JLabel lblPrecio = new JLabel("229,30");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrecio.setForeground(new Color(255, 255, 255));
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setBounds(66, 216, 85, 20);
		pDerecha.add(lblPrecio);
		
		JLabel lblBio = new JLabel("BIO");
		lblBio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBio.setForeground(Color.WHITE);
		lblBio.setBounds(28, 120, 69, 20);
		pDerecha.add(lblBio);
		
		JLabel lblBcn = new JLabel("BCN");
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
		
		JRadioButton rdbtnTarjetaCredito = new JRadioButton("Tarjeta de credito o debito");
		rdbtnTarjetaCredito.setBackground(new Color(255, 255, 255));
		rdbtnTarjetaCredito.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rdbtnTarjetaCredito.setBounds(79, 219, 263, 29);
		contentPane.add(rdbtnTarjetaCredito);
			
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
		
		JRadioButton rdbtnPaypal = new JRadioButton("Paypal");
		rdbtnPaypal.setBackground(new Color(255, 255, 255));
		rdbtnPaypal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rdbtnPaypal.setBounds(79, 502, 92, 29);
		contentPane.add(rdbtnPaypal);
		
		bttnPago.add(rdbtnPaypal);
		bttnPago.add(rdbtnTarjetaCredito);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPagar.setIcon(null);
		btnPagar.setSelectedIcon(null);
		btnPagar.setBackground(new Color(0, 0, 128));
		btnPagar.setForeground(Color.WHITE);
		btnPagar.setBounds(581, 604, 115, 29);
		contentPane.add(btnPagar);
	
		
		Choice choiceCaducidad = new Choice();
		choiceCaducidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		choiceCaducidad.setBounds(136, 459, 64, 25);
		choiceCaducidad.add("1");choiceCaducidad.add("2");choiceCaducidad.add("3");choiceCaducidad.add("4");
		choiceCaducidad.add("5");choiceCaducidad.add("6");choiceCaducidad.add("7");choiceCaducidad.add("8");
		choiceCaducidad.add("9");choiceCaducidad.add("9");choiceCaducidad.add("10");choiceCaducidad.add("11");
		choiceCaducidad.add("12");
		contentPane.add(choiceCaducidad);
		
		JLabel lblFotoTarjeta = new JLabel();
		lblFotoTarjeta.setIcon( new ImageIcon(clsPrincipal.class.getResource("/EasyBooking/Img/tarjeta.png"))  );
		lblFotoTarjeta.setBounds( 341, 203, 168, 60);
		contentPane.add(lblFotoTarjeta);
	
		
		JLabel lblFotoPaypal = new JLabel();
		lblFotoPaypal.setIcon( new ImageIcon(clsPrincipal.class.getResource("/EasyBooking/Img/PayPal.png")));
		lblFotoPaypal.setBounds( 171, 502, 98, 35);
		contentPane.add(lblFotoPaypal);
		
		Choice choiceCaducidadAnyo = new Choice();
		choiceCaducidadAnyo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		choiceCaducidadAnyo.setBounds(217, 459, 82, 26);
		choiceCaducidadAnyo.add("2020");choiceCaducidadAnyo.add("2021");choiceCaducidadAnyo.add("2022");
		choiceCaducidadAnyo.add("2023");choiceCaducidadAnyo.add("2024");choiceCaducidadAnyo.add("2025");
		choiceCaducidadAnyo.add("2026");choiceCaducidadAnyo.add("2027");choiceCaducidadAnyo.add("2028");	
		choiceCaducidadAnyo.add("2029");choiceCaducidadAnyo.add("2030");choiceCaducidadAnyo.add("2031");
		choiceCaducidadAnyo.add("2032");choiceCaducidadAnyo.add("2033");choiceCaducidadAnyo.add("2034");
		choiceCaducidadAnyo.add("2035");choiceCaducidadAnyo.add("2036");choiceCaducidadAnyo.add("2037");
		choiceCaducidadAnyo.add("2038");choiceCaducidadAnyo.add("2039");choiceCaducidadAnyo.add("2040");
		contentPane.add(choiceCaducidadAnyo);
		
		JLabel lblTodaTuInformacion = new JLabel("Toda tu informacion esta protegida y encriptada");
		lblTodaTuInformacion.setBounds(601, 203, 387, 64);
		contentPane.add(lblTodaTuInformacion);
		lblTodaTuInformacion.setForeground(Color.BLACK);
		
		JLabel lblCandado= new JLabel();
		lblCandado.setIcon( new ImageIcon(clsPrincipal.class.getResource("/EasyBooking/Img/candado.png")));
		lblCandado.setBounds(881, 219, 37, 35);
		contentPane.add(lblCandado);
				
		

	}
}
