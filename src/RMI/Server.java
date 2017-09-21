package RMI;
import java.io.*;
import java.rmi.*;
import java.rmi.server.*;

public class Server extends UnicastRemoteObject implements Sample{
    public Server() throws RemoteException{
      super();
    }
    public long getClassStuff(){
      return System.currentTimeMillis()/1000;
    }
    public static void main(String[]args){
      try{
        Naming.rebind("Sample", new Server());
      }catch(Exception ex){
        System.out.println(ex);
      }
    }
}
