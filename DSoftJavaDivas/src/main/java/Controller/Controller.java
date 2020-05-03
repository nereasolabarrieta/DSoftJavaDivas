package Controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Usuario;
import EasyBooking.LD.Vuelo;
import EasyBooking.LP.LogIn;
import Remote.ServiceLocator;

public class Controller {
	
	private ServiceLocator rsl = null;
	
	public Controller() throws RemoteException 
	{
		rsl = new ServiceLocator();
		rsl.setService();
		new LogIn(this);
	}
	//Falta la implementacion de todos los métodos de la fachada así
	public List<Vuelo> getVuelos() throws RemoteException {
		
		return rsl.getService().getVuelos();
	}

	public List<Aeropuerto> getAeropuerto() throws RemoteException {
		return rsl.getService().getAeropuerto();
	}

	public void newReserva(String Aeropuerto_Salida, String Aeropuerto_llegada) throws RemoteException {
		rsl.getService().newReserva(Aeropuerto_Salida, Aeropuerto_llegada);
	}

	public void Pagar(double precio, String cod_vuelo) throws RemoteException {
		rsl.getService().Pagar(precio, cod_vuelo);
		
	}

	public void Buscar(String origen, String destino, Date fecha) {
		rsl.getService().Buscar(origen, destino, fecha);
	}

	public void AplicarFiltro(String origen, String destino, Date fecha, double min_precio, double max_precio) {
		rsl.getService().AplicarFiltro(origen, destino, fecha, min_precio, max_precio);
	}
	
	public void RegistrarUsuario(Usuario u1)
	{
		rsl.getService().RegistrarUsuario(u1);
	}
	public void LogInUsuario(Usuario u1)
	{
		rsl.getService().LogInUsuario(u1);
	}
	public void LogOut(Usuario u1)
	{
		rsl.getService().LogOut(u1);
	}
	
}
