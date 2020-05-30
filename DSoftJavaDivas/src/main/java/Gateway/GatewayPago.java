package Gateway;

import javax.ws.rs.core.Response;

import AppService.GestorPago;
import EasyBooking.LD.Pago_Usuario;
import EasyBooking.LD.User_A;
import EasyBooking.LD.Usuario;
import ServiciosExternos.RestClient;

public class GatewayPago extends Gateway implements itfGatewayPago {
	private static String port = "5001";
	private static String hostname = "192.168.6.31";
	private String path = "/";
	private RestClient<Pago_Usuario> client;
	private static final GatewayPago INSTANCE = new GatewayPago();

	private GatewayPago() {

	}

	public static GatewayPago getInstance() {
		return INSTANCE;

	}

	public void INICIO() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Payments Server test (GET) ");
        System.out.println("-------------------------------------------------------");

        String path = "/";
        System.out.println("Trying GET at " + path + " (Test message)");
        System.out.println("CURL call: curl http://127.0.0.1:5001/");

        // Note below we instantiate a RestClient generic class to be used with P_User class
        client = new RestClient<>(hostname, port);

        try {
                client.simplePrint(
                        client.makeGetRequest(
                                client.createInvocationBuilder(path)
                        )
                );
        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }
	}

	@Override
	public void Pagar(String email, double cantidad_total, String concepto) {
		INICIO();
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

		// Pago_Usuario pu ;
		try {
			client.simplePrint(client.makePostRequest(client.createInvocationBuilder(path),
					new Pago_Usuario(emailPago, cantPago, conceptoPago)));
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}
	}

	@Override
	public void updateCurrency(String email, double currency) {
		// TODO Auto-generated method stub

		path = "/Payments/Update_currency";
		client = new RestClient<>(hostname, port);

		try {
			client.simplePrint(
					client.makePostRequest(client.createInvocationBuilder(path), new Pago_Usuario(email, currency)));
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}

	}

	public void RegistrarUsuarioPago(String nom, String ape, String email, double currency) {
		INICIO();
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
					new Pago_Usuario(nomusu, apeusu, emailusu, currencyusu)));
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}

		System.out.println("Now that we have a user with currency we can perform a payment with success");

	}

}
