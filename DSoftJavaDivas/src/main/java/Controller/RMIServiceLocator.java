package Controller;

public class RMIServiceLocator {
	private BDController service = null;

    public RMIServiceLocator() { }

    public void setService(String ip, String port, String serviceName) 
    {    
 
    }
    
    public BDController getService() 
    {
		return service;    	
    }
}
