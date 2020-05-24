package AppService;

import DAO.DAO;
import DAO.itfDAO;
import EasyBooking.LD.Usuario;
import Gateway.Gateway;
import Gateway.GatewayAutenticacion;
import Gateway.itfGatewayAutenticacion;

public class GestorAutenticacion {
	
	itfDAO DAO;
	itfGatewayAutenticacion gateway;
	Gateway general;
	
	public GestorAutenticacion()
	{
		gateway = new GatewayAutenticacion();
		
	}
	public void RegistrarUsuario(String nombre, String ape, String email, String password){
		
		
		gateway.RegistrarUsuario(nombre,ape, email, password);
	
	
	}
	public void LogInUsuario(String email, String contrasena){
		gateway.LogInUsuario(email, contrasena);
	}
	public void LogOut()
	{
		
	}
}
