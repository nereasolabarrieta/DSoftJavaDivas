package AppService;

import DAO.DAO;
import DAO.itfDAO;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.User_A;
import EasyBooking.LD.Usuario;
import Gateway.Gateway;
import Gateway.GatewayAutenticacion;
import Gateway.itfGatewayAutenticacion;

public class GestorAutenticacion {

	private static itfGatewayAutenticacion gateway;
	Gateway general;
	private static final GestorAutenticacion INSTANCE = new GestorAutenticacion();

	private GestorAutenticacion() {
	}

	public static GestorAutenticacion getInstance() {
		gateway = GatewayAutenticacion.getInstance();
		return INSTANCE;
	}

	public void RegistrarUsuario(String nombre, String ape, String email, String password, Aeropuerto a) {

		gateway.RegistrarUsuario(nombre, ape, email, password);
		Usuario usuario = new Usuario(nombre, ape, email, password, a);
		DAO.getInstance().guardarObjeto(usuario);

	}

	public boolean LogInUsuario(String email, String contrasena) {
		return gateway.LogInUsuario(email, contrasena);
	}

	public void LogOut() {

	}
}
