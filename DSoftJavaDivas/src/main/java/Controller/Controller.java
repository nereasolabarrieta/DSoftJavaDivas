package Controller;

import java.rmi.RemoteException;

import EasyBooking.LD.Usuario;
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

	
//	public void newReserva(String Aeropuerto_Salida, String Aeropuerto_llegada)throws RemoteException 
//	{
//		return rsl.getService().newReserva(Aeropuerto_llegada, Aeropuerto_llegada);
//	}
	
	
}
