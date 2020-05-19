package Gateway;

import javax.ws.rs.core.Response;

import EasyBooking.LD.Usuario;
import ServiciosExternos.RestClient;

public class GatewayPago extends Gateway implements itfGatewayPago
{

	private String path = "/";
	private RestClient<Usuario> client ;
	private Response response;
	
	@Override
	public void Pagar(double precio, String cod_vuelo) {
		// TODO Auto-generated method stub
	       path = "/Payments/Make_payment";
	       
        try {
            client.simplePrint(
                    client.makePostRequest(
                            client.createInvocationBuilder(path) , new Usuario("inigo.lopezgazpio@deusto.es", 100, "Hello World Payment")
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
