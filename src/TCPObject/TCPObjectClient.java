/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCPObject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Red King
 */
public class TCPObjectClient {
    public TCPObjectClient(){
        try{
            Socket socket = new Socket("localhost", 8000);
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            TCPObjectC objC = new TCPObjectC(10, 10);
            os.writeObject(objC);
            os.flush();
            objC = (TCPObjectC)is.readObject();
            System.out.println("number: " + objC.getNumber1() + " " + objC.getNumber2());
        }catch(Exception e){
            System.out.print(e);
        }
    }
    public static void main(String [] args){
        new TCPObjectClient();
    }
}
