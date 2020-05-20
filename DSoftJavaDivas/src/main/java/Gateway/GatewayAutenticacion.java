package Gateway;

import java.util.Date;

import javax.ws.rs.core.Response;

import EasyBooking.LD.Usuario;
import ServiciosExternos.PasswordJSON;
import ServiciosExternos.RestClient;

public class GatewayAutenticacion extends Gateway implements itfGatewayAutenticacion 
{
	private static String port = "5000";
	private static String hostname = "192.168.6.31";
	private String path = "/";
	private RestClient<Usuario> client ;
	private Response response;
	public GatewayAutenticacion()
	{
		
	}
	@Override
	public void LogInUsuario(String email, String contrasena) {
		 	path = "/Authentication/Log_in";
		 	client = new RestClient<Usuario>(hostname, port);
	        Response response = null;
	        try {
	            response =
	                    client.makePostRequest(
	                            client.createInvocationBuilder(path) , new Usuario(email, contrasena)

	            );
	        }
	        catch (Exception e) { e.printStackTrace(); e.toString(); }
	        client.simplePrint(response);
		
	}

	@Override
	public void LogOutUsuario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RegistrarUsuario(String nom, String ape, String email, String passwordNew) {
		path = "/Authentication/Create_user";
	 	client = new RestClient<Usuario>(hostname, port);
        System.out.println("Trying POST at " + path);

        PasswordJSON password = null;
        try {
            response =
                    client.makePostRequest(
                            client.createInvocationBuilder(path), new Usuario(nom,ape,email)
                    );
        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }
        System.out.println("HOLAAAAA");
        String reply = response.readEntity(String.class);
        System.out.println("RESPONSE" + reply);
        // Create a JSONObject to parse the respond inside the Simple_pass_result
        try {
            password = new PasswordJSON(reply);
        } catch (Exception e) {e.printStackTrace(); e.toString(); }

        path = "/Authentication/Change_password";
        System.out.println("Trying POST at " + path + " (Change password)");

        try {
            response =
                    client.makePutRequest(
                            client.createInvocationBuilder(path), new Usuario(nom, email,password.getContent(),passwordNew)
                    );
        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }




		
	}


}
