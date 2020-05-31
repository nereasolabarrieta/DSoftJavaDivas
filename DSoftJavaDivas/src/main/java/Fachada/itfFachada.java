package Fachada;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import DTO.VueloDTO;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Usuario;
import EasyBooking.LD.Viajero;
import EasyBooking.LD.Vuelo;

public interface itfFachada extends Remote{
	
	//public List<Vuelo> getVuelos()throws RemoteException;//ese vuelo luego habra que convertirlo en DTOVuelo
	public HashSet<Aeropuerto> getAeropuertos()throws RemoteException;
	public void newReserva(String codVuelo,String origen, String destino, long precio, long asientos, LocalDateTime date, String email,
			Set<Viajero> viajeros) throws RemoteException;
	public void Pagar(double precio, String email, String concepto)throws RemoteException;
	public  ArrayList<Vuelo> Buscar_vuelos(String origen, String destino, String fecha)throws RemoteException;
	public  ArrayList<Vuelo>Aplicar_filtros(String origen, String destino,double precio, int viajeros, String fecha)throws RemoteException;
	public List<Vuelo> AplicarFiltro(String hora_ida_min, String hora_ida_max, double min_precio, double max_precio, String origen, String destino, Date fecha)throws RemoteException;
	public void RegistrarUsuario(String nom, String ape, String email, String password)throws RemoteException;
	public boolean LogInUsuario(String email, String contrasena)throws RemoteException;
	public void newViajero(Viajero v)throws RemoteException;
	void LogOut()throws RemoteException;
	void imprime()throws RemoteException;
	public List<Vuelo> getVuelos()throws RemoteException;
	public void RegistrarUsuarioPago(String nom, String ape, String email, double currency)throws RemoteException;
	public void GuardarObjeto(Object obj) throws RemoteException;
}
