package Gateway;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.Date;
import org.json.simple.JSONArray;
import EasyBooking.LD.Usuario;
import EasyBooking.LD.Vuelo;
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

	
	
	public void search_flights() {
		
		System.out.println("entro al serachflights");
		 path = "/Airlines/Search_Flights";
		 client = new RestClient<Flight_parameters>(hostname, port);
		 System.out.println("Trying POST at " + path + " (Search All Flights message)");

	        response = null;
	        try {
	            response =
	                    client.makePostRequest(
	                            client.createInvocationBuilder(path) , new Flight_parameters("Tabarnia","Bilbao")
	                    );
	        }
	        catch (Exception e) { e.printStackTrace(); e.toString(); System.out.println("estoy entrando al catch y por eso te dan los demas errores guapa");}
	        
	
	System.out.println("ee que llego justo antes del array");
	List<VuelosJSON> myFlightArray = null;
	System.out.println("y del try");
    try
    {
    	System.out.println("flipalo que entro al try");
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

        System.out.println("Number of flights collected:");
        System.out.println(myFlightArray.size());

        System.out.println("Print some flight as string");
        myFlightArray.get(0).print();

        System.out.println("Print some random flight parameters");
        System.out.println( myFlightArray.get(0).getAirportArrivalCity() );
        System.out.println( myFlightArray.get(0).getAirportArrivalCode() );
        System.out.println( myFlightArray.get(0).getAirportDepartureCity() );
        System.out.println( myFlightArray.get(0).getAirportDepartureCode() );
        System.out.println( myFlightArray.get(0).getCode() );
        System.out.println( myFlightArray.get(0).getDepartureDate() );
        System.out.println( myFlightArray.get(0).getDepartureDate( true) );
        System.out.println( myFlightArray.get(0).getDepartureDate( false) );
        System.out.println( myFlightArray.get(0).getFreeSeats());
        System.out.println( myFlightArray.get(0).getTotalSeats());
        System.out.println( myFlightArray.get(0).getPrice());

    } catch (Exception e) { e.printStackTrace(); e.toString(); }
    System.out.println(" no entro al try y por eso no imprimo julio");
	}
	
	
	@Override
	public void Buscar(String origen, String destino, Date fecha) {
		
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

	@Override
	public List getVuelos() {
		// TODO Auto-generated method stub
		return null;
	}

}
