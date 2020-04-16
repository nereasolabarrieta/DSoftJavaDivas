package EasyBooking.LN;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServidorPrincipal extends Remote
{
public void BuscarVuelos()throws RemoteException;
}
