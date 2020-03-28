package EasyBooking.LP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import EasyBooking.LN.Main;

public class clsServidor extends JFrame 
{
	private JPanel contentPane;
	private JTextField txtNomAeropuerto;
	private JTextField txtCodAeropuerto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsServidor frame = new clsServidor();
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
	public clsServidor() {
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
		
		JPanel pIzquierda = new JPanel();
		pIzquierda.setForeground(new Color(255, 255, 255));
		pIzquierda.setBackground(Color.WHITE);
		pIzquierda.setBounds(0, 163, 1278, 521);
		contentPane.add(pIzquierda);
		pIzquierda.setLayout(null);
		
		JLabel label_1 = new JLabel("Nombre de aeropuerto: ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(170, 203, 286, 20);
		pIzquierda.add(label_1);
		
		txtNomAeropuerto = new JTextField();
		txtNomAeropuerto.setBounds(495, 201, 162, 26);
		pIzquierda.add(txtNomAeropuerto);
		txtNomAeropuerto.setColumns(2);
		txtNomAeropuerto.setText("");
		

		JLabel label_2 = new JLabel("Codigo de aeropuerto: ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(265, 255, 191, 20);
		pIzquierda.add(label_2);
		
		txtCodAeropuerto = new JTextField();
		txtCodAeropuerto.setText("");
		txtCodAeropuerto.setColumns(2);
		txtCodAeropuerto.setBounds(495, 253, 162, 26);
		pIzquierda.add(txtCodAeropuerto);
		
		JButton btnAadir = new JButton("Anyadir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(txtCodAeropuerto.getText().equals("") || txtNomAeropuerto.getText().equals(""))
            	{
            		JOptionPane.showMessageDialog(null,"Por favor, rellene todos los campos.");
            	}
            	else
            	{
            		
            		Main.AnyadirAeropuerto(txtCodAeropuerto.getText(),txtNomAeropuerto.getText());
            	}
			}
		});
		btnAadir.setBounds(207, 334, 115, 29);
		pIzquierda.add(btnAadir);
		
		JButton button = new JButton("Modificar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		button.setBounds(513, 334, 115, 29);
		pIzquierda.add(button);
		
		JButton button_1 = new JButton("Eliminar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		button_1.setBounds(837, 334, 115, 29);
		pIzquierda.add(button_1);
		
		
		JPanel pNorte = new JPanel();
		pNorte.setBackground(new Color(0, 0, 128));
		pNorte.setBounds(0, 0, 1278, 163);
		contentPane.add(pNorte);
		pNorte.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(15, 16, 202, 73);
		ImageIcon fot = new ImageIcon(clsBuscar.class.getResource("/EasyBooking/Img/logo.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
		lblLogo.setIcon(icono);
		pNorte.add(lblLogo);
		
		
	}
}
