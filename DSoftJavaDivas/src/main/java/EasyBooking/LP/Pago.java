package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.Controller;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Viajero;
import EasyBooking.LD.Vuelo;

public class Pago extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel PscrollPane;
	private JTextField txtA;
	private JTextField txtDebeCoincidirCon;

	private Controller controller;
	private String origen;
	private String destino;
	private String email;
	private String codVuelo;
	private long precio;
	private long total;
	private JTextField textFieldConcepto;
	private JButton btnCerrarSesion;
	private int numViajeros;
	private JTextField arrayNombres[];
	private JTextField arrayDnis[];
	private Set<Viajero> viajeros;
	private long asientos;
	private Vuelo v;
	/**
	 * Create the frame.
	 * 
	 * @param controller
	 */
	public Pago(Controller controller, Vuelo v , String emailJP, int viajeros) {
		this.controller = controller;
		this.destino=v.getDestino().getNomAeropuerto();
		this.origen=v.getOrigen().getNomAeropuerto();
		long p= v.getPrecio()*viajeros;
		this.precio=p;
		this.email=emailJP;
		this.numViajeros = viajeros;
		System.out.println(numViajeros);
		this.v=v;
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

		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		String formattedDateTime = v.getHora_salida().format(formatter);
		JLabel lblFecha = new JLabel(formattedDateTime);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setBounds(38, 165, 218, 20);
		pDerecha.add(lblFecha);
		
		JLabel lblPrecio = new JLabel(precio + "€");
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

		JLabel lblConcepto = new JLabel("Concepto");
		lblConcepto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConcepto.setBounds(50, 130, 162, 20);
		pUsuario.add(lblConcepto);
		
		textFieldConcepto = new JTextField();
		textFieldConcepto.setBounds(300, 130, 206, 20);
		pUsuario.add(textFieldConcepto);

		JButton btnPagar = new JButton("Pagar");
		btnPagar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPagar.setBackground(new Color(0, 0, 128));
		btnPagar.setForeground(Color.WHITE);
		btnPagar.setBounds(50, 300, 115, 29);
		pDerecha.add(btnPagar);
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numTarjeta = txtA.getText();
			
				String nomTitular = txtDebeCoincidirCon.getText();
			
				String concepto = textFieldConcepto.getText();
				
				viajeros = new HashSet<Viajero>();
				for(int i=0; i<numViajeros; i++){
					String nombre = arrayNombres[i].getText();
					String dni = arrayDnis[i].getText();
					Viajero v = new Viajero(nombre,dni);
					viajeros.add(v);
					System.out.println(nombre);
					System.out.println(dni);
				}

				if (numTarjeta == null || nomTitular == null || concepto == null ) {
					JOptionPane.showMessageDialog(null, "Rellene todos los campos");
				} else {
					
					try {
					
						controller.Pagar(total, email, concepto);
						controller.newReserva(v,email, viajeros);


					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Buscar a = new Buscar(controller, email);
					a.setVisible(true);
				}
			}
		});
		
		JPanel pCentro = new JPanel();
		pCentro.setBounds(0, 318, 990, 422);
		contentPane.add(pCentro);
		pCentro.setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane();
		pCentro.add(scrollPane, BorderLayout.CENTER);
		
		PscrollPane = new JPanel();
	
		scrollPane.setViewportView(PscrollPane);
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
		int y = 0;;
		
		arrayNombres = new JTextField[numViajeros];
		arrayDnis = new JTextField[numViajeros];
		for (int i = 0; i < numViajeros; i++) {
			
			JPanel panel = new JPanel();
			panel.setSize(990, 422);
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBackground(Color.WHITE);
			panel.setForeground(Color.WHITE);
			panel.setLayout(null);
			
			int num = i+1;
			JLabel lblViajero = new JLabel("DATOS VIAJERO " + num);
			lblViajero.setBounds(50, 10, 300, 20);
			lblViajero.setFont(new Font("Tahoma", Font.BOLD, 20));
			panel.add(lblViajero);
		

			JLabel lblOrigen = new JLabel("Nombre:");
			lblOrigen.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblOrigen.setBounds(50, 50, 162, 20);
			panel.add(lblOrigen);

			JLabel lblDestino = new JLabel("DNI:");
			lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDestino.setBounds(50, 100, 162, 20);
			panel.add(lblDestino);

			arrayNombres[i] = new JTextField();
			arrayNombres[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
			arrayNombres[i].setBounds(300, 50, 206, 20);
			panel.add(arrayNombres[i]);
			
			arrayDnis[i] = new JTextField();
			arrayDnis[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
			arrayDnis[i].setBounds(300, 100, 206, 20);
			panel.add(arrayDnis[i]);
			
			panel.setVisible(true);
			GridBagConstraints gbc_lblFoto = new GridBagConstraints();
			gbc_lblFoto.ipadx = 990;
			gbc_lblFoto.ipady = 422;
			gbc_lblFoto.gridx = x;
			gbc_lblFoto.gridy = y;
			PscrollPane.add(panel, gbc_lblFoto);

			y = y + 50;
		}
		repaint();
	}
}
