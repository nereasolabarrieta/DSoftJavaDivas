package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

public class Login extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField textEmail;
	private JTextField textPassword;


	public Login(Controller controller) {
			this.controller = controller;
			initComponents();
			this.setVisible(true);
			
		}
		public void initComponents()
		{
			setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/EasyBooking/Img/Avion.jpg")));
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
			pArriba.setBackground(new Color(0, 0, 128));
			pArriba.setBounds(0, 0, 1278, 159);
			contentPane.add(pArriba);
			pArriba.setLayout(null);
			
			JLabel lblLogo = new JLabel();
			lblLogo.setBounds(0, 0, 185, 64);
			pArriba.add(lblLogo);
			ImageIcon fot = new ImageIcon(Login.class.getResource("/EasyBooking/Img/logo.png"));
			Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
			lblLogo.setIcon(icono);
			
			JButton btnRegistro = new JButton("REGISTRAR");
			btnRegistro.setBounds(377, 116, 142, 43);
			pArriba.add(btnRegistro);
			btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnRegistro.setIcon(null);
			btnRegistro.setSelectedIcon(null);
			btnRegistro.setBackground(new Color(0, 153, 255));
			btnRegistro.setForeground(Color.WHITE);
			btnRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Register r = new Register(controller);
					r.setVisible(true);
				}
			});
			
			JButton btnLogin = new JButton("ENTRAR");
			btnLogin.setBounds(518, 117, 142, 43);
			pArriba.add(btnLogin);
		
			
		
			
			textEmail = new JTextField();
			textEmail.setBounds(535, 272, 207, 43);
			contentPane.add(textEmail);
			textEmail.setColumns(10);
			
			textPassword = new JTextField();
			textPassword.setBounds(535, 408, 207, 43);
			contentPane.add(textPassword);
			textPassword.setColumns(10);
			

			
			JButton btnRegistrar = new JButton("Entrar");
			btnRegistrar.setBackground(Color.WHITE);
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

	
						String email = textEmail.getText();
						String password = textPassword.getText();
						
						if( email !=null || password !=null )
						{
							controller.LogInUsuario(email, password);
							Principal a = new Principal(controller);
							a.setVisible(true);
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Rellene todos los campos");
						}
				}
			});
			btnRegistrar.setBounds(568, 521, 142, 43);
			contentPane.add(btnRegistrar);
			
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setBounds(457, 283, 39, 20);
			contentPane.add(lblEmail);
			
			JLabel lblContrasea = new JLabel("Password");
			lblContrasea.setBounds(427, 419, 69, 20);
			contentPane.add(lblContrasea);
			
			JPanel panel = new JPanel();
			panel.setBounds(378, 159, 470, 425);
			contentPane.add(panel);
	}
}
