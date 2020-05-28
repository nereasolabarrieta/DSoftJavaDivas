package AppService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import DAO.itfDAO;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Vuelo;
import Gateway.Gateway;
import Gateway.GatewayPago;
import Gateway.GatewayVuelos;
import Gateway.itfGatewayVuelos;
import ServiciosExternos.VuelosJSON;

public class GestorVuelos {
	
	private static itfDAO DAO;
	private static itfGatewayVuelos gateVuelos;
	private Gateway gateGeneral;
	private static final GestorVuelos INSTANCE = new GestorVuelos();
	
	private GestorVuelos(){}
	
	 public static GestorVuelos getInstance() {
		 gateVuelos =GatewayVuelos.getInstance();
	    	return INSTANCE;
	    }
	
	//gateVuelos = new GatewayVuelos();
	public List<Vuelo> getVuelos(){
		
		return gateVuelos.getVuelos();
	}
	public  HashSet<Aeropuerto> getAeropuerto()
	{
	
		//DAO.guardarObjeto(gateVuelos.getAeropuertos());
		HashSet<Aeropuerto> lista= gateVuelos.getAeropuertos();
		 
		 return lista;
		
	}
	
	public void newReserva(String Aeropuerto_Salida, String Aeropuerto_llegada)
	{
		
	}
	public ArrayList<Vuelo> Buscar(String origen, String destino, String fecha)
	{
		return gateVuelos.Buscar_vuelos(origen, destino, fecha);
		
	}
	
	public List<Vuelo> AplicarFiltro(String hora_ida_min, String hora_ida_max, double min_precio, double max_precio, String origen, String destino, Date fecha)
	{ System.out.println("HEMEN SARTZEN NAIZ METODO HASIERAN");
		if (min_precio == 0) { min_precio =0; }
		if (max_precio == 0) { max_precio =10000; }
		System.out.println("If ak ta gero arazorik ez");
		final double precioMin = min_precio;
		final double precioMax = max_precio;
		System.out.println("HEMEN SARTZEN DA!!!!!");
		int hora_min_comparar= Integer.parseInt(hora_ida_min.substring(0, 2));
		
		System.out.println("ZE GERTATZEN DA HEMEN: " + hora_min_comparar);
		int hora_max_comparar=Integer.parseInt(hora_ida_max.substring(0, 2));
		System.out.println("ZE GERTATZEN DA HEMEN: " + hora_max_comparar);
		
		List<Vuelo>Lista_Vuelos=getVuelos();
		//Stream<Vuelo>vuelos=Lista_Vuelos.stream();
		Stream<Vuelo>vuelos_filtrados= Lista_Vuelos.stream().filter(v->(v.getPrecio()>=precioMin) && v.getPrecio()<=precioMax);
		vuelos_filtrados= Lista_Vuelos.stream().filter(v->(v.getOrigen().equals(origen)));
		vuelos_filtrados= Lista_Vuelos.stream().filter(v->(v.getDestino().equals(destino)));
		vuelos_filtrados= Lista_Vuelos.stream().filter(v->(fecha.after(java.sql.Timestamp.valueOf(v.toString()))&& fecha.equals(java.sql.Timestamp.valueOf(v.toString()))));
		vuelos_filtrados=Lista_Vuelos.stream().filter(v->(v.getHora_salida().getHour()>=hora_min_comparar) && v.getHora_salida().getHour()<=hora_max_comparar);
		
		Lista_Vuelos=vuelos_filtrados.collect(Collectors.toList());
		System.out.println( "METODOTIK IRTETEN: Vuelo kopurua=" + (Lista_Vuelos.size()));
		return Lista_Vuelos;
		
	}
	
	public static void main(String[] args) {
		
		GestorVuelos g = new GestorVuelos();
		//g.getVuelos();
		System.out.println("main gv");
		g.getAeropuerto();
	
	}
	
}
