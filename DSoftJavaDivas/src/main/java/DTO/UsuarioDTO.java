package DTO;

import java.io.Serializable;

import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.metodoPago;

public class UsuarioDTO implements Serializable
{
	private String emailUsuario;
	private String nomUsuario;

	
	public UsuarioDTO(String dniUsuario, String nomUsuario) 
	{
		super();
		this.emailUsuario = emailUsuario;
		this.nomUsuario = nomUsuario;
	}



	public String getEmailUsuario() {
		return emailUsuario;
	}




	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}




	public String getNomUsuario() {
		return nomUsuario;
	}


	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	
}
