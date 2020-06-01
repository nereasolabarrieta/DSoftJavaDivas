package Fachada;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import AppService.GestorAutenticacion;
import AppService.GestorPago;
import AppService.GestorVuelos;
import DAO.DAO;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Usuario;
import EasyBooking.LD.Viajero;
import EasyBooking.LD.Vuelo;

public class ServidorPrincipal extends UnicastRemoteObject implements itfFachada {

	private static final long serialVersionUID = 1L;
	private static ServidorPrincipal INSTANCE = null;

	private ServidorPrincipal() throws RemoteException 
	{

	}

	public static ServidorPrincipal getInstance() throws RemoteException {
		synchronized (ServidorPrincipal.class) {
			if (INSTANCE == null) {
				INSTANCE = new ServidorPrincipal();
			}
		}
		return INSTANCE;
	}

	public static void main(String[] args) 
	{	
		String ip = "127.0.0.1";
		String port = "1099";
		String serviceName = "EasyBooking";
		itfFachada objServer = null;
		try {
			objServer = ServidorPrincipal.getInstance();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + ip + ":" + port + "/" + serviceName;

		try {

			Registry registry = LocateRegistry.createRegistry((Integer.valueOf(port)));
			registry.rebind(name, objServer);
			System.out.println("* Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public HashSet<Aeropuerto> getAeropuertos() throws RemoteException {

		return GestorVuelos.getInstance().getAeropuerto();
	}

	@Override
	public void Pagar(double precio, String email, String concepto) throws RemoteException {
		// TODO Auto-generated method stub
		GestorPago.getInstance().Pagar(precio, email, concepto);
	}

	@Override
	public ArrayList<Vuelo> Buscar_vuelos(String origen, String destino, String fecha) {
		// TODO Auto-generated method stub

		return GestorVuelos.getInstance().Buscar(origen, destino, fecha);
	}

	public ArrayList<Vuelo> Aplicar_filtros(String origen, String destino, double precio, int viajeros, String fecha)
			throws RemoteException {
		return GestorVuelos.getInstance().Aplicar_filtros(origen, destino, precio, viajeros, fecha);
	}

	@Override
	public void RegistrarUsuario(String nombre, String ape, String email, String password, Aeropuerto a) {
		// TODO Auto-generated method stub
		GestorAutenticacion.getInstance().RegistrarUsuario(nombre, ape, email, password, a);
	}

	@Override
	public boolean LogInUsuario(String email, String contrasena) {
		return GestorAutenticacion.getInstance().LogInUsuario(email, contrasena);
	}

	@Override
	public void LogOut() {
		GestorAutenticacion.getInstance().LogOut();

	}

	@Override
	public void RegistrarUsuarioPago(String nom, String ape, String email, double currency) {
		
		GestorPago.getInstance().RegistrarUsuarioPago(nom, ape, email, currency);
		
	}

	@Override
	public void newReserva(Vuelo v,  String email,Set<Viajero> viajeros) throws RemoteException {
		GestorVuelos.getInstance().newReserva(v, email, viajeros);
		
	}


}
