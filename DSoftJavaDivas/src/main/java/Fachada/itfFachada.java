package Fachada;

import java.rmi.Remote;
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

public interface itfFachada extends Remote
{
	public HashSet<Aeropuerto> getAeropuertos()throws RemoteException;
	public void newReserva(Vuelo v, String email,Set<Viajero> viajeros) throws RemoteException;
	public void Pagar(double precio, String email, String concepto)throws RemoteException;
	public  ArrayList<Vuelo> Buscar_vuelos(String origen, String destino, String fecha)throws RemoteException;
	public  ArrayList<Vuelo>Aplicar_filtros(String origen, String destino,double precio, int viajeros, String fecha)throws RemoteException;
	public void RegistrarUsuario(String nom, String ape, String email, String password, Aeropuerto a)throws RemoteException;
	public boolean LogInUsuario(String email, String contrasena)throws RemoteException;
	void LogOut()throws RemoteException;
	public void RegistrarUsuarioPago(String nom, String ape, String email, double currency)throws RemoteException;
}
