/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCPObject;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Red King
 */
public class TCPObjectServer {
    public TCPObjectServer(){
        try{
            ServerSocket serverSocket = new ServerSocket(8000);
            while(true){
                Socket socket = serverSocket.accept();
                HandleClient clientThread = new HandleClient(socket);
                clientThread.start();
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }
    public class HandleClient extends Thread{
        private Socket socket;
        public HandleClient(Socket socket){
            this.socket = socket;
        }
        public void run(){
            try{
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                
                TCPObjectC objC = (TCPObjectC)input.readObject();
                TCPObjectS objS = new TCPObjectS(objC.number1, objC.number2);
                TCPObjectC returnC = new TCPObjectC(objS.getNumber(), objS.getNumber());
                
                output.writeObject(returnC);
                output.flush();
                
            }catch(Exception e){
                
            }
        }
    }
    public static void main(String[] args){
        new TCPObjectServer();
    }
}
