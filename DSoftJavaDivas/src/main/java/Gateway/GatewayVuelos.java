package Gateway;

import java.util.List;
import java.util.Date;

import EasyBooking.LD.Usuario;

public class GatewayVuelos extends Gateway implements itfGatewayVuelos
{

	@Override
	public void Buscar(String origen, String destino, Date fecha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AplicarFiltro(String origen, String destino, Date fecha, double min_precio, double max_precio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getVuelos() {
		// TODO Auto-generated method stub
		return null;
	}

}
