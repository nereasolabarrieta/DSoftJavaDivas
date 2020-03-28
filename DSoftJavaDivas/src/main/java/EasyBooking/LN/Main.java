package EasyBooking.LN;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import EasyBooking.LD.Aeropuerto;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
        {
			PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			
			//Insert data in the DB
			PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();				
			
			try
            {
			    transaction.begin();
			    
			    //Escribir codigo BD
			    //escribir
			    //Aeropuerto nuevo= new Aeropuerto("BIL", "Loiu");
			    //persistentManager.makePersistent(nuevo);
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
	
	public static void AnyadirAeropuerto (String codAeropuerto, String nomAeropuerto)
	{
		
	}


}
