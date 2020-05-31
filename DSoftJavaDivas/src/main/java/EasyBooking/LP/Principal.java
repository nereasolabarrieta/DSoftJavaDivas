package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import Controller.Controller;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Vuelo;

import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel PscrollPane;
	private Controller controller;
	private String origen;
	private String destino;
	private String objDate;
	private List<Vuelo> Lista_vuelos;
	private List<Aeropuerto> Lista_Aeropuerto;
	private long precio;
	private long numAsientos;
	private LocalDateTime hora;
	private JTextField txtPrecio;
	private JComboBox<String> comboBoxMinIda;
	private JComboBox<String> comboBoxMaxIda;
	private JDateChooser dChooser_ida;
	private JComboBox combo_Origen;
	private JComboBox combo_destino;
	private JTextField txtViajeros;
	private Date fecha_calendar;
	private String emailP;
	private JButton btnCerrarSesion;

	public Principal(Controller controller, String origen, String destino, String objDate, String email)
			throws RemoteException {

		this.controller = controller;
		this.destino = destino;
		this.origen = origen;
		this.objDate = objDate;
		emailP = email;

		Lista_vuelos = controller.Buscar_vuelos(origen, destino, objDate);
		Lista_Aeropuerto = this.controller.getAeropuertos().stream().distinct().collect(Collectors.toList());

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
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);

		JPanel pArriba = new JPanel();
		pArriba.setBounds(0, 0, 1278, 159);
		pArriba.setBackground(new Color(0, 0, 128));
		contentPane.add(pArriba);
		pArriba.setLayout(null);
		PscrollPane = new JPanel();

		JLabel lblOrigen = new JLabel("Origen: ");
		lblOrigen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrigen.setForeground(Color.WHITE);
		lblOrigen.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblOrigen.setBounds(458, 76, 69, 20);
		pArriba.add(lblOrigen);

		JLabel lblDestino = new JLabel("Destino: ");
		lblDestino.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDestino.setForeground(Color.WHITE);
		lblDestino.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDestino.setBounds(733, 76, 93, 20);
		pArriba.add(lblDestino);

		JLabel lblBuscar = new JLabel("");
		lblBuscar.setBounds(1048, 112, 38, 31);
		ImageIcon fotBuscar = new ImageIcon("src/main/java/EasyBooking/Img/Buscar.png");
		Icon iconoBuscar = new ImageIcon(fotBuscar.getImage().getScaledInstance(lblBuscar.getWidth(),
				lblBuscar.getHeight(), Image.SCALE_DEFAULT));
		lblBuscar.setIcon(iconoBuscar);
		pArriba.add(lblBuscar);

		JPanel pIzquierda = new JPanel();
		pIzquierda.setBounds(0, 155, 218, 546);
		pIzquierda.setBackground(new Color(0, 0, 128));
		contentPane.add(pIzquierda);
		pIzquierda.setLayout(null);

		JLabel lblFiltros = new JLabel("FILTROS");
		lblFiltros.setForeground(new Color(255, 255, 255));
		lblFiltros.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFiltros.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltros.setBounds(15, 16, 188, 44);
		pIzquierda.add(lblFiltros);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrecio.setForeground(new Color(255, 255, 255));
		lblPrecio.setBounds(15, 71, 69, 20);
		pIzquierda.add(lblPrecio);

		JLabel lblFiltro_ida = new JLabel("Hora de ida:");
		lblFiltro_ida.setForeground(Color.WHITE);
		lblFiltro_ida.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFiltro_ida.setBounds(10, 183, 117, 20);
		pIzquierda.add(lblFiltro_ida);

		JLabel lblMaxPrecio = new JLabel("Max");
		lblMaxPrecio.setForeground(Color.WHITE);
		lblMaxPrecio.setBounds(25, 115, 69, 20);
		pIzquierda.add(lblMaxPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(72, 115, 116, 26);
		pIzquierda.add(txtPrecio);
		txtPrecio.setColumns(10);

		JLabel lblDe = new JLabel("De");
		lblDe.setForeground(Color.WHITE);
		lblDe.setBounds(15, 235, 69, 20);
		pIzquierda.add(lblDe);

		JLabel lblA = new JLabel("A");
		lblA.setForeground(Color.WHITE);
		lblA.setBounds(15, 267, 69, 20);
		pIzquierda.add(lblA);

		comboBoxMinIda = new JComboBox<String>();
		comboBoxMinIda.setBounds(72, 232, 116, 26);
		comboBoxMinIda.addItem("00:00");
		comboBoxMinIda.addItem("01:00");
		comboBoxMinIda.addItem("02:00");
		comboBoxMinIda.addItem("03:00");
		comboBoxMinIda.addItem("04:00");
		comboBoxMinIda.addItem("05:00");
		comboBoxMinIda.addItem("06:00");
		comboBoxMinIda.addItem("07:00");
		comboBoxMinIda.addItem("08:00");
		comboBoxMinIda.addItem("09:00");
		comboBoxMinIda.addItem("10:00");
		comboBoxMinIda.addItem("11:00");
		comboBoxMinIda.addItem("12:00");
		comboBoxMinIda.addItem("13:00");
		comboBoxMinIda.addItem("14:00");
		comboBoxMinIda.addItem("15:00");
		comboBoxMinIda.addItem("16:00");
		comboBoxMinIda.addItem("17:00");
		comboBoxMinIda.addItem("18:00");
		comboBoxMinIda.addItem("19:00");
		comboBoxMinIda.addItem("20:00");
		comboBoxMinIda.addItem("21:00");
		comboBoxMinIda.addItem("22:00");
		comboBoxMinIda.addItem("23:00");
		comboBoxMinIda.addItem("23:59");

		pIzquierda.add(comboBoxMinIda);

		comboBoxMaxIda = new JComboBox<String>();
		comboBoxMaxIda.setBounds(72, 266, 116, 26);
		comboBoxMaxIda.addItem("01:00");
		comboBoxMaxIda.addItem("02:00");
		comboBoxMaxIda.addItem("03:00");
		comboBoxMaxIda.addItem("04:00");
		comboBoxMaxIda.addItem("05:00");
		comboBoxMaxIda.addItem("06:00");
		comboBoxMaxIda.addItem("07:00");
		comboBoxMaxIda.addItem("08:00");
		comboBoxMaxIda.addItem("09:00");
		comboBoxMaxIda.addItem("10:00");
		comboBoxMaxIda.addItem("11:00");
		comboBoxMaxIda.addItem("12:00");
		comboBoxMaxIda.addItem("13:00");
		comboBoxMaxIda.addItem("14:00");
		comboBoxMaxIda.addItem("15:00");
		comboBoxMaxIda.addItem("16:00");
		comboBoxMaxIda.addItem("17:00");
		comboBoxMaxIda.addItem("18:00");
		comboBoxMaxIda.addItem("19:00");
		comboBoxMaxIda.addItem("20:00");
		comboBoxMaxIda.addItem("21:00");
		comboBoxMaxIda.addItem("22:00");
		comboBoxMaxIda.addItem("23:00");
		comboBoxMaxIda.addItem("23:59");
		pIzquierda.add(comboBoxMaxIda);
		JLabel lblLogo = new JLabel();

		ImageIcon fot = new ImageIcon("src/main/java/EasyBooking/Img/logo.png");
		lblLogo.setBounds(15, 16, 202, 73);
		Icon icono = new ImageIcon(
				fot.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
		lblLogo.setIcon(icono);
		pArriba.add(lblLogo);

		combo_Origen = new JComboBox<String>();
		combo_Origen.setBackground(new Color(255, 255, 255));
		combo_Origen.setBounds(527, 76, 142, 20);
		pArriba.add(combo_Origen);

		combo_destino = new JComboBox<String>();
		combo_destino.setBounds(836, 76, 142, 20);
		pArriba.add(combo_destino);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCerrarSesion.setForeground(Color.BLACK);
		btnCerrarSesion.setBackground(Color.WHITE);
		btnCerrarSesion.setBounds(1070, 26, 142, 29);
		pArriba.add(btnCerrarSesion);

		for (int i = 0; i < Lista_Aeropuerto.size(); i++) {
			combo_Origen.addItem(Lista_Aeropuerto.get(i).getNomAeropuerto());
			if (Lista_Aeropuerto.get(i).getNomAeropuerto().equals(origen)) {
				combo_Origen.setSelectedIndex(i);
			}
			combo_destino.addItem(Lista_Aeropuerto.get(i).getNomAeropuerto());
			if (Lista_Aeropuerto.get(i).getNomAeropuerto().equals(destino)) {
				combo_destino.setSelectedIndex(i);
			}
		}

		dChooser_ida = new JDateChooser();
		dChooser_ida.setBounds(72, 335, 125, 26);
		pIzquierda.add(dChooser_ida);

		java.util.Date fechaParseada;
		try {
			fechaParseada = new SimpleDateFormat("yyyy/MM/dd").parse(objDate);
			dChooser_ida.setDate(fechaParseada);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setBounds(15, 335, 69, 20);
		pIzquierda.add(lblFecha);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(35, 455, 139, 50);
		btnBuscar.setBackground(new Color(255, 255, 255));

		JPanel pCentro = new JPanel();
		pCentro.setBounds(215, 155, 1063, 529);
		contentPane.add(pCentro);
		pCentro.setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane();
		pCentro.add(scrollPane, BorderLayout.CENTER);

		scrollPane.setViewportView(PscrollPane);
		scrollPane.getViewport().setView(PscrollPane);
		GridBagLayout gbl_PscrollPane = new GridBagLayout();
		gbl_PscrollPane.columnWidths = new int[] { 0 };
		gbl_PscrollPane.rowHeights = new int[] { 0 };
		gbl_PscrollPane.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_PscrollPane.rowWeights = new double[] { Double.MIN_VALUE };
		PscrollPane.setLayout(gbl_PscrollPane);

		
		

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buscar();
			}
		});
		pIzquierda.add(btnBuscar);

		JLabel lblViajeros = new JLabel("Viajeros");
		lblViajeros.setForeground(new Color(255, 255, 255));
		lblViajeros.setBounds(10, 398, 55, 14);
		pIzquierda.add(lblViajeros);

		txtViajeros = new JTextField();
		txtViajeros.setText("1");
		txtViajeros.setBounds(80, 395, 38, 20);
		pIzquierda.add(txtViajeros);
		txtViajeros.setColumns(10);
		
		InsertarJPanel();
		PscrollPane.repaint();
		scrollPane.repaint();

	}

	public void Buscar() {
		Double precio = 0.0;
		origen = combo_Origen.getSelectedItem().toString();
		destino = combo_destino.getSelectedItem().toString();

		int viajeros = 1;

		try {
			viajeros = Integer.parseInt(txtViajeros.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Introduce el numero de viajeros que desee:");
			txtViajeros.setText("1");
			return;
		}

		try {
			precio = Double.parseDouble(txtPrecio.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Introduce el precio maximo que este dipuesto a pagar:");
			txtPrecio.setText("");
			return;
		}

		fecha_calendar = dChooser_ida.getDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String fecha = dateFormat.format(fecha_calendar);
		fecha = fecha + " 00:00:00";

		try {

			Lista_vuelos = controller.Aplicar_filtros(origen, destino, precio, viajeros, fecha);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Lista_vuelos.size() == 0) {
			JOptionPane.showMessageDialog(null, "No existe ningún vuelo en esas fechas:");
		} else {
			repaint();
			InsertarJPanel();
		}

	}

	public void InsertarJPanel() {
		PscrollPane.removeAll();
		int x = 0;
		int y = 50;
		int tam = Lista_vuelos.size();
		String codVuelo;
		for (int i = 0; i < tam; i++) {

			precio = Lista_vuelos.get(i).getPrecio();
			codVuelo = Lista_vuelos.get(i).getCodVuelo();
			numAsientos = Lista_vuelos.get(i).getNumAsientos();

			hora = Lista_vuelos.get(i).getHora_salida();
			

			JPanelVuelo panel = new JPanelVuelo(controller, origen, destino, precio, numAsientos, hora, emailP, codVuelo);
			panel.setVisible(true);
			GridBagConstraints gbc_lblFoto = new GridBagConstraints();
			gbc_lblFoto.ipadx = 1058;
			gbc_lblFoto.ipady = 265;
			gbc_lblFoto.gridx = x;
			gbc_lblFoto.gridy = y;
			PscrollPane.add(panel, gbc_lblFoto);

			y = y + 265;
		}
		repaint();
	}
}
