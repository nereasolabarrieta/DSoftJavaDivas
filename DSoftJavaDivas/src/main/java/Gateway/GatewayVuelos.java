package Gateway;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import org.json.simple.parser.JSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	private static final GatewayVuelos INSTANCE = new GatewayVuelos();

	
	private GatewayVuelos(){}
	
	public static GatewayVuelos getInstance() {
    	return INSTANCE;
    }
	
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
//        flightsArray.stream().forEach(
//                element -> System.out.println(element)
//        );

        // Lambda expression to map JSONObjects inside JSONArray to flight objects
        myFlightArray = (List) flightsArray.stream()
                .map( element -> new VuelosJSON( element))
                .collect(Collectors.toList()
        );

        System.out.println("\n\n ahora lo que imprime es: ");
        System.out.println("Number of flights collected:");
        System.out.println(myFlightArray.size());


    } catch (Exception e) { 
    	System.out.println(" entro al catch");
    	e.printStackTrace();
    	e.toString(); 
    }
    return myFlightArray;
	}
	public List<VuelosJSON> search_flights_conParametros( ) {
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



       // Lambda expression to map JSONObjects inside JSONArray to flight objects
       myFlightArray = (List) flightsArray.stream()
               .map( element -> new VuelosJSON( element))
               .collect(Collectors.toList()
       );

       System.out.println("\n\n ahora lo que imprime es: ");
       System.out.println("Number of flights collected:");
       System.out.println(myFlightArray.size());


   } catch (Exception e) { 
   	System.out.println(" entro al catch");
   	e.printStackTrace();
   	e.toString(); 
   }
   return myFlightArray;
	}
	
	@Override
	public ArrayList<Vuelo> Buscar_vuelos(String origen, String destino, String fecha) 
	{
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
//		String strDate = dateFormat.format(fecha);
		
		System.out.println("LA FECHA QUE envio ES"+fecha);
		filtro= new Flight_parameters(origen,destino,fecha);
		List<VuelosJSON> lista_json=search_flights_conParametros();
		
		ArrayList<Vuelo> lista_vuelos= convertir(lista_json);
		lista_vuelos.stream().forEach( element->System.out.println(element));
		return lista_vuelos;
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
					System.out.println("EN ESTE FORMATO" +element.getDepartureDate());
					Vuelo v=new Vuelo(element.getCode(), origen, destino,element.getDepartureDate(true),element.getPrice(), element.getFreeSeats());
					Lista_vuelos.add(v);
				});
		
		
		return Lista_vuelos;
	}
	
	@Override
	public List<Vuelo> getVuelos() 
	{

		filtro= new Flight_parameters();
		List<VuelosJSON> lista_json=search_flights();
		System.out.println("HA LLEGADO AL PASO PREVIO A CONVERTIR EN OBJETOS");
		ArrayList<Vuelo> lista_vuelos= convertir(lista_json);
		System.out.println("\n\n\n VOY A IMPRIMIR LOS VUELOS\n\n");
		lista_vuelos.stream().forEach( element->System.out.println(element));
		return lista_vuelos;
	}


	@Override
	public HashSet<Aeropuerto> getAeropuertos() 
	{

		filtro= new Flight_parameters();
		HashSet<Aeropuerto> Lista_aero=new HashSet<Aeropuerto>();
		List<VuelosJSON> lista_json=search_flights();
		List <Vuelo> vuelos = convertir(lista_json);
		vuelos.stream().forEach(element->
		{
			Lista_aero.add(element.getOrigen());
			Lista_aero.add(element.getDestino());
		});
		
		
		return Lista_aero;
	}
	
	

}
