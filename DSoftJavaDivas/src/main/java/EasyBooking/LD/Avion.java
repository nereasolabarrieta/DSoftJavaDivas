package EasyBooking.LD;

import java.util.HashSet;
import java.util.Set;

public class Avion {
	private String codAvion;
	private Set<Asiento> asientos = new HashSet<Asiento>();
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
