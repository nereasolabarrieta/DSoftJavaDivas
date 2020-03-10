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
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(690, 529, 2, 2);
		contentPane.add(scrollPane);
		
		JLabel lblcmoTeGustara = new JLabel("¿Cómo te gustaría pagar?");
		lblcmoTeGustara.setBounds(146, 36, 194, 20);
		contentPane.add(lblcmoTeGustara);
		
		ButtonGroup bttnPago = new ButtonGroup();
		
		JRadioButton rdbtnTarjetaCredito = new JRadioButton("New radio button");
		rdbtnTarjetaCredito.setBounds(146, 96, 27, 29);
		contentPane.add(rdbtnTarjetaCredito);
		
		JLabel lblNewLabel = new JLabel("Tarjeta de crédito o débito");
		lblNewLabel.setBounds(184, 100, 271, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNmeroDeTarjeta = new JLabel("Número de tarjeta");
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
		lblNombreDelTitular.setBounds(184, 214, 349, 20);
		contentPane.add(lblNombreDelTitular);
		
		txtDebeCoincidirCon = new JTextField();
		txtDebeCoincidirCon.setForeground(Color.LIGHT_GRAY);
		txtDebeCoincidirCon.setText("Debe coincidir con la tarjeta");
		txtDebeCoincidirCon.setBounds(184, 250, 255, 26);
		contentPane.add(txtDebeCoincidirCon);
		txtDebeCoincidirCon.setColumns(10);
		
		JLabel lblFechaDeCaducidad = new JLabel("Fecha de caducidad");
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
		lblCdigoDeSeguridad.setBounds(184, 370, 206, 20);
		contentPane.add(lblCdigoDeSeguridad);
		
		txtCvv = new JTextField();
		txtCvv.setForeground(Color.LIGHT_GRAY);
		txtCvv.setText("CVV");
		txtCvv.setBounds(184, 406, 74, 26);
		contentPane.add(txtCvv);
		txtCvv.setColumns(10);
		
		JRadioButton rdbtnPaypal = new JRadioButton("New radio button");
		rdbtnPaypal.setBounds(146, 444, 27, 29);
		contentPane.add(rdbtnPaypal);
		
		bttnPago.add(rdbtnPaypal);
		bttnPago.add(rdbtnTarjetaCredito);
		
		JLabel lblPaypal = new JLabel("PayPal");
		lblPaypal.setBounds(184, 448, 69, 20);
		contentPane.add(lblPaypal);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setForeground(Color.BLUE);
		btnPagar.setBounds(650, 518, 115, 29);
		contentPane.add(btnPagar);
		
		JLabel lblTuInformacinPersonal = new JLabel("Tu información personal está \r\nprotegida y encriptada");
		lblTuInformacinPersonal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTuInformacinPersonal.setBounds(421, 32, 421, 29);
		contentPane.add(lblTuInformacinPersonal);
		
		JList list = new JList();
		list.setBounds(237, 380, -59, -29);
		contentPane.add(list);
		
		Choice choice = new Choice();
		choice.setBounds(230, 328, 28, 26);
		contentPane.add(choice);
		

	}
}
