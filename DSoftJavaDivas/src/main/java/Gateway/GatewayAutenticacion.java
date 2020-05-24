package Gateway;

import java.util.Date;

import javax.ws.rs.core.Response;

import org.json.simple.parser.ParseException;

import EasyBooking.LD.User_A;
import ServiciosExternos.BooleanJSON;
import ServiciosExternos.PasswordJSON;
import ServiciosExternos.RestClient;
import scala.collection.mutable.SynchronizedSet;

public class GatewayAutenticacion extends Gateway implements itfGatewayAutenticacion 
{
	private static String port = "5000";
	private static String hostname = "192.168.6.31";
	private String path = "/";
	private RestClient<User_A> client ;
	private Response response;
	public GatewayAutenticacion()
	{
		
	}
	@Override
	public boolean LogInUsuario(String email, String password) {
		 	path = "/Authentication/Log_in";
		 	client = new RestClient<User_A>(hostname, port);
	        System.out.println("Trying POST at " + path);
	        String reply = "";
	        System.out.println(email);
	        System.out.println(password);
	        BooleanJSON resp=null;
	        try {
	            response =
	                    client.makePostRequest(
	                            client.createInvocationBuilder(path), new User_A(email, password)
	                    );
	        }
	        catch (Exception e) { e.printStackTrace(); e.toString(); }
	        reply = response.readEntity(String.class);
	        System.out.println("aqui si llega");
	        boolean respuesta=false;
	       
	        try {
	        	  resp = new BooleanJSON(reply);
	        	  respuesta= resp.getContentBoolean();
	        	  System.out.println("eeeeeeeeeeeee que me lo esta haciendo mal" + respuesta);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
	        
	       
	        System.out.println("RESPONSE" + reply);
	        return respuesta;
	}

	@Override
	public void LogOutUsuario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RegistrarUsuario(String nom, String ape, String email, String passwordNew) {
		path = "/Authentication/Create_user";
	 	client = new RestClient<User_A>(hostname, port);
        System.out.println("Trying POST at " + path);
        String reply = "";
        PasswordJSON password = null;
        try {
            response =
                    client.makePostRequest(
                            client.createInvocationBuilder(path), new User_A(nom,ape,email)
                    );
        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }
        System.out.println("HOLAAAAA");
        reply = response.readEntity(String.class);
        System.out.println("RESPONSE" + reply);
        // Create a JSONObject to parse the respond inside the Simple_pass_result
        try {
            password = new PasswordJSON(reply);
        } catch (Exception e) {e.printStackTrace(); e.toString(); }

        long pw = password.getContentNumber();
        path = "/Authentication/Change_password";
        client = new RestClient<User_A>(hostname, port);
        System.out.println("Trying PUT at " + path + " (Change password)");
      

        try {
            response =
                    client.makePutRequest(
                    	
                            client.createInvocationBuilder(path), new User_A( nom, ape,email,String.valueOf(pw),passwordNew)
                    );
        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }


        reply = response.readEntity(String.class);
        System.out.println("RESPONSE" + reply);

		
	}


}
