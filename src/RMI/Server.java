package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements RemoteInterface{
    public Server(){}

    public String sendMessage(String name,int credits){;
        if(credits>=850){
            return name+" you are eligible";
        }
        return name+" you are not eligible";
    }

    public static void main(String[] args) {
        try{
            Server obj = new Server();
            RemoteInterface stub = (RemoteInterface) UnicastRemoteObject.exportObject(obj,0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("RemoteInterface",stub);
            System.out.println("Server Ready");
        }catch (Exception e){
            System.out.println("Server Exception: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
