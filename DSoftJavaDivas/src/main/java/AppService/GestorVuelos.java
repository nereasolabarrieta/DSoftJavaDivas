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
		gateVuelos = new GatewayVuelos();
		
	}
	
	public void getVuelos(){
		
		gateVuelos.Buscar_vuelos("Bilbao", "Tabarnia");
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
	
	public static void main(String[] args) {
		
		GestorVuelos g = new GestorVuelos();
		g.getVuelos();
	
	}
	
}
