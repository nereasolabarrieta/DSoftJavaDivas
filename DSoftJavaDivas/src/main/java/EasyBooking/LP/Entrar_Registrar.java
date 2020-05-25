package EasyBooking.LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import EasyBooking.LD.Aeropuerto;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Entrar_Registrar extends JFrame {

	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JTextField txtEmailEntrar;
	private JTextField txtPasswordEntrar;
	private JButton btnRegistrarse;
	private JButton btnLogIn;
	private JButton btnEntrar;
	private JButton btnRegistrar;
	private Controller controller;
	private int contadorEntrar=0;
	private int contadorRegistrar=0;
	private List<Aeropuerto> Lista_Aeropuerto;
	private JComboBox aeropuerto;
	

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
		new Entrar_Registrar(c);
	}

	/**
	 * Create the frame.
	 */
	public Entrar_Registrar(Controller controller) {

		this.controller = controller;
		Lista_Aeropuerto =this.controller.getAeropuertos()
			       .stream()
			       .distinct()
			       .collect(Collectors.toList());
		initComponentes();
		this.setVisible(true);

	}
	
	public void initComponentes()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/EasyBooking/Img/Avion.jpg"));
		setFont(new Font("Franklin Gothic Medium", Font.BOLD, 12));
		setTitle("EasyBooking");
		setForeground(Color.BLACK);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		
		JPanel p_superior = new JPanel();
		p_superior.setBackground(new Color(0, 0, 128));
		p_superior.setBounds(0, 0, 1278, 159);
		contentPane.add(p_superior);
		p_superior.setLayout(null);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));

		btnEntrar.setBounds(377, 116, 142, 43);
		p_superior.add(btnEntrar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setBounds(518, 117, 142, 43);
		p_superior.add(btnRegistrar);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(15, 16, 202, 73);
	
		ImageIcon fot = new ImageIcon("src/main/java/EasyBooking/Img/logo.png");

		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
		lblLogo.setIcon(icono);
		p_superior.add(lblLogo);
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				PanelRegistrar();
			}
			});
	
		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegistrarse.setBackground(Color.WHITE);
		btnRegistrarse.setBounds(161, 366, 164, 29);
		
			btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
					String nom = txtNombre.getText();
					String ape = txtApellido.getText();
					String email = txtEmail.getText();
					String password = txtPassword.getText();
					System.out.println(password);
					
					if(nom !=null || ape !=null || email !=null || password !=null )
					{
						try {
							controller.RegistrarUsuario(nom, ape, email, password);
						} catch (RemoteException e1) {
					// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"¡Bienvenido/a!");
						Buscar a = new Buscar(controller);
						a.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Rellene todos los campos");
					}
			}
		});



	
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panel1.setVisible(false);
				PanelEntrar();
			}
			});
		
		btnLogIn = new JButton("ENTRAR");
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogIn.setBackground(Color.WHITE);
		btnLogIn.setBounds(184, 327, 164, 29);
		
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String email = txtEmailEntrar.getText();
					System.out.println(email);
					String password = txtPasswordEntrar.getText();
					System.out.println(password);
					
					if( email !=null || password !=null )
					{
						System.out.println("entro al primer if");
						try 
						{
							boolean boolControl=controller.LogInUsuario(email, password);
							System.out.println(boolControl);
							if(boolControl==true)
							{
								JOptionPane.showMessageDialog(null,"¡Bienvenido/a!");
								Buscar a = new Buscar(controller);
								a.setVisible(true);
								setVisible(false);
							}
						else
						{
							JOptionPane.showMessageDialog(null,"El usuario no existe");
						}

						} catch (RemoteException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
								
								
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Rellene todos los campos");
					}
					}
				});
	
		PanelEntrar();
	}
	public void PanelRegistrar()
	{
		btnEntrar.setBackground(Color.WHITE);
		btnRegistrar.setBackground(new Color(12, 183, 242));
		panel2.setVisible(false);
		System.out.println(contadorRegistrar);
		if (contadorEntrar!=0)
		{
			contentPane.remove(panel2);
		}
		panel1 = new JPanel();
		panel1.setBounds(378, 158, 470, 425);
		panel1.repaint();
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(86, 61, 101, 20);
		panel1.add(lblNombre);
	
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellido.setBounds(86, 124, 101, 20);
		panel1.add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email:\r\n");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(86, 190, 101, 20);
		panel1.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:\r\n");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(86, 255, 101, 20);
		panel1.add(lblPassword);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(223, 58, 146, 26);
		panel1.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(223, 121, 146, 26);
		panel1.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(223, 187, 146, 26);
		panel1.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(223, 252, 146, 26);
		panel1.add(txtPassword);
		txtPassword.setColumns(10);
	
		panel1.add(btnRegistrarse);
		
		JLabel lblAeropuerto = new JLabel("Aeropuerto por defecto:\r\n");
		lblAeropuerto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAeropuerto.setBounds(20,325, 250, 20);
		panel1.add(lblAeropuerto);
		
		aeropuerto =new JComboBox<String>();
		aeropuerto.setBounds(223, 320, 146, 26);
		Lista_Aeropuerto.stream().forEach(element-> 
		{
			aeropuerto.addItem(element.getNomAeropuerto());
		});
		panel1.add(aeropuerto);
		
		panel1.setVisible(true);
		
		contadorRegistrar++;
	}
	
	public void PanelEntrar()
	{
		btnRegistrar.setBackground(Color.WHITE);
		btnEntrar.setBackground(new Color(12, 183, 242));
		System.out.println(contadorEntrar);
		if (contadorRegistrar!=0)
		{
			contentPane.remove(panel1);
		}
		panel2 = new JPanel();
		panel2.setBounds(378, 158, 470, 425);
		panel2.repaint();
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:\r\n");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(92, 134, 101, 20);
		panel2.add(lblEmail);
		
		JLabel lblApellido = new JLabel("Password:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellido.setBounds(92, 220, 101, 20);
		panel2.add(lblApellido);
		
		txtEmailEntrar = new JTextField();
		txtEmailEntrar.setBounds(188, 128, 218, 34);
		panel2.add(txtEmailEntrar);
		txtEmailEntrar.setColumns(10);
		
		txtPasswordEntrar = new JTextField();
		txtPasswordEntrar.setBounds(188, 214, 218, 34);
		panel2.add(txtPasswordEntrar);
		txtPasswordEntrar.setColumns(10);

		panel2.add(btnLogIn);
		panel2.setVisible(true);
		contadorEntrar++;
		
	
	}
	
}
