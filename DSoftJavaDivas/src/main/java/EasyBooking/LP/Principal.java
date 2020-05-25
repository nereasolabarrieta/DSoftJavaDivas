package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.util.List;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDayChooser;

import Controller.Controller;
import EasyBooking.LD.Vuelo;

import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class Principal extends JFrame {


	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel PscrollPane;
	private Controller controller;
	private String origen;
	private String destino;
	private String objDate;
	private ArrayList<Vuelo> Lista_vuelos;
	private long precio;
	private JTextField textFieldMinPrecio;
	private JTextField textFieldMaxPrecio;
	private JTextField textFieldMinDur;
	private JTextField textFieldMaxDur;
	
	public Principal(Controller controller, String origen, String destino, Date objDate) throws RemoteException {
		
		  this.controller = controller;
			this.destino = destino;
			this.origen = origen;
			//this.objDate=objDate.format(new Date());
			//Lista_vuelos = controller.Buscar_vuelos(origen, destino, objDate);

			
			//System.out.println(Lista_vuelos.size());
		
			initComponents();
			this.setVisible(true);
			
			
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal(null,null,null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

 public void initComponents()
 {
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
	PscrollPane=new JPanel();
//	JLabel lblLogo = new JLabel();
//	lblLogo.setBounds(0, 0, 185, 64);
//	pArriba.add(lblLogo);
//	ImageIcon fot = new ImageIcon(Principal.class.getResource("/EasyBooking/Img/logo.png"));
//	Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
//	lblLogo.setIcon(icono);
	
	JDateChooser dChooser_ida = new JDateChooser();
	dChooser_ida.setBounds(861, 70, 125, 26);
	Date objDate= new Date();
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
	sdf.format(objDate);
	dChooser_ida.setDate(objDate);
	pArriba.add(dChooser_ida);
	
	JDateChooser dChooser_vuelta = new JDateChooser();
	dChooser_vuelta.setBounds(1091, 70, 125, 26);
	dChooser_vuelta.setDate(objDate);
	pArriba.add(dChooser_vuelta);
	
	JLabel lblIda = new JLabel("Ida:");
	lblIda.setFont(new Font("Tahoma", Font.BOLD, 17));
	lblIda.setHorizontalAlignment(SwingConstants.RIGHT);
	lblIda.setLabelFor(this);
	lblIda.setForeground(Color.WHITE);
	lblIda.setBounds(777, 76, 69, 20);
	pArriba.add(lblIda);
	
	JLabel lblVuelta = new JLabel("Vuelta: ");
	lblVuelta.setHorizontalAlignment(SwingConstants.RIGHT);
	lblVuelta.setFont(new Font("Tahoma", Font.BOLD, 17));
	lblVuelta.setForeground(Color.WHITE);
	lblVuelta.setBounds(1007, 76, 69, 20);
	pArriba.add(lblVuelta);
	
	JLabel lblOrigen = new JLabel("Origen: ");
	lblOrigen.setHorizontalAlignment(SwingConstants.RIGHT);
	lblOrigen.setForeground(Color.WHITE);
	lblOrigen.setFont(new Font("Tahoma", Font.BOLD, 17));
	lblOrigen.setBounds(276, 76, 69, 20);
	pArriba.add(lblOrigen);
	
	JLabel lblAeropuerto_Origen = new JLabel(origen);
	lblAeropuerto_Origen.setForeground(Color.WHITE);
	lblAeropuerto_Origen.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblAeropuerto_Origen.setBounds(360, 77, 69, 20);
	pArriba.add(lblAeropuerto_Origen);
	
	JLabel lblDestino = new JLabel("Destino: ");
	lblDestino.setHorizontalAlignment(SwingConstants.RIGHT);
	lblDestino.setForeground(Color.WHITE);
	lblDestino.setFont(new Font("Tahoma", Font.BOLD, 17));
	lblDestino.setBounds(475, 76, 93, 20);
	pArriba.add(lblDestino);
	
	JLabel lblAeropuerto_destino = new JLabel(destino);
	lblAeropuerto_destino.setForeground(Color.WHITE);
	lblAeropuerto_destino.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblAeropuerto_destino.setBounds(570, 76, 69, 20);
	pArriba.add(lblAeropuerto_destino);
	
	JLabel lblBuscar = new JLabel("");
	lblBuscar.setBounds(1048, 112, 38, 31);
	//ImageIcon fotBuscar = new ImageIcon(Principal.class.getResource("/EasyBooking/Img/Buscar.png"));
	//Icon iconoBuscar = new ImageIcon(fotBuscar.getImage().getScaledInstance(lblBuscar.getWidth(), lblBuscar.getHeight(), Image.SCALE_DEFAULT));
	//lblBuscar.setIcon(iconoBuscar);
	pArriba.add(lblBuscar);
	
	JPanel pIzquierda= new JPanel();
	pIzquierda.setBounds(0, 155, 218, 529);
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
	lblPrecio.setBounds(15, 100, 69, 20);
	pIzquierda.add(lblPrecio);
	
	JLabel lblFiltro_ida = new JLabel("Hora de ida:");
	lblFiltro_ida.setForeground(Color.WHITE);
	lblFiltro_ida.setFont(new Font("Tahoma", Font.PLAIN, 17));
	lblFiltro_ida.setBounds(15, 206, 117, 20);
	pIzquierda.add(lblFiltro_ida);
	
	JLabel lblFiltro_regreso = new JLabel("Hora de regreso:");
	lblFiltro_regreso.setForeground(Color.WHITE);
	lblFiltro_regreso.setFont(new Font("Tahoma", Font.PLAIN, 17));
	lblFiltro_regreso.setBounds(15, 309, 173, 20);
	pIzquierda.add(lblFiltro_regreso);
	
	JLabel lblDuracion = new JLabel("Duracion: ");
	lblDuracion.setForeground(Color.WHITE);
	lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 17));
	lblDuracion.setBounds(15, 415, 173, 20);
	pIzquierda.add(lblDuracion);
	
	JLabel lblMinPrecio = new JLabel("Min");
	lblMinPrecio.setForeground(Color.WHITE);
	lblMinPrecio.setBounds(25, 136, 69, 20);
	pIzquierda.add(lblMinPrecio);
	
	JLabel lblMaxPrecio = new JLabel("Max");
	lblMaxPrecio.setForeground(Color.WHITE);
	lblMaxPrecio.setBounds(25, 172, 69, 20);
	pIzquierda.add(lblMaxPrecio);
	
	textFieldMinPrecio = new JTextField();
	textFieldMinPrecio.setBounds(72, 136, 117, 26);
	pIzquierda.add(textFieldMinPrecio);
	textFieldMinPrecio.setColumns(10);
	
	textFieldMaxPrecio = new JTextField();
	textFieldMaxPrecio.setBounds(72, 172, 116, 26);
	pIzquierda.add(textFieldMaxPrecio);
	textFieldMaxPrecio.setColumns(10);
	
	JLabel lblMinDur = new JLabel("Min");
	lblMinDur.setForeground(Color.WHITE);
	lblMinDur.setBounds(24, 451, 69, 20);
	pIzquierda.add(lblMinDur);
	
	JLabel lblMaxDur = new JLabel("Max");
	lblMaxDur.setForeground(Color.WHITE);
	lblMaxDur.setBounds(24, 487, 69, 20);
	pIzquierda.add(lblMaxDur);
	
	textFieldMinDur = new JTextField();
	textFieldMinDur.setColumns(10);
	textFieldMinDur.setBounds(71, 451, 117, 26);
	pIzquierda.add(textFieldMinDur);
	
	textFieldMaxDur = new JTextField();
	textFieldMaxDur.setColumns(10);
	textFieldMaxDur.setBounds(71, 487, 116, 26);
	pIzquierda.add(textFieldMaxDur);
	
	JLabel lblDe = new JLabel("De");
	lblDe.setForeground(Color.WHITE);
	lblDe.setBounds(25, 241, 69, 20);
	pIzquierda.add(lblDe);
	
	JLabel lblA = new JLabel("A");
	lblA.setForeground(Color.WHITE);
	lblA.setBounds(25, 277, 69, 20);
	pIzquierda.add(lblA);
	
	JComboBox comboBoxMinIda = new JComboBox();
	comboBoxMinIda.setBounds(72, 238, 116, 26);
	comboBoxMinIda.addItem("00:00");comboBoxMinIda.addItem("01:00");comboBoxMinIda.addItem("02:00");comboBoxMinIda.addItem("03:00");
	comboBoxMinIda.addItem("04:00");comboBoxMinIda.addItem("05:00");comboBoxMinIda.addItem("06:00");comboBoxMinIda.addItem("07:00");
	comboBoxMinIda.addItem("08:00");comboBoxMinIda.addItem("09:00");comboBoxMinIda.addItem("10:00");comboBoxMinIda.addItem("11:00");
	comboBoxMinIda.addItem("12:00");comboBoxMinIda.addItem("13:00");comboBoxMinIda.addItem("14:00");comboBoxMinIda.addItem("15:00");
	comboBoxMinIda.addItem("16:00");comboBoxMinIda.addItem("17:00");comboBoxMinIda.addItem("18:00");comboBoxMinIda.addItem("19:00");
	comboBoxMinIda.addItem("20:00");comboBoxMinIda.addItem("21:00");comboBoxMinIda.addItem("22:00");comboBoxMinIda.addItem("23:00");
	comboBoxMinIda.addItem("23:59");
	
	pIzquierda.add(comboBoxMinIda);
	
	JComboBox comboBoxMaxIda = new JComboBox();
	comboBoxMaxIda.setBounds(72, 274, 116, 26);
	comboBoxMaxIda.addItem("01:00");comboBoxMaxIda.addItem("02:00");comboBoxMaxIda.addItem("03:00");
	comboBoxMaxIda.addItem("04:00");comboBoxMaxIda.addItem("05:00");comboBoxMaxIda.addItem("06:00");comboBoxMaxIda.addItem("07:00");
	comboBoxMaxIda.addItem("08:00");comboBoxMaxIda.addItem("09:00");comboBoxMaxIda.addItem("10:00");comboBoxMaxIda.addItem("11:00");
	comboBoxMaxIda.addItem("12:00");comboBoxMaxIda.addItem("13:00");comboBoxMaxIda.addItem("14:00");comboBoxMaxIda.addItem("15:00");
	comboBoxMaxIda.addItem("16:00");comboBoxMaxIda.addItem("17:00");comboBoxMaxIda.addItem("18:00");comboBoxMaxIda.addItem("19:00");
	comboBoxMaxIda.addItem("20:00");comboBoxMaxIda.addItem("21:00");comboBoxMaxIda.addItem("22:00");comboBoxMaxIda.addItem("23:00");
	comboBoxMaxIda.addItem("23:59");
	pIzquierda.add(comboBoxMaxIda);
	
	JLabel lblDeVuelta = new JLabel("De");
	lblDeVuelta.setForeground(Color.WHITE);
	lblDeVuelta.setBounds(25, 348, 69, 20);
	pIzquierda.add(lblDeVuelta);
	
	JComboBox comboBoxMinVuelta = new JComboBox();
	comboBoxMinVuelta.setBounds(72, 345, 116, 26);
	comboBoxMinVuelta.addItem("00:00");comboBoxMinVuelta.addItem("01:00");comboBoxMinVuelta.addItem("02:00");comboBoxMinVuelta.addItem("03:00");
	comboBoxMinVuelta.addItem("04:00");comboBoxMinVuelta.addItem("05:00");comboBoxMinVuelta.addItem("06:00");comboBoxMinVuelta.addItem("07:00");
	comboBoxMinVuelta.addItem("08:00");comboBoxMinVuelta.addItem("09:00");comboBoxMinVuelta.addItem("10:00");comboBoxMinVuelta.addItem("11:00");
	comboBoxMinVuelta.addItem("12:00");comboBoxMinVuelta.addItem("13:00");comboBoxMinVuelta.addItem("14:00");comboBoxMinVuelta.addItem("15:00");
	comboBoxMinVuelta.addItem("16:00");comboBoxMinVuelta.addItem("17:00");comboBoxMinVuelta.addItem("18:00");comboBoxMinVuelta.addItem("19:00");
	comboBoxMinVuelta.addItem("20:00");comboBoxMinVuelta.addItem("21:00");comboBoxMinVuelta.addItem("22:00");comboBoxMinVuelta.addItem("23:00");
	comboBoxMinVuelta.addItem("23:59");
	pIzquierda.add(comboBoxMinVuelta);
	
	JLabel lblAVuelta = new JLabel("A");
	lblAVuelta.setForeground(Color.WHITE);
	lblAVuelta.setBounds(25, 384, 69, 20);
	pIzquierda.add(lblAVuelta);
	
	JComboBox comboBoxMaxVuelta = new JComboBox();
	comboBoxMaxVuelta.setBounds(72, 381, 116, 26);
	comboBoxMaxVuelta.addItem("01:00");comboBoxMaxVuelta.addItem("02:00");comboBoxMaxVuelta.addItem("03:00");
	comboBoxMaxVuelta.addItem("04:00");comboBoxMaxVuelta.addItem("05:00");comboBoxMaxVuelta.addItem("06:00");comboBoxMaxVuelta.addItem("07:00");
	comboBoxMaxVuelta.addItem("08:00");comboBoxMaxVuelta.addItem("09:00");comboBoxMaxVuelta.addItem("10:00");comboBoxMaxVuelta.addItem("11:00");
	comboBoxMaxVuelta.addItem("12:00");comboBoxMaxVuelta.addItem("13:00");comboBoxMaxVuelta.addItem("14:00");comboBoxMaxVuelta.addItem("15:00");
	comboBoxMaxVuelta.addItem("16:00");comboBoxMaxVuelta.addItem("17:00");comboBoxMaxVuelta.addItem("18:00");comboBoxMaxVuelta.addItem("19:00");
	comboBoxMaxVuelta.addItem("20:00");comboBoxMaxVuelta.addItem("21:00");comboBoxMaxVuelta.addItem("22:00");comboBoxMaxVuelta.addItem("23:00");
	comboBoxMaxVuelta.addItem("23:59");
	pIzquierda.add(comboBoxMaxVuelta);
	System.out.println(comboBoxMinIda.getSelectedItem().toString());
	
	JButton btnBuscar = new JButton("Buscar");
	btnBuscar.setBackground(new Color(255, 255, 255));
	btnBuscar.setBounds(1101, 114, 115, 29);
	btnBuscar.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
//			try 
//			{
//				controller.AplicarFiltro(comboBoxMinIda.getSelectedItem().toString(), comboBoxMaxIda.getSelectedItem().toString(), comboBoxMinVuelta.getSelectedItem().toString(),comboBoxMaxVuelta.getSelectedItem().toString(), Double.parseDouble(textFieldMinPrecio.toString()), Double.parseDouble(textFieldMaxPrecio.toString()), Double.parseDouble(textFieldMinDur.toString()), Double.parseDouble(textFieldMaxDur.toString()));
//				
//			} catch (NumberFormatException e) 
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (RemoteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	});
	pArriba.add(btnBuscar);
		
	JPanel pCentro = new JPanel();
	pCentro.setBounds(215, 155, 1063, 529);
	contentPane.add(pCentro);
	pCentro.setLayout(new BorderLayout(0, 0));
	scrollPane = new JScrollPane();
	pCentro.add(scrollPane, BorderLayout.CENTER);

	scrollPane.setViewportView(PscrollPane);
	scrollPane .getViewport().setView(PscrollPane);
	GridBagLayout gbl_PscrollPane = new GridBagLayout();
	gbl_PscrollPane.columnWidths = new int[]{0};
	gbl_PscrollPane.rowHeights = new int[]{0};
	gbl_PscrollPane.columnWeights = new double[]{Double.MIN_VALUE};
	gbl_PscrollPane.rowWeights = new double[]{Double.MIN_VALUE};
	PscrollPane.setLayout(gbl_PscrollPane);


	InsertarJPanel();
	
	PscrollPane.repaint();
	scrollPane.repaint();






}
 public void InsertarJPanel()
		{	int x=0;
			int y=50;
			for( int i=0; i<Lista_vuelos.size(); i++)
			{
				precio=Lista_vuelos.get(i).getPrecio();
				
				JPanelVuelo panel=new JPanelVuelo(controller, origen, destino, null, precio);
				panel.setVisible(true);
				GridBagConstraints gbc_lblFoto = new GridBagConstraints();
				gbc_lblFoto.ipadx = 1058;
				gbc_lblFoto.ipady = 265;
				gbc_lblFoto.gridx = x;
				gbc_lblFoto.gridy = y;
				PscrollPane.add(panel, gbc_lblFoto);

				y=y+265;
				

			}	
	}

}
