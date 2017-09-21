/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

/**
 *
 * @author Red King
 */
public class UDPServer {

    private DatagramSocket socket;
    private DatagramPacket receivePacket;
    private DatagramPacket sendPacket;

    public static void main(String[] args) {
        new UDPServer();
    }

    public UDPServer() {
        try {
            socket = new DatagramSocket(8000);
            System.out.println("Server started");
            byte[] buf = new byte[256];
            receivePacket = new DatagramPacket(buf, buf.length);
            sendPacket = new DatagramPacket(buf, buf.length);

            while (true) {
                String quote;
                double number;
                Arrays.fill(buf, (byte) 0);
                
                socket.receive(receivePacket);
                quote = new String(buf).trim();
                number = Double.parseDouble(quote);

                sendPacket.setAddress(receivePacket.getAddress());
                sendPacket.setPort(receivePacket.getPort());
                sendPacket.setData(Double.toString(number * 2).getBytes());
                socket.send(sendPacket);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
