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
import Gateway.Gateway;
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

	// gateVuelos = new GatewayVuelos();
	public List<Vuelo> getVuelos() {

		return GatewayVuelos.getInstance().getVuelos();
	}

	public HashSet<Aeropuerto> getAeropuerto() {

		// DAO.guardarObjeto(gateVuelos.getAeropuertos());
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

	public List<Vuelo> AplicarFiltro(String hora_ida_min, String hora_ida_max, double min_precio, double max_precio,
			String origen, String destino, Date fecha) {
		
		if (min_precio == 0) {
			min_precio = 0;
		}
		if (max_precio == 0) {
			max_precio = 10000;
		}
	
		final double precioMin = min_precio;
		final double precioMax = max_precio;
	
		int hora_min_comparar = Integer.parseInt(hora_ida_min.substring(0, 2));

		
		int hora_max_comparar = Integer.parseInt(hora_ida_max.substring(0, 2));
		
		List<Vuelo> Lista_Vuelos = getVuelos();
		// Stream<Vuelo>vuelos=Lista_Vuelos.stream();
		Stream<Vuelo> vuelos_filtrados = Lista_Vuelos.stream()
				.filter(v -> (v.getPrecio() >= precioMin) && v.getPrecio() <= precioMax);
		vuelos_filtrados = Lista_Vuelos.stream().filter(v -> (v.getOrigen().equals(origen)));
		vuelos_filtrados = Lista_Vuelos.stream().filter(v -> (v.getDestino().equals(destino)));
		vuelos_filtrados = Lista_Vuelos.stream().filter(v -> (fecha.after(java.sql.Timestamp.valueOf(v.toString()))
				&& fecha.equals(java.sql.Timestamp.valueOf(v.toString()))));
		vuelos_filtrados = Lista_Vuelos.stream().filter(v -> (v.getHora_salida().getHour() >= hora_min_comparar)
				&& v.getHora_salida().getHour() <= hora_max_comparar);

		Lista_Vuelos = vuelos_filtrados.collect(Collectors.toList());
		
		return Lista_Vuelos;

	}

	public static void main(String[] args) {

		GestorVuelos g = new GestorVuelos();
		// g.getVuelos();
		System.out.println("main gv");
		g.getAeropuerto();

	}

}
