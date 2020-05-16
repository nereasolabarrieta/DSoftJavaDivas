package Gateway;

import EasyBooking.LD.Usuario;

public interface itfGatewayAutenticacion 
{
	public void RegistrarUsuario(String nom, String ape, String email);
	public void LogInUsuario(String email, String contraseña);
	public void LogOutUsuario();
	public void Existe(Usuario u1);

}
