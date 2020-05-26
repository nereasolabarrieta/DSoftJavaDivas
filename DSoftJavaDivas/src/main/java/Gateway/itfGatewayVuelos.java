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
	public List<Vuelo> getVuelos();
	public HashSet<Aeropuerto> getAeropuertos();
	public void AplicarFiltro(String origen, String destino, Date fecha, double min_precio, double max_precio);
	public List<VuelosJSON> search_flights();
	public ArrayList<Vuelo> Buscar_vuelos(String origen, String destino, Date fecha) ;

}
