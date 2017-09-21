/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author Red King
 */
public class UDPClient {
    private DatagramSocket socket;
    private DatagramPacket sendPacket;
    private DatagramPacket receivePacket;
    private InetAddress serverAddress;
    private Scanner scanner;
    public static void main(String[] args) {
        new UDPClient();
    }

    public UDPClient() {
        try {
            socket = new DatagramSocket();
            serverAddress = InetAddress.getByName("localhost");
            byte[] buf = new byte[256];
            sendPacket = new DatagramPacket(buf, buf.length, serverAddress, 8000);
            receivePacket= new DatagramPacket(buf, buf.length);
            scanner = new Scanner(System.in);
            double number;
            System.out.print("Enter number : ");
            number = scanner.nextDouble();
            sendPacket.setData(Double.toString(number).getBytes());
            socket.send(sendPacket);
            
            socket.receive(receivePacket);
            String quote = new String(buf).trim();
            double result = Double.parseDouble(quote);
            System.out.println(result);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
}
