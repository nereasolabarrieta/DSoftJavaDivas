package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class LogIn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		//hay q poner ruta relativa 
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/EasyBooking/Img/Avion.jpg")));
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
		EntrarConFacebook.setLocation(418, 309);
		EntrarConFacebook.setSize(445,66);
		ImageIcon Facebook = new ImageIcon(LogIn.class.getResource("/EasyBooking/Img/Facebook.JPG"));
		EntrarConFacebook.setIcon(Facebook);
		contentPane.add(EntrarConFacebook);
		
		JButton EntrarConGoogle = new JButton();
		EntrarConGoogle.setLocation(418, 448);
		EntrarConGoogle.setSize(445,66);
		ImageIcon Google= new ImageIcon(LogIn.class.getResource("/EasyBooking/Img/Google.JPG"));
		EntrarConGoogle.setIcon(Google);

		contentPane.add(EntrarConGoogle);
		
		JPanel pCentro = new JPanel();
		pCentro.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		pCentro.setBackground(Color.WHITE);
		pCentro.setBounds(310, 202, 654, 420);
		contentPane.add(pCentro);
		pCentro.setLayout(null);
		
		JLabel lblO = new JLabel("o");
		lblO.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblO.setBounds(91, 200, 484, 30);
		pCentro.add(lblO);
		lblO.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel pNorte = new JPanel();
		pNorte.setBackground(new Color(0, 0, 128));
		pNorte.setBounds(0, 0, 1278, 163);
		contentPane.add(pNorte);
		pNorte.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(15, 16, 202, 73);
		ImageIcon fot = new ImageIcon(LogIn.class.getResource("/EasyBooking/Img/logo.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
		lblLogo.setIcon(icono);
		pNorte.add(lblLogo);
		
		
		
	

	}
}
