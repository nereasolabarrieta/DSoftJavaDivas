package Gateway;

import java.awt.List;
import java.rmi.RemoteException;
import java.util.Date;

import EasyBooking.LD.Usuario;
import EasyBooking.LD.Vuelo;

public interface itfGatewayVuelos 
{
	public List getVuelos();
	public void Buscar(String origen, String destino, Date fecha);
	public void AplicarFiltro(String origen, String destino, Date fecha, double min_precio, double max_precio);

}
