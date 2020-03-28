package EasyBooking.LD;

import java.util.HashSet;
import java.util.Set;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {
	
	@PrimaryKey
	private String codReserva;
	private Usuario usuario;
	private Aerolinea aerolinea;
	private Vuelo vuelo;
	@Persistent(mappedBy="Lista_Reservas")
	private Set<Viajero> viajeros;

	
	
	public Reserva(String codReserva, Usuario usuario, Set<Viajero> viajeros, Aerolinea aerolinea ) {
		super();
		this.codReserva = codReserva;
		this.usuario = usuario;
		this.aerolinea=aerolinea;
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


	
	
}
