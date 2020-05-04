package Gateway;

import java.util.Date;

import EasyBooking.LD.Usuario;

public interface itfGateway 
{
	public void Pagar(double precio, String cod_vuelo);
	public void Buscar(String origen, String destino, Date fecha);
	public void AplicarFiltro(String origen, String destino, Date fecha, double min_precio, double max_precio);
	public void RegistrarUsuario(Usuario u1);
	public void LogInUsuario(Usuario u1);
	public void LogOutUsuario(Usuario u1);

}
