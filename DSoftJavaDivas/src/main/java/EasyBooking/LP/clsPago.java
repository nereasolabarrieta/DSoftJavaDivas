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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JList;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspace\\Java_Divas\\Java_Divas\\src\\main\\java\\Easybooking\\Img\\Avion.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("EasyBooking");
		setLocationRelativeTo(null);
		setBounds(100, 100, 1300, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(690, 529, 2, 2);
		contentPane.add(scrollPane);
		
		JLabel lblcmoTeGustara = new JLabel("¿Cómo te gustaría pagar?");
		lblcmoTeGustara.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblcmoTeGustara.setBounds(146, 36, 260, 25);
		contentPane.add(lblcmoTeGustara);
		
		ButtonGroup bttnPago = new ButtonGroup();
		
		JRadioButton rdbtnTarjetaCredito = new JRadioButton("Tarjeta de crédito o débito");
		rdbtnTarjetaCredito.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rdbtnTarjetaCredito.setBounds(146, 96, 311, 29);
		contentPane.add(rdbtnTarjetaCredito);
			
		JLabel lblNmeroDeTarjeta = new JLabel("Número de tarjeta");
		lblNmeroDeTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNmeroDeTarjeta.setBounds(184, 136, 206, 20);
		contentPane.add(lblNmeroDeTarjeta);
		
		txtA = new JTextField();
		txtA.setForeground(Color.LIGHT_GRAY);
		txtA.setText("13 a 19 cifras");
		txtA.setToolTipText("");
		txtA.setBounds(184, 172, 255, 26);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		JLabel lblNombreDelTitular = new JLabel("Nombre del titular de la tarjeta");
		lblNombreDelTitular.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNombreDelTitular.setBounds(184, 214, 349, 20);
		contentPane.add(lblNombreDelTitular);
		
		txtDebeCoincidirCon = new JTextField();
		txtDebeCoincidirCon.setForeground(Color.LIGHT_GRAY);
		txtDebeCoincidirCon.setText("Debe coincidir con la tarjeta");
		txtDebeCoincidirCon.setBounds(184, 250, 255, 26);
		contentPane.add(txtDebeCoincidirCon);
		txtDebeCoincidirCon.setColumns(10);
		
		JLabel lblFechaDeCaducidad = new JLabel("Fecha de caducidad");
		lblFechaDeCaducidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFechaDeCaducidad.setBounds(184, 292, 190, 20);
		contentPane.add(lblFechaDeCaducidad);
		
		textField_2 = new JTextField();
		textField_2.setBounds(184, 328, 42, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(241, 328, 42, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCdigoDeSeguridad = new JLabel("Código de seguridad");
		lblCdigoDeSeguridad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCdigoDeSeguridad.setBounds(184, 370, 206, 20);
		contentPane.add(lblCdigoDeSeguridad);
		
		txtCvv = new JTextField();
		txtCvv.setForeground(Color.LIGHT_GRAY);
		txtCvv.setText("CVV");
		txtCvv.setBounds(184, 406, 74, 26);
		contentPane.add(txtCvv);
		txtCvv.setColumns(10);
		
		JRadioButton rdbtnPaypal = new JRadioButton("Paypal");
		rdbtnPaypal.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rdbtnPaypal.setBounds(146, 444, 336, 29);
		contentPane.add(rdbtnPaypal);
		
		bttnPago.add(rdbtnPaypal);
		bttnPago.add(rdbtnTarjetaCredito);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setForeground(Color.BLUE);
		btnPagar.setBounds(650, 518, 115, 29);
		contentPane.add(btnPagar);
		
		JLabel lblTuInformacinPersonal = new JLabel("Tu información personal está \r\nprotegida y encriptada");
		lblTuInformacinPersonal.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTuInformacinPersonal.setBounds(421, 32, 521, 29);
		contentPane.add(lblTuInformacinPersonal);
		
		JList list = new JList();
		list.setBounds(237, 380, -59, -29);
		contentPane.add(list);
		
		Choice choice = new Choice();
		choice.setBounds(230, 328, 28, 26);
		contentPane.add(choice);
		

	}
}
