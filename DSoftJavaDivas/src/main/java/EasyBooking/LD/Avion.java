package EasyBooking.LD;

import java.util.HashSet;
import java.util.Set;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Avion {
	
	@PrimaryKey
	private String codAvion;
	private Set<Asiento> asientos = new HashSet<Asiento>();
	
	
	
	public Avion(String codAvion, Set<Asiento> asientos) {
		super();
		this.codAvion = codAvion;
		this.asientos = asientos;
	}
	public String getCodAvion() {
		return codAvion;
	}
	public void setCodAvion(String codAvion) {
		this.codAvion = codAvion;
	}
	public Set<Asiento> getAsientos() {
		return asientos;
	}
	public void setAsientos(Set<Asiento> asientos) {
		this.asientos = asientos;
	}
	

}
