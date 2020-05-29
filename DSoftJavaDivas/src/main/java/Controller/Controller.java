package Controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import DTO.VueloDTO;
import EasyBooking.LD.Aeropuerto;
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

	public List<Vuelo> getVuelos() throws RemoteException {

		return rsl.getService().getVuelos();
	}

	public HashSet<Aeropuerto> getAeropuertos() throws RemoteException {

		HashSet<Aeropuerto> lista = rsl.getService().getAeropuertos();
		return lista;
	}

	public void newReserva(String Aeropuerto_Salida, String Aeropuerto_llegada) throws RemoteException {
		rsl.getService().newReserva(Aeropuerto_Salida, Aeropuerto_llegada);
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

	// public List<Vuelo> AplicarFiltro(String hora_ida_min, String
	// hora_ida_max,
	// double min_precio, double max_precio, String origen, String destino, Date
	// fecha) throws RemoteException {
	// return rsl.getService().AplicarFiltro(hora_ida_min, hora_ida_max,
	// min_precio, max_precio, origen, destino, fecha);
	// }

	public void RegistrarUsuario(String nom, String ape, String email, String password) throws RemoteException {
		rsl.getService().RegistrarUsuario(nom, ape, email, password);
	}

	public boolean LogInUsuario(String email, String contrasena) throws RemoteException {
		return rsl.getService().LogInUsuario(email, contrasena);
	}
	
	public void RegistrarUsuarioPago(String nom, String ape, String email, double currency) throws RemoteException {
		rsl.getService().RegistrarUsuarioPago(nom, ape, email, currency);
	}

}
