package DAO;

import java.util.List;

import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Reserva;
import EasyBooking.LD.Usuario;

public interface itfDAO 
{
	public void guardarObjeto (Object objeto);
	public List<Aeropuerto>getAeropuertos();
	public List<Reserva>getReservas();
	public List<Usuario> getUsuarios();
	public void cerrarConexion();
	
}
