package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private Client(){}

    public static void main(String[] args) {
        String host = (args.length<1)?null:args[0];
        Scanner scanner = new Scanner(System.in);
        try{
            Registry registry = LocateRegistry.getRegistry(host);
            RemoteInterface stub = (RemoteInterface) registry.lookup("RemoteInterface") ;
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Enter your credits ");
            int credits = scanner.nextInt();
            String responseMessage = stub.sendMessage(name,credits);
            System.out.println("Message from remote object is: "+responseMessage);
        }catch (Exception e){
            System.out.println("Client Exception: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
