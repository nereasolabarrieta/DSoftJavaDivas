package EasyBooking.LP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

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

import EasyBooking.LD.Aeropuerto;
import EasyBooking.LN.Main;

public class Servidor extends JFrame {
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
					Servidor frame = new Servidor();
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
	public Servidor() {
		// setIconImage(Toolkit.getDefaultToolkit().getImage(Servidor.class.getResource("/EasyBooking/Img/Avion.jpg")));
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

		JPanel pIzquierda = new JPanel();
		pIzquierda.setForeground(new Color(255, 255, 255));
		pIzquierda.setBackground(Color.WHITE);
		pIzquierda.setBounds(0, 163, 1278, 521);
		contentPane.add(pIzquierda);
		pIzquierda.setLayout(null);

		JLabel lblNom_aeropuerto = new JLabel("Nombre de aeropuerto: ");
		lblNom_aeropuerto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNom_aeropuerto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNom_aeropuerto.setBounds(170, 203, 286, 20);
		pIzquierda.add(lblNom_aeropuerto);

		txtNomAeropuerto = new JTextField();
		txtNomAeropuerto.setBounds(495, 201, 162, 26);
		pIzquierda.add(txtNomAeropuerto);
		txtNomAeropuerto.setColumns(2);
		txtNomAeropuerto.setText("");

		JLabel lbl_codigo_aero = new JLabel("Codigo de aeropuerto: ");
		lbl_codigo_aero.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_codigo_aero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_codigo_aero.setBounds(265, 255, 191, 20);
		pIzquierda.add(lbl_codigo_aero);

		txtCodAeropuerto = new JTextField();
		txtCodAeropuerto.setText("");
		txtCodAeropuerto.setColumns(2);
		txtCodAeropuerto.setBounds(495, 253, 162, 26);
		pIzquierda.add(txtCodAeropuerto);

		JButton btnAnyadir = new JButton("Anyadir");
		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCodAeropuerto.getText().equals("") || txtNomAeropuerto.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos.");
				} else {

					Main.AnyadirAeropuerto_1(txtCodAeropuerto.getText(), txtNomAeropuerto.getText());
					txtCodAeropuerto.setText("");
					txtNomAeropuerto.setText("");
				}
			}
		});
		btnAnyadir.setBounds(207, 334, 115, 29);
		pIzquierda.add(btnAnyadir);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCodAeropuerto.getText().equals("") || txtNomAeropuerto.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, rellene el campo de código");
				} else {
					Main.ModificarAeropuerto(txtCodAeropuerto.getText(), txtNomAeropuerto.getText());
				}
			}
		});
		btnModificar.setBounds(513, 334, 115, 29);
		pIzquierda.add(btnModificar);
		String a = "0";
		Stream<Long> lista = Arrays.stream(a.split("")).map(Long::parseLong);

		int num = 0;
		JButton btn_eliminar = new JButton("Eliminar");
		btn_eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCodAeropuerto.getText().equals("") || txtNomAeropuerto.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos.");
				} else {
					Main.EliminarAeropuerto(txtCodAeropuerto.getText());
				}

			}
		});
		btn_eliminar.setBounds(837, 334, 115, 29);
		pIzquierda.add(btn_eliminar);

		JPanel pNorte = new JPanel();
		pNorte.setBackground(new Color(0, 0, 128));
		pNorte.setBounds(0, 0, 1278, 163);
		contentPane.add(pNorte);
		pNorte.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(15, 16, 202, 73);
		// ImageIcon fot = new
		// ImageIcon(Servidor.class.getResource("/EasyBooking/Img/logo.png"));
		// Icon icono = new
		// ImageIcon(fot.getImage().getScaledInstance(lblLogo.getWidth(),
		// lblLogo.getHeight(), Image.SCALE_DEFAULT));
		// lblLogo.setIcon(icono);
		pNorte.add(lblLogo);

		/*
		 * JButton btn_visualizar = new JButton("Visualizar aeropuertos");
		 * btn_visualizar.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { List<Aeropuerto> aeropuertos =
		 * Main.VisualizarAeropuertos(); for(Aeropuerto a: aeropuertos) {
		 * JOptionPane.showMessageDialog(null,a.getNomAeropuerto()); }
		 * 
		 * 
		 * } }); btn_visualizar.setBounds(480, 400, 200, 29);
		 * pIzquierda.add(btn_visualizar);
		 */

	}
}
