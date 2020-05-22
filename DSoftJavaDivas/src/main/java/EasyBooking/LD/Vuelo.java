package EasyBooking.LD;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.time.LocalDateTime;
import java.util.Date;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;


public class Vuelo {
	@PrimaryKey
	private String codVuelo;
	private Aeropuerto origen;
	private Aeropuerto destino; 
	private Aerolinea aerolinea;
	private Avion avion; 
	private double duracion;
	private Date hora_salida;
	private LocalDateTime hora_llegada; 
	private long precio;
	private String fecha;

	
	public Vuelo(String codigo, Aeropuerto origen, Aeropuerto destino,Aerolinea aerolinea, Avion avion, double duracion, Date hora_salida,
			LocalDateTime hora_llegada, long precio) {
		super();
		this.codVuelo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.avion = avion;
		this.duracion = duracion;
		this.hora_salida = hora_salida;
		this.hora_llegada = hora_llegada;
		this.precio = precio;
		this.aerolinea = aerolinea;
	}


	

	public Vuelo(String codVuelo, Aeropuerto origen, Aeropuerto destino, LocalDateTime hora_llegada, String Fecha,long precio) {
		super();
		this.codVuelo = codVuelo;
		this.origen = origen;
		this.destino = destino;
		this.hora_llegada = hora_llegada;
		this.precio = precio;
		this.fecha=Fecha;
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
	public Avion getAvion() {
		return avion;
	}
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	public Date getHora_salida() {
		return hora_salida;
	}
	public void setHora_salida(Date hora_salida) {
		this.hora_salida = hora_salida;
	}
	
	public long getPrecio() {
		return precio;
	}
	public void setPrecio(long precio) {
		this.precio = precio;
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	@Override
	public String toString() {
		return "Vuelo [codVuelo=" + codVuelo + ", origen=" + origen + ", destino=" + destino + ", aerolinea="
				+ aerolinea + ", avion=" + avion + ", duracion=" + duracion + ", hora_salida=" + hora_salida
				+ ", hora_llegada=" + hora_llegada + ", precio=" + precio + "]";
	}
	

	 
}
