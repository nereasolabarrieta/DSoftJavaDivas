package Fachada;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import AppService.GestorAutenticacion;
import AppService.GestorPago;
import AppService.GestorVuelos;
import DAO.DAO;
import DTO.VueloDTO;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Usuario;
import EasyBooking.LD.Vuelo;



public class ServidorPrincipal extends UnicastRemoteObject implements itfFachada {

	private static final long serialVersionUID = 1L;
	private GestorAutenticacion GAutenticacion;
	private GestorPago GPago;
	private GestorVuelos GVuelos=null;
	private DAO dao;
	
	public ServidorPrincipal() throws RemoteException {
		super();
		System.out.println("ey estoy en el constructor y ahora voy a hacer los appservice jeeee");
		this.GAutenticacion=new GestorAutenticacion();
		this.GPago=new GestorPago();
		this.GVuelos=new GestorVuelos();
		//this.dao= new DAO();
		// TODO Auto-generated constructor stub
		
	}

	public static void main (String[] args) {
		// TODO Auto-generated method stub

		String ip = "127.0.0.1";
		String port = "1099";
		String serviceName = "EasyBooking";
		itfFachada objServer = null;
		try {
			objServer = new ServidorPrincipal();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + ip + ":" +port + "/" + serviceName;

		try 
		{	
			
			Registry registry = LocateRegistry.createRegistry((Integer.valueOf(port)));
			registry.rebind(name, objServer);
			System.out.println("* Server '" + name + "' active and waiting...");			
		} 
		catch (Exception e) 
		{
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
	}

//	@Override
//	public List<Vuelo> getVuelos() throws RemoteException {
//		// TODO Auto-generated method stub
//		
//		return GVuelos.getVuelos();
//	}


	public  ArrayList<Aeropuerto> getAeropuertos() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("HOLA 5");
		//Set<Aeropuerto> lista = new HashSet<Aeropuerto>();
		ArrayList<Aeropuerto> lista=GVuelos.getAeropuerto();
		System.out.println("SERVIDOR_PRINC " + lista.size());
		return lista;
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
	public void RegistrarUsuario(String nombre, String ape, String email, String password) {
		// TODO Auto-generated method stub
		GAutenticacion.RegistrarUsuario(nombre, ape, email, password);
	}



	@Override
	public void LogInUsuario(String email, String contrasena) {
		// TODO Auto-generated method stub
		System.out.println("A HACER LOGIN");
		GAutenticacion.LogInUsuario(email, contrasena);
	}

	@Override
	public void LogOut() {
		GAutenticacion.LogOut();
		
	}

	@Override
	public void newViajero(String dni, String nombre) {
		
	}
	
	public void imprime()
	{
		System.out.println("LLEGA BIEN A LA FACHADA");
	}

	@Override
	public List<VueloDTO> getVuelos() throws RemoteException {
		List<Vuelo> vuelo = GVuelos.getVuelos();
		return null;
	}
	
	


}
