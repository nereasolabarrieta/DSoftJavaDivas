package AppService;

import java.util.Date;
import java.util.List;
import java.util.Set;

import DAO.itfDAO;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Vuelo;
import Gateway.Gateway;
import Gateway.GatewayVuelos;
import Gateway.itfGatewayVuelos;
import ServiciosExternos.VuelosJSON;

public class GestorVuelos {
	
	private static itfDAO DAO;
	private static itfGatewayVuelos gateVuelos;
	private Gateway gateGeneral;
	
	public GestorVuelos()
	{
		gateVuelos = new GatewayVuelos();
		
	}
	
	public void getVuelos(){
		
		gateVuelos.Buscar_vuelos("Bilbao", "Tabarnia");
	}
	public static Set<Aeropuerto> getAeropuerto()
	{
		System.out.println("LEO AEROPUERTOS");
		//DAO.guardarObjeto(gateVuelos.getAeropuertos());
		 Set<Aeropuerto> lista= gateVuelos.getAeropuertos();
		 System.out.println("GESTOR"+lista.size());
		 
		 return lista;
		
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
		//g.getVuelos();
		System.out.println("main gv");
		getAeropuerto();
	
	}
	
}
