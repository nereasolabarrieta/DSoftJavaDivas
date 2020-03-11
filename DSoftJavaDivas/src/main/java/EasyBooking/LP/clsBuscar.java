package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import javax.swing.JButton;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class clsBuscar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumViajeros;
	private JDateChooser datechooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsBuscar frame = new clsBuscar();
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
	public clsBuscar() {
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
		pArriba.setBounds(0, 0, 1278, 88);
		contentPane.add(pArriba);
		pArriba.setLayout(null);
		
		ButtonGroup grupoIda = new ButtonGroup();
		
		JPanel pIzquierda = new JPanel();
		pIzquierda.setBounds(0, 89, 1278, 595);
		contentPane.add(pIzquierda);
		pIzquierda.setLayout(null);
		
		JLabel label_1 = new JLabel("Precio");
		label_1.setBounds(393, 253, 43, 20);
		pIzquierda.add(label_1);
		
		JSlider slFiltroPrecio = new JSlider();
		slFiltroPrecio.setBounds(607, 246, 200, 61);
		slFiltroPrecio.setValue(900);
		slFiltroPrecio.setToolTipText("");
		slFiltroPrecio.setPaintTicks(true);
		slFiltroPrecio.setMajorTickSpacing(1000);
		slFiltroPrecio.setPaintLabels(true);
		slFiltroPrecio.setMaximum(1000);
		pIzquierda.add(slFiltroPrecio);
		
		JLabel lblNewLabel = new JLabel("Origen");
		lblNewLabel.setBounds(393, 40, 48, 20);
		pIzquierda.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(483, 37, 297, 26);
		pIzquierda.add(comboBox);
		datechooser = new JDateChooser(null, null, null, new JSpinnerDateEditor());
		Date objDate= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(objDate);
		datechooser.setDate(objDate);
		datechooser.setBounds (800,37, 175, 26);
		pIzquierda.add(datechooser);
		
		
		JLabel lblNewLabel_1 = new JLabel("Destino");
		lblNewLabel_1.setBounds(393, 99, 53, 20);
		pIzquierda.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(483, 96, 297, 26);
		pIzquierda.add(comboBox_1);
		datechooser = new JDateChooser(null, null, null, new JSpinnerDateEditor());
		datechooser.setDate(objDate);
		datechooser.setBounds (800,96, 175, 26);
		pIzquierda.add(datechooser);
		
		JRadioButton rdbtnIda = new JRadioButton("Ida");
		rdbtnIda.setBounds(570, 146, 55, 29);
		pIzquierda.add(rdbtnIda);
		
		grupoIda.add(rdbtnIda);
		
		JRadioButton rdbtnIdaVuelta = new JRadioButton("Ida y vuelta");
		rdbtnIdaVuelta.setBounds(762, 146, 115, 29);
		pIzquierda.add(rdbtnIdaVuelta);
		grupoIda.add(rdbtnIdaVuelta);
		
		JLabel lblNewLabel_2 = new JLabel("Numero de viajeros");
		lblNewLabel_2.setBounds(393, 204, 139, 20);
		pIzquierda.add(lblNewLabel_2);
		
		txtNumViajeros = new JTextField();
		txtNumViajeros.setBounds(556, 201, 297, 26);
		pIzquierda.add(txtNumViajeros);
		txtNumViajeros.setColumns(2);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(653, 350, 126, 43);
		pIzquierda.add(btnBuscar);
		
		
	}

}
