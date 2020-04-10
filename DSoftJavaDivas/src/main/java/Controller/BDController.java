package Controller;

import EasyBooking.LN.GestorBD;

public class BDController 
{
	private GestorBD bd;
	
	public void LeerAerolineas()
	{
		bd.LeerAerolineasBD();
	}
	public void LeerAeropuertos()
	{
		bd.LeerAeropuertosBD();
	}
	public void LeerReservas()
	{
		bd.LeerReservasBD();
	}
	public void LeerUsuarios()
	{
		bd.LeerUsuariosBD();
	}
	public void LeerViajeros()
	{
		bd.LeerViajerosBD();
	}
	public void crearReserva()
	{
		bd.crearReserva();
	}
	public void crearViajero()
	{
		bd.crearViajero();
	}
}
