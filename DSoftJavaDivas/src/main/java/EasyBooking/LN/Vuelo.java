package EasyBooking.LN;

public class Vuelo {

	private String codigo;
	private String origen; // poner tipo Aeropuerto
	private String destino; // poner tipo Aeropuerto
	private String avion;  // poner tipo avion
	private double duracion;
	private String hora_salida; //poner tipo date
	private String hora_llegada; //poner tipo date 
	private double precio;
	
	
	
	
	
	public Vuelo(String codigo, String origen, String destino, String avion, double duracion, String hora_salida,
			String hora_llegada, double precio) {
		super();
		this.codigo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.avion = avion;
		this.duracion = duracion;
		this.hora_salida = hora_salida;
		this.hora_llegada = hora_llegada;
		this.precio = precio;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getAvion() {
		return avion;
	}
	public void setAvion(String avion) {
		this.avion = avion;
	}
	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	public String getHora_salida() {
		return hora_salida;
	}
	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}
	public String getHora_llegada() {
		return hora_llegada;
	}
	public void setHora_llegada(String hora_llegada) {
		this.hora_llegada = hora_llegada;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
	 
}
