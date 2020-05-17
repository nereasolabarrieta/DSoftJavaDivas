package Gateway;

import ServiciosExternos.RestClient_Unmarshalling;

public class Gateway {
	
	String hostname = "192.168.6.31";
	String port_auth = "5000";
	String port_pay = "5001";
	String port_airlines = "5002";

	public void crearConexion()
	{
		RestClient_Unmarshalling c1 = new RestClient_Unmarshalling(hostname, port_auth);
		// Some requests to the microservices... check the microservices are online previously with curl! check the docs for this

		try {
			// All this are just ping requests
			c1.makeGetRequest("/");
			c1.makeGetRequest("/Authentication/Log_in");
			c1.makeGetRequest("/Authentication/Create_user");
			c1.makeGetRequest("/Authentication/Change_password");
			c1.makeGetRequest("/Authentication/Delete_user");

			// real requests

			// todo c1.makePostRequest("This is a client super complex message to send to server");
		} catch (Exception e) {
			System.out.println("Catched exception: " + e.getMessage());
		}


		RestClient_Unmarshalling c2 = new RestClient_Unmarshalling(hostname, port_pay);

		try {
			c2.makeGetRequest("/");
			c2.makeGetRequest("/Payments/Make_payment");
			c2.makeGetRequest("/Payments/Create_user");
			c2.makeGetRequest("/Payments/Update_currency");

			// todo c2.makePostRequest("This is a client super complex message to send to server");
		} catch (Exception e) {
			System.out.println("Catched exception: " + e.getMessage());
		}

		RestClient_Unmarshalling c3 = new RestClient_Unmarshalling(hostname, port_airlines);

		try {
			c3.makeGetRequest("/");

			// todo c1.makePostRequest("This is a client super complex message to send to server");
		} catch (Exception e) {
			System.out.println("Catched exception: " + e.getMessage());
		}
	}
	public void cerrarConexion()
	{
		
	}
}
