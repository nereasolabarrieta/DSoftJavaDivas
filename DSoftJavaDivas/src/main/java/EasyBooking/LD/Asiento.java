package EasyBooking.LD;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Asiento {
	@PrimaryKey
	private String codAsiento;
	private boolean disponible;
	
		
	public Asiento(String codAsiento, boolean disponible) {
		super();
		this.codAsiento = codAsiento;
		this.disponible = disponible;
	}
	public String getCodAsiento() {
		return codAsiento;
	}
	public void setCodAsiento(String codAsiento) {
		this.codAsiento = codAsiento;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	

}
