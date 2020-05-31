package AppService;

import EasyBooking.LD.Viajero;
import Gateway.GatewayAutenticacion;
import Gateway.GatewayPago;
import Gateway.itfGatewayAutenticacion;
import Gateway.itfGatewayPago;

public class GestorPago {

	private static final GestorPago INSTANCE = new GestorPago();

	private GestorPago() {
	}

	public static GestorPago getInstance() {
		return INSTANCE;
	}

	public void Pagar(double precio, String email, String concepto) 
	{
		GatewayPago.getInstance().Pagar(email, precio, concepto);
	}

	public void RegistrarUsuarioPago(String nom, String ape, String email, double currency) 
	{
		// TODO Auto-generated method stub
		GatewayPago.getInstance().RegistrarUsuarioPago(nom, ape, email, currency);
	}
	public void newViajero(Viajero v)
	{
		DAO.DAO.getInstance().guardarObjeto(v);
	}
}
