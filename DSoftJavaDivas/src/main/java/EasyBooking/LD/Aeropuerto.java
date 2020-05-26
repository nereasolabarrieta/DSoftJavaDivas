package EasyBooking.LD;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aeropuerto implements Serializable {
	
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

	public boolean equals( Object aero ) {
		if (aero == null) return false;

		Aeropuerto aerop = (Aeropuerto)aero;
		if (this.getCodAeropuerto().equals(aerop.getCodAeropuerto()) )
		return true;

		return false;
		}

		public int hashCode() {
		return this.getCodAeropuerto().hashCode();
		}
}
