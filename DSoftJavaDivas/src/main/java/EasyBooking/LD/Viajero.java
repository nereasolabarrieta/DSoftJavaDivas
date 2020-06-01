package EasyBooking.LD;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@PersistenceCapable
public class Viajero implements Serializable {

	@Persistent(table = "RESERVA_VIAJERO") 
	@Join(column = "VIAJERO_ID")
	@Element(column = "RESERVA_ID") 
	private Set<Reserva> Lista_Reservas;

	@PrimaryKey
	private String dniViajero;
	private String nomViajero;

	public Viajero(String dniViajero, String nomViajero) {
		super();
		this.dniViajero = dniViajero;
		this.nomViajero = nomViajero;

	}

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

}
