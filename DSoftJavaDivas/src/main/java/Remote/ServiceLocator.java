package Remote;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Fachada.ServidorPrincipal;
import Fachada.itfFachada;

public class ServiceLocator {
	private itfFachada fachada;
	 public void setService() throws RemoteException 
	    {  
	    	String ip = "localhost";
			String port = "1099";
			String serviceName = "EasyBooking";


			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
	    	
	    	try 
			{
				Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(port))));
				String name = "//" + ip + ":" + port + "/" + serviceName;	
				System.out.println("* Server '" + name + "' active and waiting...");	
				registry.rebind(name, fachada);
			} 
			catch (Exception e) 
			{
				System.err.println("- Exception running the client: " + e.getMessage());
				e.printStackTrace();
			}
		}
	    
	    public itfFachada getService() 
	    {
			return fachada;    	
	    }
}
