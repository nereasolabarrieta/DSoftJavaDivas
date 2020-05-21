package AppService;

import java.util.Date;
import java.util.List;

import DAO.itfDAO;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Vuelo;
import Gateway.Gateway;
import Gateway.GatewayVuelos;
import Gateway.itfGatewayVuelos;

public class GestorVuelos {
	
	private itfDAO DAO;
	private itfGatewayVuelos gateVuelos;
	private Gateway gateGeneral;
	
	public GestorVuelos()
	{
		System.out.println(" tu que he llegado a vuelos");
		gateVuelos = new GatewayVuelos();
		//gateVuelos.search_flights();
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
