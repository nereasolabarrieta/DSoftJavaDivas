package EasyBooking.LD;

import java.util.HashSet;
import java.util.Set;

public class Reserva {
	private String codReserva;
	private Usuario usuario;
	private Vuelo vuelo;
	private Set<Viajero> viajeros =new HashSet<Viajero>();

	public String getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(String codReserva) {
		this.codReserva = codReserva;
	}

	public Set<Viajero> getViajeros() {
		return viajeros;
	}

	public void setViajeros(Set<Viajero> viajeros) {
		this.viajeros = viajeros;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	
}
