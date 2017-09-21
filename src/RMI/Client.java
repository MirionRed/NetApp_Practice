package RMI;
import java.rmi.*;
import javax.swing.*;

public class Client{
  private static Sample sample;
  public Client(){
    displayFrame();
  }
  private void displayFrame(){
    try{
      long result = sample.getClassStuff();
      System.out.println(result);
    }catch(Exception ex){
      System.out.println(ex);
    }
  }
  public static void main(String[]args){
    if(args.length == 1){
      try{
        System.setSecurityManager(new RMISecurityManager());
        sample = (Sample)Naming.lookup("//" + args[0] + "/Sample");
        new Client();
      }catch(Exception ex){
        System.out.println(ex);
      }
    }else{
      System.out.println("Invalid number of arguments");
    }
  }
}
