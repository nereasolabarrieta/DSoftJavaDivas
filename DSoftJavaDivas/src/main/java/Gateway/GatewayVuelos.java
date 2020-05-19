package Gateway;

import java.util.List;

import javax.ws.rs.core.Response;

import java.util.Date;

import EasyBooking.LD.Usuario;
import EasyBooking.LD.Vuelo;
import EasyBooking.LD.Flight_parameters;
import ServiciosExternos.RestClient;

public class GatewayVuelos extends Gateway implements itfGatewayVuelos
{

	private String path = "/";
	private RestClient<Usuario> client ;
	private Response response;

	
	
	public void search_flights(String email, String contrasena) {
		 path = "/Airlines/Search_Flights";
		 System.out.println("Trying POST at " + path + " (Search All Flights message)");

	        response = null;
	        try {
//	            response =
//	                    client.makePostRequest(
//	                            client.createInvocationBuilder(path) , new Flight_parameters("Tabarnia","Donostia", 100)
//	                    );
	        }
	        catch (Exception e) { e.printStackTrace(); e.toString(); }
		
	}
	
	
	
	@Override
	public void Buscar(String origen, String destino, Date fecha) {
		// TODO Auto-generated method stub
		
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
