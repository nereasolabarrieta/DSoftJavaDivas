package Gateway;

import javax.ws.rs.core.Response;

import EasyBooking.LD.Pago_Usuario;
import EasyBooking.LD.Usuario;
import ServiciosExternos.RestClient;

public class GatewayPago extends Gateway implements itfGatewayPago
{
	private static String port = "5001";
	private static String hostname = "192.168.6.31";
	private String path = "/";
	private RestClient<Pago_Usuario> client ;

	
	@Override
	public void Pagar(String email, double cantidad_total, String concepto) {
		// TODO Auto-generated method stub
	       path = "/Payments/Make_payment";
		 	client = new RestClient<Pago_Usuario>(hostname, port);

	       
        try {
            client.simplePrint(
                    client.makePostRequest(
                            client.createInvocationBuilder(path) , new Pago_Usuario(email, cantidad_total, concepto)
                    )
            );
        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }
	}

	@Override
	public void updateCurrency(String email, double currency) {
		// TODO Auto-generated method stub
		
        path = "/Payments/Update_currency";
	 	client = new RestClient<Pago_Usuario>(hostname, port);

        
        try {
            client.simplePrint(
                    client.makePostRequest(
                            client.createInvocationBuilder(path) , new Pago_Usuario(email,currency)
                    )
            );
        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }
		
	}

}
