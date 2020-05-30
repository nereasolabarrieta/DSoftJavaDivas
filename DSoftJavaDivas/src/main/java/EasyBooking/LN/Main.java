package EasyBooking.LN;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.BasicConfigurator;

import EasyBooking.LD.Aeropuerto;
import EasyBooking.LD.Reserva;
import EasyBooking.LD.Usuario;
import EasyBooking.LD.Viajero;
import EasyBooking.LD.Vuelo;
import EasyBooking.LD.metodoPago;
import EasyBooking.LP.Servidor;
import Fachada.ServidorPrincipal;



public class Main {

	private static PersistenceManager persistentManager;
	private static Transaction transaction;
	private static 	PersistenceManagerFactory persistentManagerFactory;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//SelectNombreViajeros();
		try {
			ServidorPrincipal s = ServidorPrincipal.getInstance();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void AnyadirInfo ()
	{
		 	Aeropuerto Madrid = new Aeropuerto ("MDR","MADRID");
		    Aeropuerto Mallorca = new Aeropuerto ("PLM","PALMA DE MALLORCA");
		    persistentManager.makePersistent(Madrid);
		    persistentManager.makePersistent(Mallorca);
		    
//		    Aerolinea Iberia = new Aerolinea("IBE", "IBERIA");
//		    Aerolinea Ryanair = new Aerolinea("RYA", "RYANAIR");
//		    Aerolinea Vueling = new Aerolinea("VLN", "VUELING");
//		    persistentManager.makePersistent(Iberia);
//		    persistentManager.makePersistent(Ryanair);
//		    persistentManager.makePersistent(Vueling);
	
//		    Usuario usu1 = new Usuario("14231223Y", "Mikel", metodoPago.Paypal, Madrid);
//		    Usuario usu2 = new Usuario("24231223Y", "Maria", metodoPago.Visa, Mallorca);
//		    Usuario usu3 = new Usuario("34231223Y", "Jon", metodoPago.Visa, Mallorca);
//		    Usuario usu4 = new Usuario("44231223Y", "Leire", metodoPago.Paypal, Madrid);
//		    persistentManager.makePersistent(usu1);
//		    persistentManager.makePersistent(usu2);
//		    persistentManager.makePersistent(usu3);
//		    persistentManager.makePersistent(usu4);

		    
		    Viajero viaj1 = new Viajero("12341234R", "Enara");
		    Viajero viaj2 = new Viajero("22341234R", "Elena");
		    Viajero viaj3 = new Viajero("32341234R", "Erlaitz");
		    Viajero viaj4 = new Viajero("42341234R", "Aiora");
		    Viajero viaj5 = new Viajero("52341234R", "Julen");
		    Viajero viaj6 = new Viajero("62341234R", "Eneko");
		    persistentManager.makePersistent(viaj1);
		    persistentManager.makePersistent(viaj2);
		    persistentManager.makePersistent(viaj3);
		    persistentManager.makePersistent(viaj4);
		    persistentManager.makePersistent(viaj5);
		    persistentManager.makePersistent(viaj6);

//		    Set<Viajero>Lista_viajero=new HashSet<Viajero>();
//		    Lista_viajero.add(viaj1);
//		    Reserva reser1 =new Reserva("1", usu1, Lista_viajero,Iberia);
//		    Lista_viajero.add(viaj3);
//		    Lista_viajero.add(viaj4);
//		    Reserva reser2 =new Reserva("2", usu2, Lista_viajero,Ryanair);
//		    Lista_viajero.add(viaj5);
//		    Lista_viajero.add(viaj6);
//		    Reserva reser3 =new Reserva("3", usu3, Lista_viajero,Vueling);
//		    persistentManager.makePersistent(reser1);
//		    persistentManager.makePersistent(reser2);
//		    persistentManager.makePersistent(reser3);
//		   
//		    Set<Asiento>Lista_asiento=new HashSet<Asiento>();
//		    Asiento asiento1 = new Asiento("1A", true);
//		    Asiento asiento2 = new Asiento("1B", true);
//		    Asiento asiento3 = new Asiento("1C", true);
//		    Asiento asiento4 = new Asiento("1D", true);
//		    Asiento asiento5 = new Asiento("1E", true);
//		    Asiento asiento6 = new Asiento("1F", true);
//		    Asiento asiento7 = new Asiento("2A", true);
//		    Asiento asiento8 = new Asiento("2B", true);
//		    Asiento asiento9 = new Asiento("2C", true);
//		    Asiento asiento10= new Asiento("2D", true);
//		    Asiento asiento11 = new Asiento("2E", true);
//		    Asiento asiento12 = new Asiento("2F", true);
//		    persistentManager.makePersistent(asiento1);
//		    persistentManager.makePersistent(asiento2);
//		    persistentManager.makePersistent(asiento3);
//		    persistentManager.makePersistent(asiento4);
//		    persistentManager.makePersistent(asiento5);
//		    persistentManager.makePersistent(asiento6);
//		    persistentManager.makePersistent(asiento7);
//		    persistentManager.makePersistent(asiento8);
//		    persistentManager.makePersistent(asiento9);
//		    persistentManager.makePersistent(asiento10);
//		    persistentManager.makePersistent(asiento11);
//		    persistentManager.makePersistent(asiento12);
//		    
//		    Lista_asiento.add(asiento1);
//		    Lista_asiento.add(asiento2);
//		    Lista_asiento.add(asiento3);
//		    Lista_asiento.add(asiento4);
//		    Lista_asiento.add(asiento5);
//		    Lista_asiento.add(asiento6);
//		    Lista_asiento.add(asiento7);
//		    Lista_asiento.add(asiento8);
//		    Lista_asiento.add(asiento9);
//		    Lista_asiento.add(asiento10);
//		    Lista_asiento.add(asiento11);
//		    Lista_asiento.add(asiento12);
//		    
//		    Avion avion1 = new Avion("02X45672J",Lista_asiento);
//		    persistentManager.makePersistent(avion1);
		    
		    //No consigo escribir DATE
		   // Vuelo vueloMadridMallorca = new Vuelo("1",Madrid,Mallorca,Iberia,avion1,"20/04/2020","20/04/2020",40);
	}
	

	public static void AnyadirAeropuerto_1 (String cod, String nom)
	{
		List<Aeropuerto> aeropuertos = VisualizarAeropuertos();
		String codAnyadir=cod;	
		try
        {
			Aeropuerto nuevo = new Aeropuerto(cod, nom);
			persistentManager.makePersistent(nuevo);

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
		    
		    //persistentManager.close();
		}
		
	}
	public static void EliminarAeropuerto (String cod)
	{
		List<Aeropuerto> aeropuertos = VisualizarAeropuertos();
		String codEliminar=cod;
		
		try
        {
			
			for (Aeropuerto p: aeropuertos)
			{
				String codNuevo=p.getCodAeropuerto();
					if(codNuevo.equals(codEliminar))
					{
						Aeropuerto eliminar = persistentManager.getObjectById(Aeropuerto.class, cod);
						persistentManager.deletePersistent(eliminar);
					}
					else
					{
						System.out.println("No coincide");
					}
			}
        }
		catch(Exception ex)
		{
			System.err.println("* Exception deleting data from db: " + ex.getMessage());
		}
		
		finally
		{		    
			if (transaction.isActive()) 
			{
		        transaction.rollback();
		    }
		    
		    //persistentManager.close();
		}
		
	}
	
	public static List<Aeropuerto> VisualizarAeropuertos()
	{
	
		Extent<Aeropuerto> extent = persistentManager.getExtent(Aeropuerto.class, false);
		List<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();
		
		for (Aeropuerto p : extent) 
		{
		  aeropuertos.add(p);
		}
		extent.closeAll();
		return aeropuertos;
	}
	
	public static void ModificarAeropuerto (String cod, String nom)
	{
		List<Aeropuerto> aeropuertos = VisualizarAeropuertos();
		String codModificar=cod;

		try
        {
			
			for (Aeropuerto p: aeropuertos)
			{
				String codNuevo=p.getCodAeropuerto();
					if(codNuevo.equals(codModificar))
					{
						Aeropuerto a = persistentManager.getObjectById(Aeropuerto.class, cod);
						a.setNomAeropuerto(nom);
					}
					else
					{
						System.out.println("No coincide");
					}
			}
        }
		catch(Exception ex)
		{
			System.err.println("* Exception modifying data from db: " + ex.getMessage());
		}
		
		finally
		{		    
			if (transaction.isActive()) 
			{
		        transaction.rollback();
		    }
		    
		    //persistentManager.close();
		}
	}
	
	public static void SelectNombreViajeros()
	{
		try
        {
		    transaction.begin();
		  
		    @SuppressWarnings("rawtypes")
			Query q = persistentManager.newQuery("select nomViajero from " + Viajero.class.getName());
		    @SuppressWarnings("unchecked")
			List<String> nombres = (List<String>) q.execute();
		    
			for (String a: nombres)
			{
				System.out.println("El nombre del viajero es " + a);
			}
		 
		    transaction.commit();	
		}

        catch(Exception ex)
		{
			System.err.println("* Exception reading data from db: " + ex.getMessage());
		}
		
		finally
		{		    
			if (transaction.isActive()) 
			{
		        transaction.rollback();
		    }
		    
		}
	}


}