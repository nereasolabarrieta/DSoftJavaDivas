package AppService;

import java.util.Date;
import java.util.List;

import DAO.itfDAO;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Vuelo;
import Gateway.Gateway;
import Gateway.itfGatewayVuelos;

public class GestorVuelos {
	
	itfDAO DAO;
	itfGatewayVuelos gateVuelos;
	Gateway gateGeneral;
	
	public GestorVuelos()
	{
		
	}
	public List<Vuelo> getVuelos(){
		return null;
		
	}
	public List<Aeropuerto> getAeropuerto(){
		return null;
		
	}
	
	public void newReserva(String Aeropuerto_Salida, String Aeropuerto_llegada)
	{
		
	}
	public void Buscar(String origen, String destino, Date fecha)
	{
		
	}
	
	public void AplicarFiltro(String origen, String destino, Date fecha, double min_precio, double max_precio)
	{
		
	}
}
