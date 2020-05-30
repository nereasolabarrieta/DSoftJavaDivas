package EasyBooking.LP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Controller.Controller;

public class JPanelViajeros extends JPanel {

	private static final long serialVersionUID = 1L;
	private DateTimeFormatter formatter;
	private Controller controller;
	private int i;
	private String emailJP;
	/**
	 * Create the panel.
	 */
	public JPanelViajeros(Controller controller, int i) {
		this.controller=controller;
		
		InsertarJPanel();
		

	}
	
	public void InsertarJPanel()
	{
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setSize(990, 422);
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setLayout(null);

		JPanel panelDeArriba = new JPanel();
		panelDeArriba.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDeArriba.setBackground(Color.WHITE);
		panelDeArriba.setBounds(0, 318, 990, 422);
		add(panelDeArriba);
		panelDeArriba.setLayout(null);

		JLabel lblViajero = new JLabel("DATOS VIAJERO " + i);
		lblViajero.setBounds(120, 68, 156, 46);
		panelDeArriba.add(lblViajero);
		lblViajero.setFont(new Font("Tahoma", Font.BOLD, 26));

		JLabel lblOrigen = new JLabel("Nombre:");
		lblOrigen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrigen.setBounds(165, 93, 112, 44);
		add(lblOrigen);

		JLabel lblDestino = new JLabel("DNI:");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDestino.setBounds(165, 200, 172, 52);
		add(lblDestino);

		JTextField txtNom = new JTextField();
		txtNom.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtNom.setBounds(300, 93, 112, 44);
		add(txtNom);
		
		JTextField txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtDni.setBounds(300, 200, 112, 44);
		add(txtDni);
}

}
