package DAO;

import java.util.List;

import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Reserva;

public interface itfDAO 
{
	public void guardarObjeto (Object objeto);
	public List<Aeropuerto>getAeropuertos();
	public List<Reserva>getReservas();
	public void cerrarConexion();
	
}
