package EasyBooking.LD;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import ServiciosExternos.Print;

@PersistenceCapable
public class Usuario implements Serializable {
	@PrimaryKey
	private String ape;
	private String nomUsuario;
	private String email;
	private String password;
	private Aeropuerto aeropuerto;
	
	public Usuario(String nomUsuario, String ape, String email, String password, Aeropuerto a)
	{
		super();
		this.nomUsuario=nomUsuario;
		this.ape=ape;
		this.email=email;
		this.password=password;
		this.aeropuerto=a;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
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


	public String getApe() {
		return ape;
	}

	public void setApe(String ape) {
		this.ape = ape;
	}
}
