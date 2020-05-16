package DTO;

import java.io.Serializable;
import java.util.Date;

import EasyBooking.LD.Aerolinea;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Avion;

public class VueloDTO implements Serializable
{
	private String codVuelo;
	private Aeropuerto origen;
	private Aeropuerto destino; 
	private Aerolinea aerolinea;
	private double duracion;
	private Date hora_salida;
	private Date hora_llegada; 
	private double precio;

	
	public VueloDTO(String codigo, Aeropuerto origen, Aeropuerto destino,Aerolinea aerolinea, double duracion, Date hora_salida,
			Date hora_llegada, double precio) 
	{
		super();
		this.codVuelo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.duracion = duracion;
		this.hora_salida = hora_salida;
		this.hora_llegada = hora_llegada;
		this.precio = precio;
		this.aerolinea = aerolinea;
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


	public Aerolinea getAerolinea() {
		return aerolinea;
	}


	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
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


	public Date getHora_llegada() {
		return hora_llegada;
	}


	public void setHora_llegada(Date hora_llegada) {
		this.hora_llegada = hora_llegada;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
