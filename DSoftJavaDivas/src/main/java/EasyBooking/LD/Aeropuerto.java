package EasyBooking.LD;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aeropuerto {
	
	@Override
	public String toString() {
		return "Aeropuerto [codAeropuerto=" + codAeropuerto + ", nomAeropuerto=" + nomAeropuerto + "]";
	}
	@PrimaryKey
	private String codAeropuerto;
	private String nomAeropuerto;
	
	
	
	public Aeropuerto(String codAeropuerto, String nomAeropuerto) {
		super();
		this.codAeropuerto = codAeropuerto;
		this.nomAeropuerto = nomAeropuerto;
	}
	public String getCodAeropuerto() {
		return codAeropuerto;
	}
	public void setCodAeropuerto(String codAeropuerto) {
		this.codAeropuerto = codAeropuerto;
	}
	public String getNomAeropuerto() {
		return nomAeropuerto;
	}
	public void setNomAeropuerto(String nomAeropuerto) {
		this.nomAeropuerto = nomAeropuerto;
	}

}
