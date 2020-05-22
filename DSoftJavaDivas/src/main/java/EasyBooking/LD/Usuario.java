package EasyBooking.LD;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import ServiciosExternos.Print;

@PersistenceCapable
public class Usuario implements Print{
	@PrimaryKey
	private String ape;
	private String nomUsuario;
	private String email;
	private String password;
	private String newPassword;
	private metodoPago metodoPago;
	private Aeropuerto aeropuerto;

	
	
	public Usuario(String email, String contrasena)
	{
		super();
		this.email = email;
		this.password = contrasena;
	}
	public Usuario(String nomUsuario,String ape, String email) {
		super();
		this.ape = ape;
		this.nomUsuario = nomUsuario;
		this.setEmail(email);
	}
	public Usuario(String nomUsuario, String email, String password, String newPassword) {
		super();
		this.setEmail(email);
		this.setPassword(password);
		this.setNewPassword(newPassword);
	}


	public String getNomUsuario() {
		return nomUsuario;
	}
	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	public metodoPago getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(metodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}
	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}
	public void setAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getApe() {
		return ape;
	}
	public void setApe(String ape) {
		this.ape = ape;
	}


	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
}
