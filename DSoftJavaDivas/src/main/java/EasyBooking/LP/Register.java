package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField textNom;
	private JTextField textEmail;
	private JTextField textPassword;
	private JTextField textApe;


	/**
	 * Create the frame.
	 */
	public Register(Controller controller) {
			this.controller = controller;
			initComponents();
			this.setVisible(true);
			
		}
		public void initComponents()
		{
			//setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/EasyBooking/Img/Avion.jpg")));
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
	//		ImageIcon fot = new ImageIcon(Register.class.getResource("/EasyBooking/Img/logo.png"));
	//		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
		//	lblLogo.setIcon(icono);
			
			JButton btnRegistro = new JButton("REGISTRAR");
			btnRegistro.setBounds(377, 116, 142, 43);
			pArriba.add(btnRegistro);
			btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnRegistro.setIcon(null);
			btnRegistro.setSelectedIcon(null);
			btnRegistro.setBackground(new Color(0, 153, 255));
			btnRegistro.setForeground(Color.WHITE);
			
			JButton btnLogin = new JButton("ENTRAR");
			btnLogin.setBounds(518, 117, 142, 43);
			btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnLogin.setIcon(null);
			btnLogin.setSelectedIcon(null);
			pArriba.add(btnLogin);
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login login = new Login(controller);
					login.setVisible(true);
					
				}
			});
			
			
			textNom = new JTextField();
			textNom.setBounds(535, 213, 207, 43);
			contentPane.add(textNom);
			textNom.setColumns(10);
			
			textEmail = new JTextField();
			textEmail.setBounds(535, 355, 207, 43);
			contentPane.add(textEmail);
			textEmail.setColumns(10);
			
			textPassword = new JTextField();
			textPassword.setBounds(535, 426, 207, 43);
			contentPane.add(textPassword);
			textPassword.setColumns(10);
			
			
			textApe = new JTextField();
			textApe.setBounds(535, 284, 207, 43);
			contentPane.add(textApe);
			textApe.setColumns(10);
			
			JButton btnRegistrar = new JButton("Registrar");
			btnRegistrar.setBackground(Color.WHITE);
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

						String nom = textNom.getText();
						String ape = textApe.getText();
						String email = textEmail.getText();
						String password = textPassword.getText();
						
						if(nom !=null || ape !=null || email !=null || password !=null )
						{
							try {
								controller.RegistrarUsuario(nom, ape, email, password);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
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
			
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(434, 224, 62, 20);
			contentPane.add(lblNombre);
			
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setBounds(457, 366, 39, 20);
			contentPane.add(lblEmail);
			
			JLabel lblContrasea = new JLabel("Password");
			lblContrasea.setBounds(427, 437, 69, 20);
			contentPane.add(lblContrasea);

			
			JLabel lblApellido = new JLabel("Apellido");
			lblApellido.setBounds(434, 295, 62, 20);
			contentPane.add(lblApellido);
			
			JPanel panel = new JPanel();
			panel.setBounds(378, 158, 470, 425);
			contentPane.add(panel);
	}
}
