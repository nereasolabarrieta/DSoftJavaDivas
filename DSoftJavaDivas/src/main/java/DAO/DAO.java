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

public class DAO implements itfDAO {
	private static PersistenceManager persistentManager;
	private static Transaction transaction;
	private static PersistenceManagerFactory persistentManagerFactory;
	private static GestorVuelos gv;
	private static final DAO INSTANCE = new DAO();

	private DAO() {
	}

	public static DAO getInstance() {

		persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		return INSTANCE;
	}

	@SuppressWarnings("unchecked")
	public void guardarObjeto(Object objeto) {
		// persistentManagerFactory =
		// JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		// persistentManager = persistentManagerFactory.getPersistenceManager();
		// transaction = persistentManager.currentTransaction();
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
				System.out.println("ey llega al instanceof de usuario");
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

			// persistentManager.close();
		}

	}

	@Override
	public List<Aeropuerto> getAeropuertos() {
		// TODO Auto-generated method stub
		Extent<Aeropuerto> extent = persistentManager.getExtent(Aeropuerto.class, false);
		List<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();

		for (Aeropuerto p : extent) {
			aeropuertos.add(p);
		}
		extent.closeAll();
		return aeropuertos;
	}
	@Override
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
	@Override
	public List<Reserva> getReservas() {
		// TODO Auto-generated method stub
		Extent<Reserva> extent = persistentManager.getExtent(Reserva.class, false);
		List<Reserva> reservas = new ArrayList<Reserva>();

		for (Reserva p : extent) {
			reservas.add(p);
		}
		extent.closeAll();
		return reservas;
	}

	@Override
	public void cerrarConexion() {
		// TODO Auto-generated method stub

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
