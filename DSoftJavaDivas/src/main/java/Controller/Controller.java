package Controller;

import java.rmi.RemoteException;

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
//	public boolean RegistrarUsuario(Usuario nuevoUsuario) throws RemoteException {
//		
//		return rsl.getService().RegistrarUsuario(nuevoUsuario);
//	}
}
