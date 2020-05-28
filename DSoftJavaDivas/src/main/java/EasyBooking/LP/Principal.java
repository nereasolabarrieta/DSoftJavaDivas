package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import Controller.Controller;
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
	private long precio;
	private long numAsientos;
	private LocalDateTime hora;
	private JTextField textFieldMinPrecio;
	private JTextField textFieldMaxPrecio;
	private JTextField textFieldOrigen;
	private JTextField textFieldDestino;
	private JComboBox<String> comboBoxMinIda;
	private JComboBox<String> comboBoxMaxIda;
	private JDateChooser dChooser_ida;
	
	public Principal(Controller controller, String origen, String destino, String objDate) throws RemoteException {
		
		  this.controller = controller;
			this.destino = destino;
			this.origen = origen;
			Lista_vuelos = controller.Buscar_vuelos(origen, destino, objDate);
			
			System.out.println(Lista_vuelos.size());
		
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
	PscrollPane=new JPanel();
	Date objDate= new Date();
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
	sdf.format(objDate);
	
	JLabel lblOrigen = new JLabel("Origen: ");
	lblOrigen.setHorizontalAlignment(SwingConstants.RIGHT);
	lblOrigen.setForeground(Color.WHITE);
	lblOrigen.setFont(new Font("Tahoma", Font.BOLD, 17));
	lblOrigen.setBounds(458, 76, 69, 20);
	pArriba.add(lblOrigen);
	
	JLabel lblAeropuerto_Origen = new JLabel(origen);
	lblAeropuerto_Origen.setForeground(Color.WHITE);
	lblAeropuerto_Origen.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblAeropuerto_Origen.setBounds(542, 77, 69, 20);
	pArriba.add(lblAeropuerto_Origen);
	
	JLabel lblDestino = new JLabel("Destino: ");
	lblDestino.setHorizontalAlignment(SwingConstants.RIGHT);
	lblDestino.setForeground(Color.WHITE);
	lblDestino.setFont(new Font("Tahoma", Font.BOLD, 17));
	lblDestino.setBounds(733, 76, 93, 20);
	pArriba.add(lblDestino);
	
	JLabel lblAeropuerto_destino = new JLabel(destino);
	lblAeropuerto_destino.setForeground(Color.WHITE);
	lblAeropuerto_destino.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblAeropuerto_destino.setBounds(841, 77, 69, 20);
	pArriba.add(lblAeropuerto_destino);
	
	JLabel lblBuscar = new JLabel("");
	lblBuscar.setBounds(1048, 112, 38, 31);
	ImageIcon fotBuscar = new ImageIcon("src/main/java/EasyBooking/Img/Buscar.png");
	Icon iconoBuscar = new ImageIcon(fotBuscar.getImage().getScaledInstance(lblBuscar.getWidth(), lblBuscar.getHeight(), Image.SCALE_DEFAULT));
	lblBuscar.setIcon(iconoBuscar);
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
	lblPrecio.setBounds(15, 178, 69, 20);
	pIzquierda.add(lblPrecio);
	
	JLabel lblFiltro_ida = new JLabel("Hora de ida:");
	lblFiltro_ida.setForeground(Color.WHITE);
	lblFiltro_ida.setFont(new Font("Tahoma", Font.PLAIN, 17));
	lblFiltro_ida.setBounds(15, 284, 117, 20);
	pIzquierda.add(lblFiltro_ida);
	
	JLabel lblMinPrecio = new JLabel("Min");
	lblMinPrecio.setForeground(Color.WHITE);
	lblMinPrecio.setBounds(25, 214, 69, 20);
	pIzquierda.add(lblMinPrecio);
	
	JLabel lblMaxPrecio = new JLabel("Max");
	lblMaxPrecio.setForeground(Color.WHITE);
	lblMaxPrecio.setBounds(25, 250, 69, 20);
	pIzquierda.add(lblMaxPrecio);
	
	textFieldMinPrecio = new JTextField();
	textFieldMinPrecio.setBounds(72, 214, 117, 26);
	pIzquierda.add(textFieldMinPrecio);
	textFieldMinPrecio.setColumns(10);
	
	textFieldMaxPrecio = new JTextField();
	textFieldMaxPrecio.setBounds(72, 250, 116, 26);
	pIzquierda.add(textFieldMaxPrecio);
	textFieldMaxPrecio.setColumns(10);
	
	JLabel lblDe = new JLabel("De");
	lblDe.setForeground(Color.WHITE);
	lblDe.setBounds(25, 319, 69, 20);
	pIzquierda.add(lblDe);
	
	JLabel lblA = new JLabel("A");
	lblA.setForeground(Color.WHITE);
	lblA.setBounds(25, 355, 69, 20);
	pIzquierda.add(lblA);
	
	comboBoxMinIda = new JComboBox<String>();
	comboBoxMinIda.setBounds(72, 316, 116, 26);
	comboBoxMinIda.addItem("00:00");comboBoxMinIda.addItem("01:00");comboBoxMinIda.addItem("02:00");comboBoxMinIda.addItem("03:00");
	comboBoxMinIda.addItem("04:00");comboBoxMinIda.addItem("05:00");comboBoxMinIda.addItem("06:00");comboBoxMinIda.addItem("07:00");
	comboBoxMinIda.addItem("08:00");comboBoxMinIda.addItem("09:00");comboBoxMinIda.addItem("10:00");comboBoxMinIda.addItem("11:00");
	comboBoxMinIda.addItem("12:00");comboBoxMinIda.addItem("13:00");comboBoxMinIda.addItem("14:00");comboBoxMinIda.addItem("15:00");
	comboBoxMinIda.addItem("16:00");comboBoxMinIda.addItem("17:00");comboBoxMinIda.addItem("18:00");comboBoxMinIda.addItem("19:00");
	comboBoxMinIda.addItem("20:00");comboBoxMinIda.addItem("21:00");comboBoxMinIda.addItem("22:00");comboBoxMinIda.addItem("23:00");
	comboBoxMinIda.addItem("23:59");
	
	pIzquierda.add(comboBoxMinIda);
	
	comboBoxMaxIda = new JComboBox<String>();
	comboBoxMaxIda.setBounds(72, 352, 116, 26);
	comboBoxMaxIda.addItem("01:00");comboBoxMaxIda.addItem("02:00");comboBoxMaxIda.addItem("03:00");
	comboBoxMaxIda.addItem("04:00");comboBoxMaxIda.addItem("05:00");comboBoxMaxIda.addItem("06:00");comboBoxMaxIda.addItem("07:00");
	comboBoxMaxIda.addItem("08:00");comboBoxMaxIda.addItem("09:00");comboBoxMaxIda.addItem("10:00");comboBoxMaxIda.addItem("11:00");
	comboBoxMaxIda.addItem("12:00");comboBoxMaxIda.addItem("13:00");comboBoxMaxIda.addItem("14:00");comboBoxMaxIda.addItem("15:00");
	comboBoxMaxIda.addItem("16:00");comboBoxMaxIda.addItem("17:00");comboBoxMaxIda.addItem("18:00");comboBoxMaxIda.addItem("19:00");
	comboBoxMaxIda.addItem("20:00");comboBoxMaxIda.addItem("21:00");comboBoxMaxIda.addItem("22:00");comboBoxMaxIda.addItem("23:00");
	comboBoxMaxIda.addItem("23:59");
	pIzquierda.add(comboBoxMaxIda);
	
	JLabel lblOrigen_1 = new JLabel("Origen");
	lblOrigen_1.setForeground(Color.WHITE);
	lblOrigen_1.setBackground(Color.WHITE);
	lblOrigen_1.setBounds(15, 83, 69, 20);
	pIzquierda.add(lblOrigen_1);
	
	textFieldOrigen = new JTextField();
	textFieldOrigen.setBounds(73, 80, 116, 26);
	pIzquierda.add(textFieldOrigen);
	textFieldOrigen.setColumns(10);
	
	JLabel lblDestino_1 = new JLabel("Destino");
	lblDestino_1.setForeground(Color.WHITE);
	lblDestino_1.setBounds(15, 137, 69, 20);
	pIzquierda.add(lblDestino_1);
	
	textFieldDestino = new JTextField();
	textFieldDestino.setBounds(72, 134, 117, 26);
	pIzquierda.add(textFieldDestino);
	textFieldDestino.setColumns(10);
	JLabel lblLogo = new JLabel();
	

	ImageIcon fot = new ImageIcon("src/main/java/EasyBooking/Img/logo.png");
	lblLogo.setBounds(15, 16, 202, 73);
	Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
	lblLogo.setIcon(icono);
	pArriba.add(lblLogo);
		
	dChooser_ida = new JDateChooser();
	dChooser_ida.setBounds(49, 432, 125, 26);
	pIzquierda.add(dChooser_ida);
	dChooser_ida.setDate(objDate);
		
	JLabel lblFecha = new JLabel("Fecha");
	lblFecha.setForeground(Color.WHITE);
	lblFecha.setBounds(15, 401, 69, 20);
	pIzquierda.add(lblFecha);
		
	JButton btnBuscar = new JButton("BUSCAR");
	btnBuscar.setBounds(25, 474, 139, 29);
	btnBuscar.setBackground(new Color(255, 255, 255));
		
		
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

	System.out.println("VOY A INSTERTAR JPANEL");
	InsertarJPanel(Lista_vuelos);
	
	PscrollPane.repaint();
	scrollPane.repaint();

	btnBuscar.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
Buscar();
		}
	});
	pIzquierda.add(btnBuscar);

}
 public void Buscar()
 {
		try 
		{
			double precioMin= Double.parseDouble(textFieldMinPrecio.getText());
			System.out.println(precioMin);
			double precioMax= Double.parseDouble(textFieldMaxPrecio.getText());
			System.out.println(precioMax);
			Lista_vuelos = controller.AplicarFiltro(comboBoxMinIda.getSelectedItem().toString(), comboBoxMaxIda.getSelectedItem().toString(), precioMin, precioMax, textFieldOrigen.getText(),textFieldDestino.getText(), dChooser_ida.getDate());
			System.out.println("HONEA NO LLEGO");
			if(Lista_vuelos.size()==0)
			{
				JOptionPane.showMessageDialog(null,"No existe ningún vuelo en esas fechas. ");
			}else
			{
			InsertarJPanel(Lista_vuelos);
			System.out.println("LORTU DET:" + Lista_vuelos.size());
			
			System.out.println("Origen: " + Lista_vuelos.get(2).getOrigen() + " " + Lista_vuelos.get(2).getDestino() );
			}
			PscrollPane.repaint();
			scrollPane.repaint();
			
		} catch (NumberFormatException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
 public void InsertarJPanel(List<Vuelo>vuelos)
		{	int x=0;
			int y=50;
			int tam = vuelos.size();
			System.out.println("TAM " + tam);
			
			for( int i=0; i<tam; i++)
			{
				System.out.println("aqui est0y");
				precio=Lista_vuelos.get(i).getPrecio();
				System.out.println(precio);
				numAsientos=Lista_vuelos.get(i).getNumAsientos();
				System.out.println(numAsientos);
				hora=Lista_vuelos.get(i).getHora_salida();
				System.out.println(hora);
				JPanelVuelo panel=new JPanelVuelo(origen, destino, precio, numAsientos, hora);
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
