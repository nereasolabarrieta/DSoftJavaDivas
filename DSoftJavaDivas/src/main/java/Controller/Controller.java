package Controller;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Usuario;
import EasyBooking.LD.Viajero;
import EasyBooking.LD.Vuelo;
import EasyBooking.LP.Entrar_Registrar;
import Remote.ServiceLocator;

public class Controller {

	private ServiceLocator rsl = null;

	public Controller() throws RemoteException {

		rsl = new ServiceLocator();
		rsl.setService();
		new Entrar_Registrar(this);
	}

	public HashSet<Aeropuerto> getAeropuertos() throws RemoteException {

		HashSet<Aeropuerto> lista = rsl.getService().getAeropuertos();
		return lista;
	}

	public void Pagar(double precio, String email, String concepto) throws RemoteException {
		rsl.getService().Pagar(precio, email, concepto);

	}

	public ArrayList<Vuelo> Buscar_vuelos(String origen, String destino, String fecha) throws RemoteException {
		return rsl.getService().Buscar_vuelos(origen, destino, fecha);
	}

	public ArrayList<Vuelo> Aplicar_filtros(String origen, String destino, double precio, int viajeros, String fecha)
			throws RemoteException {
		return rsl.getService().Aplicar_filtros(origen, destino, precio, viajeros, fecha);
	}

	public void RegistrarUsuario(String nom, String ape, String email, String password, Aeropuerto a) throws RemoteException {
		rsl.getService().RegistrarUsuario(nom, ape, email, password, a);
	}

	public boolean LogInUsuario(String email, String contrasena) throws RemoteException {
		return rsl.getService().LogInUsuario(email, contrasena);
	}
	
	public void RegistrarUsuarioPago(String nom, String ape, String email, double currency) throws RemoteException {
		rsl.getService().RegistrarUsuarioPago(nom, ape, email, currency);
	}

	public void newReserva(Vuelo v, String email,Set<Viajero> viajeros) throws RemoteException {
		rsl.getService().newReserva(v, email,viajeros);
		
	}
	
	public void LogOut() throws RemoteException
	{
		rsl.getService().LogOut();
	}


}
