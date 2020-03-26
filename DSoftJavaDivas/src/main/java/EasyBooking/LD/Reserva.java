package EasyBooking.LD;

import java.util.HashSet;
import java.util.Set;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {
	
	@PrimaryKey
	private String codReserva;
	private Usuario usuario;
	private Vuelo vuelo;
	private Aerolinea aerolinea;
	private Set<Viajero> viajeros =new HashSet<Viajero>();

	
	
	public Reserva(String codReserva, Usuario usuario, Vuelo vuelo,Aerolinea aerolinea, Set<Viajero> viajeros) {
		super();
		this.codReserva = codReserva;
		this.usuario = usuario;
		this.aerolinea = aerolinea;
		this.vuelo = vuelo;
		this.viajeros = viajeros;
	}

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

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	
	
}
