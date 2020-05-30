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
	private JTextField txtNom;
	private JTextField txtDni;
	private int i;
	/**
	 * Create the panel.
	 */
	public JPanelViajeros( int i, JTextField txtNom, JTextField txtDni) {
		this.txtNom = txtNom;
		this.txtDni = txtDni;
		this.i = i+1;
		InsertarJPanel();
		

	}
	
	public void InsertarJPanel()
	{
		setSize(990, 100);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setLayout(null);

		JLabel lblViajero = new JLabel("DATOS VIAJERO " + i);
		lblViajero.setBounds(50, 10, 300, 20);
		lblViajero.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblViajero);
	

		JLabel lblOrigen = new JLabel("Nombre:");
		lblOrigen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrigen.setBounds(50, 50, 162, 20);
		add(lblOrigen);

		JLabel lblDestino = new JLabel("DNI:");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDestino.setBounds(50, 100, 162, 20);
		add(lblDestino);

		txtNom = new JTextField();
		txtNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNom.setBounds(300, 50, 206, 20);
		add(txtNom);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDni.setBounds(300, 100, 206, 20);
		add(txtDni);
		
		
}

}
