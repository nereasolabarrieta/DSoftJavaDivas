package Gateway;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Usuario;
import EasyBooking.LD.Vuelo;
import ServiciosExternos.VuelosJSON;

public interface itfGatewayVuelos 
{
	public HashSet<Aeropuerto> getAeropuertos();
	public List<VuelosJSON> search_flights();
	public ArrayList<Vuelo> Buscar_vuelos(String origen, String destino, String fecha) ;
	public  ArrayList<Vuelo>Aplicar_filtros(String origen, String destino,double precio, int viajeros, String fecha);

}
