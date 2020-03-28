package EasyBooking.LN;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import EasyBooking.LD.Aerolinea;
import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Asiento;
import EasyBooking.LD.Reserva;
import EasyBooking.LD.Usuario;
import EasyBooking.LD.Viajero;
import EasyBooking.LD.metodoPago;



public class Main {

	private static PersistenceManager persistentManager;
	private static Transaction transaction;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
        {
			PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			
			//Insert data in the DB
			persistentManager = persistentManagerFactory.getPersistenceManager();				
			transaction = persistentManager.currentTransaction();				
			
			try
            {
			    transaction.begin();
			    Aeropuerto Madrid = new Aeropuerto ("MDR","MADRID");
			    Aeropuerto Mallorca = new Aeropuerto ("PLM","PALMA DE MALLORCA");
			    AnyadirAeropuerto(Madrid);
			    AnyadirAeropuerto(Mallorca);
			    
			    Aerolinea Iberia = new Aerolinea("IBE", "IBERIA");
			    Aerolinea Ryanair = new Aerolinea("RYA", "RYANAIR");
			    Aerolinea Vueling = new Aerolinea("VLN", "VUELING");
			    AnyadirAerolinea(Iberia);
			    AnyadirAerolinea(Ryanair);
			    AnyadirAerolinea(Vueling);
			    
			    Usuario usu1 = new Usuario("14231223Y", "Mikel", metodoPago.Paypal, Madrid);
			    Usuario usu2 = new Usuario("24231223Y", "Maria", metodoPago.Visa, Mallorca);
			    Usuario usu3 = new Usuario("34231223Y", "Jon", metodoPago.Visa, Mallorca);
			    Usuario usu4 = new Usuario("44231223Y", "Leire", metodoPago.Paypal, Madrid);
			    AnyadirUsuario(usu1);
			    AnyadirUsuario(usu2);
			    AnyadirUsuario(usu3);
			    AnyadirUsuario(usu4);
			    
			    Viajero viaj1 = new Viajero("12341234R", "Enara");
			    Viajero viaj2 = new Viajero("22341234R", "Elena");
			    Viajero viaj3 = new Viajero("32341234R", "Erlaitz");
			    Viajero viaj4 = new Viajero("42341234R", "Aiora");
			    Viajero viaj5 = new Viajero("52341234R", "Julen");
			    Viajero viaj6 = new Viajero("62341234R", "Eneko");
			    
			    AnyadirViajero(viaj1);
			    AnyadirViajero(viaj2);
			    AnyadirViajero(viaj3);
			    AnyadirViajero(viaj4);
			    AnyadirViajero(viaj5);
			    AnyadirViajero(viaj6);
			    
			    Set<Viajero>Lista_viajero=new HashSet<Viajero>();
			    Lista_viajero.add(viaj1);
			    Reserva reser1 =new Reserva("1", usu1, Lista_viajero,Iberia);
			    Lista_viajero.add(viaj3);
			    Lista_viajero.add(viaj4);
			    Reserva reser2 =new Reserva("2", usu2, Lista_viajero,Ryanair);
			    Lista_viajero.add(viaj5);
			    Lista_viajero.add(viaj6);
			    Reserva reser3 =new Reserva("3", usu3, Lista_viajero,Vueling);
			    AnyadirReserva(reser1);
			    AnyadirReserva(reser2);
			    AnyadirReserva(reser3);
			    
			    
			    
			    //Escribir codigo BD
			    //escribir
//			    Aeropuerto nuevo= new Aeropuerto("B", "Loiu");
//			    persistentManager.makePersistent(nuevo);
			    //borrar
			    //Aeropuerto a = persistentManager.getObjectById(Aeropuerto.class, "BIL");
			   // persistentManager.deletePersistent(a);
			    //Editar
			  //Aeropuerto a = persistentManager.getObjectById(Aeropuerto.class, "BIL");
			    //a.setNomAeropuerto("Biarritz");
			    
			    transaction.commit();
			    
			}

            catch(Exception ex)
			{
				System.err.println("* Exception inserting data into db: " + ex.getMessage());
			}
			
			finally
			{		    
				if (transaction.isActive()) 
				{
			        transaction.rollback();
			    }
			    
			    persistentManager.close();
			}
			
			
			//Select data using a Query
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
				
			try
            {
			    transaction.begin();
	
			    //Escribir codigo BD
	
			    transaction.commit();
			}

			catch(Exception ex)
			{
				System.err.println("* Exception executing a query: " + ex.getMessage());
			}

			finally 
			{
				if (transaction.isActive())
				{
			        transaction.rollback();
			    }
	
			    persistentManager.close();
			}
		}

		catch (Exception ex)
        {
			System.err.println("* Exception: " + ex.getMessage());
		}
	}
	
	public static void AnyadirAeropuerto (Aeropuerto nuevo)
	{
		  persistentManager.makePersistent(nuevo);
	}
	
	public static void AnyadirAerolinea (Aerolinea nuevo)
	{
		 persistentManager.makePersistent(nuevo);
	}
	public static void AnyadirUsuario (Usuario nuevo)
	{
		 persistentManager.makePersistent(nuevo);
	}
	public static void AnyadirViajero(Viajero nuevo)
	{
		 persistentManager.makePersistent(nuevo);
	}
	public static void AnyadirReserva(Reserva nuevo)
	{
		 persistentManager.makePersistent(nuevo);
	}
	public static void AnyadirAeropuerto_1 (String cod, String nom)
	{
		Aeropuerto nuevo = new Aeropuerto(cod, nom);
	}


}
