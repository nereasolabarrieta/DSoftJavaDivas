package DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

import EasyBooking.LD.Aeropuerto;

public class VueloDTO implements Serializable {
	private String codVuelo;
	private Aeropuerto origen;
	private Aeropuerto destino;
	private LocalDateTime hora_salida;
	private double precio;

	public VueloDTO(String codigo, Aeropuerto origen, Aeropuerto destino, double duracion, LocalDateTime hora_salida,
			double precio) {
		super();
		this.codVuelo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.hora_salida = hora_salida;
		this.precio = precio;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public LocalDateTime getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(LocalDateTime hora_salida) {
		this.hora_salida = hora_salida;
	}

}
