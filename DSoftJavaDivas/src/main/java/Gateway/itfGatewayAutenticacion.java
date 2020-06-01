package Gateway;

import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Usuario;

public interface itfGatewayAutenticacion 
{
	public void RegistrarUsuario(String nom, String ape, String email, String password);
	public boolean LogInUsuario(String email, String contrasena);
	public void LogOutUsuario();


}
