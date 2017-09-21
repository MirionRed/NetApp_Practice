/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDPObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
public class UDPObjServer {

    public UDPObjServer() {
        int BUFFER_SIZE = 512;
        byte[] buf = new byte[BUFFER_SIZE];
        try {
            DatagramSocket socket = new DatagramSocket(8000);
            while (true) {
                DatagramPacket input = new DatagramPacket(buf, buf.length);
                DatagramPacket output = new DatagramPacket(buf, buf.length);

                //RECEIVE
                socket.receive(input);
                //buf = input.getData();
                ByteArrayInputStream inputStream = new ByteArrayInputStream(buf);
                ObjectInputStream is = new ObjectInputStream(inputStream);
                UDPObjectC objC = (UDPObjectC) is.readObject();
                InetAddress addr = input.getAddress();
                int port = input.getPort();

                UDPObjectS objS = new UDPObjectS(objC.number1, objC.number2);
                UDPObjectC send = new UDPObjectC(objS.getNumber(), objS.getNumber());
                
                //SEND
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(outputStream);
                os.writeObject(send);
                //buf = outputStream.toByteArray();
                System.out.println(send.number1 + " " + send.number2);

                output.setAddress(addr);
                output.setPort(port);
                output.setData(outputStream.toByteArray());
                socket.send(output);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new UDPObjServer();
    }
}
