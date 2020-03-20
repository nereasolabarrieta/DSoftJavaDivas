package EasyBooking.LD;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Aerolinea {
	@PrimaryKey
	private String codAerolinea;
	private String nomAerolimea;
	public String getCodAerolinea() {
		return codAerolinea;
	}
	public void setCodAerolinea(String codAerolinea) {
		this.codAerolinea = codAerolinea;
	}
	public String getNomAerolimea() {
		return nomAerolimea;
	}
	public void setNomAerolimea(String nomAerolimea) {
		this.nomAerolimea = nomAerolimea;
	}
	

}
