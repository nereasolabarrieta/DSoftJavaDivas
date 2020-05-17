package Remote;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Fachada.itfFachada;

public class ServiceLocator {
	private itfFachada fachada;
	 public void setService() 
	    {  
	    	String ip = "127.0.0.1";
			String port = "5000";
			String serviceName = "EasyBooking";
	    		
			
			if (System.getSecurityManager() == null) 
			{
				System.setSecurityManager(new SecurityManager());
			}
	    	
	    	try 
			{
				Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(port))));
				String name = "//" + ip + ":" + port + "/" + serviceName;			
				this.fachada = (itfFachada) registry.lookup(name);		
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
