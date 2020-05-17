package Gateway;

import EasyBooking.LD.Usuario;

public interface itfGatewayAutenticacion 
{
	public void RegistrarUsuario(String nom, String ape, String email, String password);
	public void LogInUsuario(String email, String contrasena);
	public void LogOutUsuario();
//	public void Existe(Usuario u1);

}
