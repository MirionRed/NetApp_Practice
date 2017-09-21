package RMI;
import java.rmi.*;
public interface Sample extends Remote{
  public long getClassStuff()throws RemoteException;
}
