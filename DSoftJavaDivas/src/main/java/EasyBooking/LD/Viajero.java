package EasyBooking.LD;

import java.util.HashSet;
import java.util.Set;

public class Viajero {
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
