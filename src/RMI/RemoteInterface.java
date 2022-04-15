package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {
    String sendMessage(String name,int credits) throws RemoteException;
}
