package Gateway;

import java.util.Date;

import javax.ws.rs.core.Response;

import EasyBooking.LD.Usuario;
import ServiciosExternos.PasswordJSON;
import ServiciosExternos.RestClient;

public class GatewayAutenticacion extends Gateway implements itfGatewayAutenticacion 
{
	static String ip = "192.168.6.31";
	static String port = "5000";
	static String serviceName = "DeustoAuth";
	private String path = "/";
	private RestClient<Usuario> client ;
	private Response response;
	
	@Override
	public void LogInUsuario(String email, String contrasena) {
		 path = "/Authentication/Log_in";
	        System.out.println("Trying POST at " + path + " (Log in service)");

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
        System.out.println("Trying POST at " + path + " (Create user)");

        PasswordJSON password = null;
        try {
            response =
                    client.makePostRequest(
                            client.createInvocationBuilder(path), new Usuario(nom,ape,email)
                    );
        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }

        String reply = response.readEntity(String.class);

        // Create a JSONObject to parse the respond inside the Simple_pass_result
        try {
            password = new PasswordJSON(reply);
        } catch (Exception e) {e.printStackTrace(); e.toString(); }

        path = "/Authentication/Change_password";
        System.out.println("Trying POST at " + path + " (Change password)");

        try {
            response =
                    client.makePostRequest(
                            client.createInvocationBuilder(path), new Usuario(nom, email,password.getContent(),passwordNew)
                    );
        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }




		
	}


}
