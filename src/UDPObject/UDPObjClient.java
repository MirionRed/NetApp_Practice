/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDPObject;

import LecturerExampleUDPObject.Points;
import static LecturerExampleUDPObject.UDPGeometryClient.BUFFER_SIZE;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import javax.swing.JFrame;

/**
 *
 * @author Red King
 */
public class UDPObjClient {

    public UDPObjClient() {
        int BUFFER_SIZE = 512;
        byte[] buf = new byte[BUFFER_SIZE];
        int serverPort = 8000;
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            DatagramPacket requestPacket = new DatagramPacket(buf, buf.length);
            DatagramPacket responsePacket = new DatagramPacket(buf, buf.length, serverAddress, serverPort);
            
            //SEND
            UDPObjectC objC = new UDPObjectC(30, 30);

            ByteArrayOutputStream outputByteStream = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(outputByteStream);
            os.flush();
            os.writeObject(objC);
            os.flush();
            os.close();

            responsePacket.setData(outputByteStream.toByteArray());
            socket.send(responsePacket);

            //RECEIVE
            socket.receive(requestPacket);
            ByteArrayInputStream inputByteStream = new ByteArrayInputStream(buf);
            ObjectInputStream is = new ObjectInputStream(inputByteStream);

            UDPObjectC quote = (UDPObjectC) is.readObject();
            System.out.println("numbers: " + quote.getNumber1() + " " + quote.getNumber2());

            is.close();
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        new UDPObjClient();
    }

}
