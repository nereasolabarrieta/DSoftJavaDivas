package Gateway;

public interface itfGatewayPago 
{
	public void Pagar(String email, double cantidad_total, String concepto);
	public void updateCurrency(String email, double currency);
	public void RegistrarUsuarioPago(String nom, String ape, String email, double currency);

}
