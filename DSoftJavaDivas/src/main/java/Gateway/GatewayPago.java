package Gateway;

import javax.ws.rs.core.Response;

import EasyBooking.LD.Usuario;
import ServiciosExternos.RestClient;

public class GatewayPago extends Gateway implements itfGatewayPago
{
	private static String port = "5001";
	private static String hostname = "192.168.6.31";
	private String path = "/";
	private RestClient<Usuario> client ;
	private Response response;
	
	@Override
	public void Pagar(String email, double cantidad_total, String concepto) {
		// TODO Auto-generated method stub
	       path = "/Payments/Make_payment";
	       
        try {
            client.simplePrint(
                    client.makePostRequest(
                            client.createInvocationBuilder(path) , new Usuario(email, cantidad_total, concepto)
                    )
            );
        }
        catch (Exception e) { e.printStackTrace(); e.toString(); }
	}

	@Override
	public void updateCurrency() {
		// TODO Auto-generated method stub
		
	}

}
