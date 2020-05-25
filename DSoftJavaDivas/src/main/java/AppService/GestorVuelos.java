package AppService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import DAO.itfDAO;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Vuelo;
import Gateway.Gateway;
import Gateway.GatewayVuelos;
import Gateway.itfGatewayVuelos;
import ServiciosExternos.VuelosJSON;

public class GestorVuelos {
	
	private static itfDAO DAO;
	private itfGatewayVuelos gateVuelos;
	private Gateway gateGeneral;
	
	public GestorVuelos()
	{
		gateVuelos = new GatewayVuelos();
		
	}
	
	public List<Vuelo> getVuelos(){
		
		return gateVuelos.getVuelos();
	}
	public  ArrayList<Aeropuerto> getAeropuerto()
	{
		System.out.println("LEO AEROPUERTOS");
		//DAO.guardarObjeto(gateVuelos.getAeropuertos());
		ArrayList<Aeropuerto> lista= gateVuelos.getAeropuertos();
		 System.out.println("GESTOR"+lista.get(0).getNomAeropuerto());
		 
		 return lista;
		
	}
	
	public void newReserva(String Aeropuerto_Salida, String Aeropuerto_llegada)
	{
		
	}
	public ArrayList<Vuelo> Buscar(String origen, String destino, Date fecha)
	{
		return gateVuelos.Buscar_vuelos(origen, destino, fecha);
		
	}
	
	public void AplicarFiltro(String hora_ida_min, String hora_ida_max, String hora_vuelta_min,String hora_vuelta_max, double min_precio, double max_precio, double min_dur, double max_dur)
	{
		if (min_precio == 0) { min_precio =0; }
		if (max_precio == 0) { max_precio =10000; }
		if (min_dur == 0) { min_dur =0; }
		if (max_dur == 0) { max_dur =10; }
		final double precioMin = min_precio;
		final double precioMax = max_precio;
		
		List<Vuelo>Lista_Vuelos=getVuelos();
		Stream<Vuelo>vuelos=Lista_Vuelos.stream();
		Stream<Vuelo>vuelos_filtrados= vuelos.filter(v->(v.getPrecio()>=precioMin) && v.getPrecio()<=precioMax);
		Lista_Vuelos=vuelos_filtrados.collect(Collectors.toList());
		
	}
	
	public static void main(String[] args) {
		
		GestorVuelos g = new GestorVuelos();
		//g.getVuelos();
		System.out.println("main gv");
		g.getAeropuerto();
	
	}
	
}
