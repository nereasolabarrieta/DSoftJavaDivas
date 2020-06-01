package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import AppService.GestorAutenticacion;
import AppService.GestorVuelos;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Reserva;
import EasyBooking.LD.Usuario;
import EasyBooking.LD.Viajero;
import EasyBooking.LD.Vuelo;
import Gateway.GatewayAutenticacion;

public class DAO{
	private static PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	private static PersistenceManager persistentManager= persistentManagerFactory.getPersistenceManager();;
	private static Transaction transaction= persistentManager.currentTransaction();
	private static GestorVuelos gv;
	private static final DAO INSTANCE = new DAO();

	private DAO() {
	}

	public static DAO getInstance() {

//		persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
//		persistentManager = persistentManagerFactory.getPersistenceManager();
//		transaction = persistentManager.currentTransaction();
		return INSTANCE;
	}

	@SuppressWarnings("unchecked")
	public void guardarObjeto(Object objeto) {
		try {
			if (objeto instanceof Aeropuerto) {
			
				List<Aeropuerto> aeropuertos = (List<Aeropuerto>) objeto;
				for (Aeropuerto a : aeropuertos) {
					a = new Aeropuerto(a.getCodAeropuerto(), a.getNomAeropuerto());
					persistentManager.makePersistent(a);
				}

			}
			
			if (objeto instanceof Viajero) {
				
				objeto = new Viajero(((Viajero) objeto).getDniViajero(), (((Viajero) objeto).getNomViajero()));
				persistentManager.makePersistent(objeto);

			}

			if (objeto instanceof Reserva) {
					objeto = new Reserva(((Reserva) objeto).getCodReserva(), ((Reserva) objeto).getUsuario(), ((Reserva) objeto).getViajeros(), ((Reserva) objeto).getVuelo());
					persistentManager.makePersistent(objeto);
				}	
			if (objeto instanceof Usuario) 
			{
				System.out.println(((Usuario) objeto).getAeropuerto().getCodAeropuerto());
					objeto = new Usuario(((Usuario) objeto).getNomUsuario(), ((Usuario) objeto).getApe(), ((Usuario) objeto).getEmail(), ((Usuario) objeto).getPassword(), ((Usuario) objeto).getAeropuerto());
					persistentManager.makePersistent(objeto);


			}

			} catch (Exception ex) {
			
			System.err.println("* Exception inserting data into db: " + ex.getMessage());
		}

		finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}

	}

	public List<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		Extent<Usuario> extent = persistentManager.getExtent(Usuario.class, false);
		List<Usuario> usuarios= new ArrayList<Usuario>();

		for (Usuario p : extent) {
			usuarios.add(p);
		}
		extent.closeAll();
		return usuarios;
	}

	public void cerrarConexion() 
	{
		persistentManager.close();
	}
	
	public Usuario BuscarUsuario(String email)
	{
		List <Usuario> usuarios = getUsuarios();
		Usuario usuario=null;
		for (Usuario u: usuarios){
			if (u.getEmail().equals(email))
			{
				usuario = new Usuario(u.getNomUsuario(), u.getApe(), u.getEmail(), u.getPassword(), u.getAeropuerto());
			}
		}
		return usuario;
	}

}
