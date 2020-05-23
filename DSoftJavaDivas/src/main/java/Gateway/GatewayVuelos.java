package Gateway;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.apache.log4j.net.SyslogAppender;
import org.json.simple.JSONArray;
import EasyBooking.LD.Usuario;
import EasyBooking.LD.Vuelo;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Flight_parameters;
import ServiciosExternos.RestClient;
import ServiciosExternos.VuelosJSON;

public class GatewayVuelos extends Gateway implements itfGatewayVuelos
{
	private static String port = "5002";
	private static String hostname = "192.168.6.31";
	private String path = "/";
	private RestClient<Flight_parameters> client ;
	private Response response;
	private Flight_parameters filtro;

	
	
	public List<VuelosJSON> search_flights() {
		 path = "/Airlines/Search_Flights";
		 client = new RestClient<Flight_parameters>(hostname, port);
		 System.out.println("Trying POST at " + path + " (Search All Flights message)");
	        response = null;
	        try {
	            response =
	                    client.makePostRequest(
	                            client.createInvocationBuilder(path) , filtro
	                    );
	        }
	        catch (Exception e) { 
	        	e.printStackTrace(); e.toString(); 
	        	
	        	}
	        
	List<VuelosJSON> myFlightArray = null;

    try
    {
    	
        String json_string = response.readEntity(String.class);
        JSONParser myParser = new JSONParser();
        JSONArray flightsArray = (JSONArray) myParser.parse( json_string );

        // Lambda expression to print array
        flightsArray.stream().forEach(
                element -> System.out.println(element)
        );

        // Lambda expression to map JSONObjects inside JSONArray to flight objects
        myFlightArray = (List) flightsArray.stream()
                .map( element -> new VuelosJSON( element))
                .collect(Collectors.toList()
        );
//
//        System.out.println("\n\n ahora lo que imprime es: ");
//        System.out.println("Number of flights collected:");
//        System.out.println(myFlightArray.size());
//
//        System.out.println("Print some flight as string");
//        myFlightArray.get(0).print();
//
//        System.out.println("Print some random flight parameters");
//        System.out.println( myFlightArray.get(0).getAirportArrivalCity() );
//        System.out.println( myFlightArray.get(0).getAirportArrivalCode() );
//        System.out.println( myFlightArray.get(0).getAirportDepartureCity() );
//        System.out.println( myFlightArray.get(0).getAirportDepartureCode() );
//        System.out.println( myFlightArray.get(0).getCode() );
//        System.out.println( myFlightArray.get(0).getDepartureDate() );
//        System.out.println( myFlightArray.get(0).getDepartureDate( true) );
//        System.out.println( myFlightArray.get(0).getDepartureDate( false) );
//        System.out.println( myFlightArray.get(0).getFreeSeats());
//        System.out.println( myFlightArray.get(0).getTotalSeats());
//        System.out.println( myFlightArray.get(0).getPrice());

    } catch (Exception e) { 
    	System.out.println(" entro al catch");
    	e.printStackTrace();
    	e.toString(); 
    }
    return myFlightArray;
	}
	
	
	@Override
	public void Buscar_vuelos(String origen, String destino) 
	{
		filtro= new Flight_parameters(origen,destino);
		List<VuelosJSON> lista_json=search_flights();
		System.out.println("HA LLEGADO AL PASO PREVIO A CONVERTIR EN OBJETOS");
		ArrayList<Vuelo> lista_vuelos= convertir(lista_json);
		System.out.println("\n\n\n VOY A IMPRIMIR LOS VUELOS\n\n");
		lista_vuelos.stream().forEach( element->System.out.println(element));
		
		
	}

	public ArrayList<String>Lista_Aeropuertos()
	{
		ArrayList<String>Lista_AER= new ArrayList<>();
		return Lista_AER;
	}
	@Override
	public void AplicarFiltro(String origen, String destino, Date fecha, double min_precio, double max_precio) {
		// TODO Auto-generated method stub
		
	}


	public ArrayList<Vuelo> convertir(List<VuelosJSON> json)
	{
		ArrayList<Vuelo>Lista_vuelos= new ArrayList();
		json.stream().forEach(
				element-> {
					Aeropuerto origen= new Aeropuerto(element.getAirportArrivalCode(),element.getAirportArrivalCity());
					Aeropuerto destino= new Aeropuerto(element.getAirportDepartureCode(),element.getAirportDepartureCity());
					Vuelo v=new Vuelo(element.getCode(), origen, destino,element.getDepartureDate(true),element.getPrice());
					Lista_vuelos.add(v);
				});
		
		
		return Lista_vuelos;
	}
	
	@Override
	public List getVuelos() 
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void Buscar(String origen, String destino, Date fecha) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Set<Aeropuerto> getAeropuertos() 
	{
		filtro= new Flight_parameters();
		Set<Aeropuerto> Lista_aero=new HashSet();
		List<VuelosJSON> lista_json=search_flights();
		lista_json.stream().forEach(element->
		{
			Aeropuerto origen= new Aeropuerto(element.getAirportArrivalCode(),element.getAirportArrivalCity());
			Aeropuerto destino= new Aeropuerto(element.getAirportDepartureCode(),element.getAirportDepartureCity());
			Lista_aero.add(origen);
			Lista_aero.add(destino);
		});
		return Lista_aero;
	}
	
	

}
