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
	    	String ip = "127.0.0.1";
			String port = "1099";
			String serviceName = "EasyBooking";
			System.out.println("HOLA 4");

			if (System.getSecurityManager() == null) {
				System.out.println("HOLA 5 entro al if si no hay security manager");
				System.setSecurityManager(new SecurityManager());
			}
	    	
			System.out.println("HOLA 6");
	    	try 
			{
	    		
	    		Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(port))));
	    		System.out.println("HOLA 7");
				String name = "//" + ip + ":" + port + "/" + serviceName;			
				fachada = (itfFachada) registry.lookup(name);
				System.out.println("HOLA 8");

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
