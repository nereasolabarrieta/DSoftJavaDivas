package AppService;

import Gateway.GatewayAutenticacion;
import Gateway.GatewayPago;
import Gateway.itfGatewayAutenticacion;
import Gateway.itfGatewayPago;

public class GestorPago {
	
	private static final GestorPago INSTANCE = new GestorPago();
	private static itfGatewayPago gateway;
	
	private GestorPago(){}
	
	 public static GestorPago getInstance() {
	    	gateway =GatewayPago.getInstance();
	    	return INSTANCE;
	    }
	 
	public void Pagar(double precio, String cod_vuelo)
	{
		
	}
}
