package Fachada;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import AppService.GestorAutenticacion;
import AppService.GestorPago;
import AppService.GestorVuelos;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Usuario;
import EasyBooking.LD.Vuelo;



public class ServidorPrincipal extends UnicastRemoteObject implements itfFachada {

	private static final long serialVersionUID = 1L;
	private GestorAutenticacion GAutenticacion;
	private GestorPago GPago;
	private GestorVuelos GVuelos;
	
	protected ServidorPrincipal(GestorAutenticacion GAutenticacion,GestorPago GPago,GestorVuelos GVuelos) throws RemoteException {
		super();
		this.GAutenticacion=GAutenticacion;
		this.GPago=GPago;
		this.GVuelos=GVuelos;
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length != 3) {
			System.out.println("usage: java [policy] [codebase] server.Server [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try 
		{	
		
			Registry registry = LocateRegistry.createRegistry((Integer.valueOf(args[1])));
			GestorAutenticacion GAutenticacion = new GestorAutenticacion();
			GestorPago GPago = new GestorPago();
			GestorVuelos GVuelos = new GestorVuelos();
			//Naming.rebind(name, objServer);
			itfFachada objServer = new ServidorPrincipal(GAutenticacion, GPago, GVuelos);
			registry.rebind(name, objServer);
			System.out.println("* Server '" + name + "' active and waiting...");			
		} 
		catch (Exception e) 
		{
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public List<Vuelo> getVuelos() throws RemoteException {
		// TODO Auto-generated method stub
		
		return GVuelos.getVuelos();
	}

	@Override
	public List<Aeropuerto> getAeropuerto() throws RemoteException {
		// TODO Auto-generated method stub
		return GVuelos.getAeropuerto();
	}

	@Override
	public void newReserva(String Aeropuerto_Salida, String Aeropuerto_llegada) throws RemoteException {
		// TODO Auto-generated method stub
		GVuelos.newReserva(Aeropuerto_Salida, Aeropuerto_llegada);
	}

	@Override
	public void Pagar(double precio, String cod_vuelo) throws RemoteException {
		// TODO Auto-generated method stub
		GPago.Pagar(precio, cod_vuelo);
	}

	@Override
	public void Buscar(String origen, String destino, Date fecha) {
		// TODO Auto-generated method stub
		GVuelos.Buscar(origen, destino, fecha);
	}

	@Override
	public void AplicarFiltro(String origen, String destino, Date fecha, double min_precio, double max_precio) {
		// TODO Auto-generated method stub
		GVuelos.AplicarFiltro(origen, destino, fecha, min_precio, max_precio);
	}

	@Override
	public void RegistrarUsuario(Usuario u1) {
		// TODO Auto-generated method stub
		GAutenticacion.RegistrarUsuario(u1);
	}

	@Override
	public void LogInUsuario(Usuario u1) {
		// TODO Auto-generated method stub
		GAutenticacion.LogInUsuario(u1);
	}

	@Override
	public void LogOut(Usuario u1) {
		// TODO Auto-generated method stub
		GAutenticacion.LogOut(u1);
	}
	
	


}
