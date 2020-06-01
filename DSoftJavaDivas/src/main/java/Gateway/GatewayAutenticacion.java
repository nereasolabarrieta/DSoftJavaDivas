package Gateway;

import java.util.Date;

import javax.ws.rs.core.Response;

import org.json.simple.parser.ParseException;

import AppService.GestorAutenticacion;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.User_A;
import ServiciosExternos.BooleanJSON;
import ServiciosExternos.PasswordJSON;
import ServiciosExternos.RestClient;
import scala.collection.mutable.SynchronizedSet;

public class GatewayAutenticacion implements itfGatewayAutenticacion {
	private static String port = "5000";
	private static String hostname = "192.168.6.31";
	private String path = "/";
	private RestClient<User_A> client;
	private Response response;
	private static final GatewayAutenticacion INSTANCE = new GatewayAutenticacion();

	private GatewayAutenticacion() {
	}

	public static GatewayAutenticacion getInstance() {
		return INSTANCE;
	}

	@Override
	public boolean LogInUsuario(String email, String password) {
		path = "/Authentication/Log_in";
		client = new RestClient<User_A>(hostname, port);
		
		String reply = "";
		BooleanJSON resp = null;
		try {
			response = client.makePostRequest(client.createInvocationBuilder(path), new User_A(email, password));
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}
		reply = response.readEntity(String.class);
		boolean respuesta = false;

		try {
			resp = new BooleanJSON(reply);
			respuesta = resp.getContentBoolean();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return respuesta;
	}

	@Override
	public void RegistrarUsuario(String nom, String ape, String email, String passwordNew) {
		path = "/Authentication/Create_user";
		client = new RestClient<User_A>(hostname, port);
	
		String reply = "";
		PasswordJSON password = null;
		try {
			response = client.makePostRequest(client.createInvocationBuilder(path), new User_A(nom, ape, email));
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}
		reply = response.readEntity(String.class);

		try {
			password = new PasswordJSON(reply);
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}
		long pw = password.getContentNumber();
		path = "/Authentication/Change_password";
		client = new RestClient<User_A>(hostname, port);
		

		try {
			response = client.makePutRequest(

					client.createInvocationBuilder(path), new User_A(nom, ape, email, String.valueOf(pw), passwordNew));
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}

		reply = response.readEntity(String.class);

	}

}
