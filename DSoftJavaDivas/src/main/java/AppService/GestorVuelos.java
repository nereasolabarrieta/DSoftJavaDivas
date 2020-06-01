package AppService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import DAO.itfDAO;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Reserva;
import EasyBooking.LD.Usuario;
import EasyBooking.LD.Viajero;
import EasyBooking.LD.Vuelo;
import Gateway.GatewayPago;
import Gateway.GatewayVuelos;
import Gateway.itfGatewayVuelos;
import ServiciosExternos.VuelosJSON;
import DAO.*;

public class GestorVuelos {

	private static final GestorVuelos INSTANCE = new GestorVuelos();


	private GestorVuelos() {
	}

	public static GestorVuelos getInstance() {
		return INSTANCE;
	}
	
	public HashSet<Aeropuerto> getAeropuerto() 
	{
		HashSet<Aeropuerto> lista =GatewayVuelos.getInstance().getAeropuertos();

		return lista;

	}

	public void newReserva( Vuelo v, String email,Set<Viajero> viajeros)  {
		Usuario usuario = null;
		usuario=DAO.getInstance().BuscarUsuario(email);
		newViajero(viajeros);
		double valor = 100*Math.random();
		String codReserva = String.valueOf(valor);
		codReserva=codReserva+v.getCodVuelo()+email;
		
		Reserva r = new Reserva(codReserva, usuario, viajeros, v);
		DAO.getInstance().guardarObjeto(r);
	}
	
	public void newViajero(Set<Viajero> viajeros)
	{
		viajeros.stream().forEach(element->{
			DAO.getInstance().guardarObjeto(element);
		});
		
	}
	

	public ArrayList<Vuelo> Buscar(String origen, String destino, String fecha) {
		return GatewayVuelos.getInstance().Buscar_vuelos(origen, destino, fecha);
	}

	public ArrayList<Vuelo> Aplicar_filtros(String origen, String destino, double precio, int viajeros, String fecha) {
		return GatewayVuelos.getInstance().Aplicar_filtros(origen, destino, precio, viajeros, fecha);
	}


}
