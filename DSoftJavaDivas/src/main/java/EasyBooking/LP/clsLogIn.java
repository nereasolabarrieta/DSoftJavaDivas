package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class clsLogIn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clsLogIn frame = new clsLogIn();
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
	public clsLogIn() {
		//hay q poner ruta relativa 
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
		
		JButton EntrarConFacebook = new JButton();
		EntrarConFacebook.setLocation(417, 286);
		EntrarConFacebook.setSize(445,66);
		ImageIcon Facebook= new ImageIcon("C:\\workspace\\Java_Divas\\Java_Divas\\src\\main\\java\\Easybooking\\Img\\Facebook.JPG");
		EntrarConFacebook.setIcon(Facebook);

		contentPane.add(EntrarConFacebook);
		
		JButton EntrarConGoogle = new JButton();
		EntrarConGoogle.setLocation(417, 425);
		EntrarConGoogle.setSize(445,66);
		ImageIcon Google= new ImageIcon("C:\\workspace\\Java_Divas\\Java_Divas\\src\\main\\java\\Easybooking\\Img\\Google.JPG");
		EntrarConGoogle.setIcon(Google);

		contentPane.add(EntrarConGoogle);
		
		JLabel lblO = new JLabel("-----------------------------  O -----------------------------");
		lblO.setBounds(449, 380, 484, 30);
		contentPane.add(lblO);
		
		JPanel panel = new JPanel();
		panel.setBounds(309, 158, 654, 441);
		contentPane.add(panel);
		
	

	}
}
