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
	private double cantidad_total;
	private String concepto;
	private double moneda;
	
	
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
	public Usuario(String nomUsuario, String ape, String email, double cantidad_total, String concepto, double moneda)
	{
		super();
		this.nomUsuario=nomUsuario;
		this.ape=ape;
		this.email=email;
		this.cantidad_total=cantidad_total;
		this.concepto=concepto;
		this.moneda=moneda;
		
	}
    public Usuario(String email, double cantidad_total, String concepto) {
        this.email = email;
        this.cantidad_total = cantidad_total;
        this.concepto = concepto;
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
	public double getCantidad_total() {
		return cantidad_total;
	}
	public void setCantidad_total(double cantidad_total) {
		this.cantidad_total = cantidad_total;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public double getMoneda() {
		return moneda;
	}
	public void setMoneda(double moneda) {
		this.moneda = moneda;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
}
