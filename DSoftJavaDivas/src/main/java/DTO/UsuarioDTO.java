package DTO;

import java.io.Serializable;

import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.metodoPago;

public class UsuarioDTO implements Serializable
{
	private String dniUsuario;
	private String nomUsuario;

	
	public UsuarioDTO(String dniUsuario, String nomUsuario) 
	{
		super();
		this.dniUsuario = dniUsuario;
		this.nomUsuario = nomUsuario;
	}


	public String getDniUsuario() {
		return dniUsuario;
	}


	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}


	public String getNomUsuario() {
		return nomUsuario;
	}


	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	
}
