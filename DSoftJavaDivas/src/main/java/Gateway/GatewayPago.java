package Gateway;

import javax.ws.rs.core.Response;

import AppService.GestorPago;
import EasyBooking.LD.P_User;
import EasyBooking.LD.P_User;
import EasyBooking.LD.User_A;
import EasyBooking.LD.Usuario;
import ServiciosExternos.RestClient;

public class GatewayPago extends Gateway implements itfGatewayPago {
	private static String port = "5001";
	private static String hostname = "192.168.6.31";
	private String path = "/";
	private RestClient<P_User> client;
	private static final GatewayPago INSTANCE = new GatewayPago();

	private GatewayPago() {

	}

	public static GatewayPago getInstance() {
		return INSTANCE;

	}



	@Override
	public void Pagar(String email, double cantidad_total, String concepto) {

		// TODO Auto-generated method stub
		String emailPago = email;
		double cantPago = cantidad_total;
		String conceptoPago = concepto;
		

		
		path = "/Payments/Make_payment";
		client = new RestClient<>(hostname, port);

		try {
			client.simplePrint(client.makeGetRequest(client.createInvocationBuilder(path)));
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}

		
		try {
			client.simplePrint(client.makePostRequest(client.createInvocationBuilder(path),
					new P_User(emailPago, cantPago, conceptoPago)));
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}
	}



	public void RegistrarUsuarioPago(String nom, String ape, String email, double currency) {
	
		String nomusu = nom;
		String apeusu = ape;
		String emailusu = email;
		double currencyusu = currency;

		path = "/Payments/Create_user";
		client = new RestClient<>(hostname, port);

		try {
			client.simplePrint(client.makeGetRequest(client.createInvocationBuilder(path)));
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}

		try {
			client.simplePrint(client.makePostRequest(client.createInvocationBuilder(path),
					new P_User(nomusu, apeusu, emailusu, currencyusu)));
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}

		
	}

}
