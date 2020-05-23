package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Entrar_Registrar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JTextField txtEmailEntrar;
	private JTextField txtPasswordEntrar;
	private Controller controller;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Controller c=null;
		try {
			c = new Controller();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
	
			e.printStackTrace();
		}
		Entrar_Registrar b= new Entrar_Registrar(c);
	}

	/**
	 * Create the frame.
	 */
	public Entrar_Registrar(Controller controller) {

		this.controller = controller;
		initComponentes();
		this.setVisible(true);

	}
	
	public void initComponentes()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 740);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p_superior = new JPanel();
		p_superior.setBackground(new Color(0, 0, 128));
		p_superior.setBounds(0, 0, 1278, 159);
		contentPane.add(p_superior);
		p_superior.setLayout(null);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.setBounds(377, 116, 142, 43);
		p_superior.add(btnEntrar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setBounds(518, 117, 142, 43);
		p_superior.add(btnRegistrar);
		
		
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				JPanel panel = new JPanel();
				panel.setBounds(378, 158, 470, 425);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblNombre.setBounds(86, 81, 101, 20);
				panel.add(lblNombre);
			
				JLabel lblApellido = new JLabel("Apellido:");
				lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblApellido.setBounds(86, 144, 101, 20);
				panel.add(lblApellido);
				
				JLabel lblEmail = new JLabel("Email:\r\n");
				lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblEmail.setBounds(86, 210, 101, 20);
				panel.add(lblEmail);
				
				JLabel lblPassword = new JLabel("Password\r\n");
				lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblPassword.setBounds(86, 275, 101, 20);
				panel.add(lblPassword);
				
				txtNombre = new JTextField();
				txtNombre.setBounds(223, 78, 146, 26);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
				
				txtApellido = new JTextField();
				txtApellido.setBounds(223, 141, 146, 26);
				panel.add(txtApellido);
				txtApellido.setColumns(10);
				
				txtEmail = new JTextField();
				txtEmail.setBounds(223, 207, 146, 26);
				panel.add(txtEmail);
				txtEmail.setColumns(10);
				
				txtPassword = new JTextField();
				txtPassword.setBounds(223, 272, 146, 26);
				panel.add(txtPassword);
				txtPassword.setColumns(10);
				
				JButton btnRegistrarse = new JButton("REGISTRARSE");
				btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 16));
				btnRegistrarse.setBackground(Color.WHITE);
				btnRegistrarse.setBounds(161, 366, 164, 29);
				panel.add(btnRegistrarse);
				
				panel.repaint();
				
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

							String nom = txtNombre.getText();
							String ape = txtApellido.getText();
							String email = txtEmail.getText();
							String password = txtPassword.getText();
							
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



			}
		});
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPanel panel = new JPanel();
				panel.setBounds(378, 158, 470, 425);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JLabel lblEmail = new JLabel("Email:\r\n");
				lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblEmail.setBounds(92, 134, 101, 20);
				panel.add(lblEmail);
				
				JLabel lblApellido = new JLabel("Password:");
				lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblApellido.setBounds(92, 220, 101, 20);
				panel.add(lblApellido);
				
				txtEmailEntrar = new JTextField();
				txtEmailEntrar.setBounds(188, 128, 218, 34);
				panel.add(txtEmailEntrar);
				txtEmailEntrar.setColumns(10);
				
				txtPasswordEntrar = new JTextField();
				txtPasswordEntrar.setBounds(188, 214, 218, 34);
				panel.add(txtPasswordEntrar);
				txtPasswordEntrar.setColumns(10);
	
				
				JButton btnEntrar = new JButton("ENTRAR");
				btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
				btnEntrar.setBackground(Color.WHITE);
				btnEntrar.setBounds(184, 327, 164, 29);
				panel.add(btnEntrar);
				
				panel.repaint();
				
				btnEntrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

		
							String email = txtEmail.getText();
							String password = txtPassword.getText();
							
							if( email !=null || password !=null )
							{
								try {
									controller.LogInUsuario(email, password);
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
			}
		});
	}
}
