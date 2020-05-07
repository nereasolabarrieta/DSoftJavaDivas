package Gateway;

import EasyBooking.LD.Usuario;

public interface itfGatewayAutenticacion 
{
	public void RegistrarUsuario(Usuario u1);
	public void LogInUsuario(Usuario u1);
	public void LogOutUsuario(Usuario u1);
	public void Existe(Usuario u1);

}
