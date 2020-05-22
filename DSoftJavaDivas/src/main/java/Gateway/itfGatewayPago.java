package Gateway;

public interface itfGatewayPago 
{
	public void Pagar(String email, double cantidad_total, String concepto);
	public void updateCurrency();

}
