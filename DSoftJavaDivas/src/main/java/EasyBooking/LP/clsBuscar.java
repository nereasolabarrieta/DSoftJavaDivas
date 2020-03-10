package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import javax.swing.JButton;

public class clsBuscar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumViajeros;
	private JDateChooser datechooser;
	private JCalendar calendar;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(1300,740);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setTitle("Easy Booking");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pArriba = new JPanel();
		pArriba.setBounds(5, 16, 668, 67);
		contentPane.add(pArriba);
		pArriba.setLayout(null);
		
		ButtonGroup grupoIda = new ButtonGroup();
		
		JPanel pIzquierda = new JPanel();
		pIzquierda.setBounds(5, 89, 668, 539);
		contentPane.add(pIzquierda);
		pIzquierda.setLayout(null);
		
		JLabel label_1 = new JLabel("Precio");
		label_1.setBounds(156, 304, 43, 20);
		pIzquierda.add(label_1);
		
		JSlider slFiltroPrecio = new JSlider();
		slFiltroPrecio.setBounds(228, 243, 200, 61);
		slFiltroPrecio.setValue(900);
		slFiltroPrecio.setToolTipText("");
		slFiltroPrecio.setPaintTicks(true);
		slFiltroPrecio.setMajorTickSpacing(1000);
		slFiltroPrecio.setPaintLabels(true);
		slFiltroPrecio.setMaximum(1000);
		pIzquierda.add(slFiltroPrecio);
		
		JLabel lblNewLabel = new JLabel("Origen");
		lblNewLabel.setBounds(43, 40, 48, 20);
		pIzquierda.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(133, 37, 297, 26);
		pIzquierda.add(comboBox);
		datechooser = new JDateChooser(null, null, null, new JSpinnerDateEditor());
		datechooser.setBounds (450,37, 175, 26);
		pIzquierda.add(datechooser);
		pIzquierda.add(calendar);
		
		
		JLabel lblNewLabel_1 = new JLabel("Destino");
		lblNewLabel_1.setBounds(43, 99, 53, 20);
		pIzquierda.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(133, 96, 297, 26);
		pIzquierda.add(comboBox_1);
		datechooser = new JDateChooser(null, null, null, new JSpinnerDateEditor());
		datechooser.setBounds (450,96, 175, 26);
		pIzquierda.add(datechooser);
		pIzquierda.add(calendar);
		
		JRadioButton rdbtnIda = new JRadioButton("Ida");
		rdbtnIda.setBounds(233, 146, 55, 29);
		pIzquierda.add(rdbtnIda);
		
		grupoIda.add(rdbtnIda);
		
		JRadioButton rdbtnIdaVuelta = new JRadioButton("Ida y vuelta");
		rdbtnIdaVuelta.setBounds(351, 146, 115, 29);
		pIzquierda.add(rdbtnIdaVuelta);
		grupoIda.add(rdbtnIdaVuelta);
		
		JLabel lblNewLabel_2 = new JLabel("Número de viajeros");
		lblNewLabel_2.setBounds(43, 204, 139, 20);
		pIzquierda.add(lblNewLabel_2);
		
		txtNumViajeros = new JTextField();
		txtNumViajeros.setBounds(198, 201, 297, 26);
		pIzquierda.add(txtNumViajeros);
		txtNumViajeros.setColumns(2);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(284, 354, 126, 43);
		pIzquierda.add(btnBuscar);
		
		
	}

}
