package Gateway;


import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import EasyBooking.LD.Usuario;
import EasyBooking.LD.Vuelo;

public interface itfGatewayVuelos 
{
	public List<Vuelo> getVuelos();
	public void Buscar(String origen, String destino, Date fecha);
	public void AplicarFiltro(String origen, String destino, Date fecha, double min_precio, double max_precio);
	public void search_flights();

}
