package EasyBooking.LD;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Usuario {
	@PrimaryKey
	private String dniUsuario;
	private String nomUsuario;
	private String metodoPago;
	private Aeropuerto aeropuerto;
	
	
	
	public Usuario(String dniUsuario, String nomUsuario, String metodoPago, Aeropuerto aeropuerto) {
		super();
		this.dniUsuario = dniUsuario;
		this.nomUsuario = nomUsuario;
		this.metodoPago = metodoPago;
		this.aeropuerto = aeropuerto;
	}
	
	public String getDniUsuario() {
		return dniUsuario;
	}
	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}
	public String getNomUsuario() {
		return nomUsuario;
	}
	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}
	public void setAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}

}
