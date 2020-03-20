package EasyBooking.LD;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import java.util.HashSet;
import java.util.Set;

@PersistenceCapable
public class Viajero {
	@PrimaryKey
	private String dniViajero;
	private String nomViajero;
	private Set<Reserva> reservas = new HashSet<Reserva>();
	public String getDniViajero() {
		return dniViajero;
	}
	public void setDniViajero(String dniViajero) {
		this.dniViajero = dniViajero;
	}
	public String getNomViajero() {
		return nomViajero;
	}
	public void setNomViajero(String nomViajero) {
		this.nomViajero = nomViajero;
	}
	public Set<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}
	
}
