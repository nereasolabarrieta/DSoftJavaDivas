package DTO;

import EasyBooking.LD.Usuario;

public class UsuarioAssembler 
{
	public UsuarioDTO assembleToUsuarioDTO(Usuario u) 
	{

		UsuarioDTO uDTO = new UsuarioDTO(u.getNomUsuario(),u.getEmail());
		return uDTO;
	}
	

	

}
