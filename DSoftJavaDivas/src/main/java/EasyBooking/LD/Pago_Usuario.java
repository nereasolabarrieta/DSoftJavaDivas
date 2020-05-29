package EasyBooking.LD;

import ServiciosExternos.Print;

public class Pago_Usuario implements Print {
	private String nomUsuario;
	private String ape;
	private String email;
	private double cantidad_total;
	private String concepto;
	private double currency=1000000;

	public Pago_Usuario(String nomUsuario, String ape, String email, double cantidad_total, String concepto,
			double currency) {
		this.nomUsuario = nomUsuario;
		this.ape = ape;
		this.email = email;
		this.cantidad_total = cantidad_total;
		this.concepto = concepto;
		this.currency = currency;
	}

	public Pago_Usuario(String email, double cantidad_total, String concepto) {
		this.email = email;
		this.cantidad_total = cantidad_total;
		this.concepto = concepto;
	}

	public Pago_Usuario(String nomUsuario, String ape, String email, double currency) {
		this.nomUsuario = nomUsuario;
		this.ape = ape;
		this.email = email;
		this.currency = currency-cantidad_total;
	}

	public Pago_Usuario(String email, double currency) {
		this.email = email;
		this.currency = currency;
	}

	public String getnomUsuario() {
		return nomUsuario;
	}

	public void setnomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getape() {
		return ape;
	}

	public void setape(String ape) {
		this.ape = ape;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getcantidad_total() {
		return cantidad_total;
	}

	public void setcantidad_total(double cantidad_total) {
		this.cantidad_total = cantidad_total;
	}

	public String getconcepto() {
		return concepto;
	}

	public void setconcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getCurrency() {
		return currency;
	}

	public void setCurrency(double currency) {
		this.currency = currency;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Printing P_User" + "\n" + "nomUsuario: " + getnomUsuario() + "\n" + "Last nomUsuario: "
				+ getape() + "\n" + "email: " + getEmail() + "\n" + "cantidad_total: " + getcantidad_total() + "\n"
				+ "concepto:" + getconcepto() + "\n" + "Currency:" + getCurrency() + "\n");
	}

}
