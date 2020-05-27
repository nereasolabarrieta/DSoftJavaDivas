package EasyBooking.LD;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;


public class Vuelo implements Serializable {
	@PrimaryKey
	private String codVuelo;
	private Aeropuerto origen;
	private Aeropuerto destino; 
	private LocalDateTime hora_salida;
	private long precio;
	private long numAsientos;

	
	public LocalDateTime getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(LocalDateTime hora_salida) {
		this.hora_salida = hora_salida;
	}

	public long getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(long numAsientos) {
		this.numAsientos = numAsientos;
	}

	public Vuelo(String codigo, Aeropuerto origen, Aeropuerto destino,  LocalDateTime hora_salida,
			 long precio, long l) {
		super();
		this.codVuelo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.hora_salida = hora_salida;
		this.precio = precio;
		this.numAsientos =l;
	}

	@Override
	public String toString() {
		return "Vuelo [codVuelo=" + codVuelo + ", origen=" + origen + ", destino=" + destino + ", hora_salida="
				+ hora_salida + ", precio=" + precio + "]";
	}

	public String getCodVuelo() {
		return codVuelo;
	}
	public void setCodVuelo(String codVuelo) {
		this.codVuelo = codVuelo;
	}
	public Aeropuerto getOrigen() {
		return origen;
	}
	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}
	public Aeropuerto getDestino() {
		return destino;
	}
	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}	
	public long getPrecio() {
		return precio;
	}
	public void setPrecio(long precio) {
		this.precio = precio;
	}

	

	 
}
