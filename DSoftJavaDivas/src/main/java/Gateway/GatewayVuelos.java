package Gateway;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import org.json.simple.parser.JSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
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

public class GatewayVuelos implements itfGatewayVuelos {
	private static String port = "5002";
	private static String hostname = "192.168.6.31";
	private String path = "/";
	private RestClient<Flight_parameters> client;
	private Response response;
	private Flight_parameters filtro;
	private static final GatewayVuelos INSTANCE = new GatewayVuelos();

	private GatewayVuelos() {
	}

	public static GatewayVuelos getInstance() {
		return INSTANCE;
	}

	public List<VuelosJSON> search_flights() {
		path = "/Airlines/Search_Flights";

		client = new RestClient<Flight_parameters>(hostname, port);
		
		response = null;
		try {
			response = client.makePostRequest(client.createInvocationBuilder(path), filtro);
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();

		}

		List<VuelosJSON> myFlightArray = null;

		try {

			String json_string = response.readEntity(String.class);
			JSONParser myParser = new JSONParser();
			JSONArray flightsArray = (JSONArray) myParser.parse(json_string);

			myFlightArray = (List) flightsArray.stream().map(element -> new VuelosJSON(element))
					.collect(Collectors.toList());

		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}
		return myFlightArray;
	}

	@SuppressWarnings("unchecked")
	public List<VuelosJSON> search_flights_conParametros() {
		path = "/Airlines/Search_Flights";
		client = new RestClient<Flight_parameters>(hostname, port);
		
		response = null;
		try {
			response = client.makePostRequest(client.createInvocationBuilder(path), filtro);
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();

		}

		List<VuelosJSON> myFlightArray = null;

		try {

			String json_string = response.readEntity(String.class);
			JSONParser myParser = new JSONParser();
			JSONArray flightsArray = (JSONArray) myParser.parse(json_string);

			// Lambda expression to map JSONObjects inside JSONArray to flight
			// objects
			myFlightArray = (List) flightsArray.stream().map(element -> new VuelosJSON(element))
					.collect(Collectors.toList());

		} catch (Exception e) {

			e.printStackTrace();
			e.toString();
		}
		return myFlightArray;
	}

	@Override
	public ArrayList<Vuelo> Buscar_vuelos(String origen, String destino, String fecha) {

		filtro = new Flight_parameters(origen, destino, fecha);
		List<VuelosJSON> lista_json = search_flights_conParametros();

		ArrayList<Vuelo> lista_vuelos = convertir(lista_json);
		return lista_vuelos;
	}

	public ArrayList<Vuelo> convertir(List<VuelosJSON> json) {
		ArrayList<Vuelo> Lista_vuelos = new ArrayList();
		json.stream().forEach(element -> {
			Aeropuerto origen = new Aeropuerto(element.getAirportArrivalCode(), element.getAirportArrivalCity());
			Aeropuerto destino = new Aeropuerto(element.getAirportDepartureCode(), element.getAirportDepartureCity());
			Vuelo v = new Vuelo(element.getCode(), origen, destino, element.getDepartureDate(true), element.getPrice(),
					element.getFreeSeats());
	
			Lista_vuelos.add(v);
		});

		return Lista_vuelos;
	}

	@Override
	public HashSet<Aeropuerto> getAeropuertos() {

		filtro = new Flight_parameters();
		HashSet<Aeropuerto> Lista_aero = new HashSet<Aeropuerto>();
		List<VuelosJSON> lista_json = search_flights();
		List<Vuelo> vuelos = convertir(lista_json);
		vuelos.stream().forEach(element -> {
			Lista_aero.add(element.getOrigen());
			Lista_aero.add(element.getDestino());
		});

		return Lista_aero;
	}

	@Override
	public ArrayList<Vuelo> Aplicar_filtros(String origen, String destino, double precio, int viajeros, String fecha) {

		filtro = new Flight_parameters(origen, destino, viajeros, precio, fecha);
		List<VuelosJSON> lista_json = search_flights();
		ArrayList<Vuelo> lista_vuelos = convertir(lista_json);
		return lista_vuelos;

	}

}
