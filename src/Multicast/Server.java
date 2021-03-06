/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multicast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Red King
 */
public class Server {

    final static String INET_ADDR = "224.0.0.3";
    final static int PORT = 8888;

    public Server() {
        try {
            DatagramSocket serverSocket = new DatagramSocket();
            InetAddress addr = InetAddress.getByName(INET_ADDR);
            
            for(int i = 1; true; i++){
                String msg = "Sent message no " + i;
                DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, PORT);
                serverSocket.send(msgPacket);
                
                System.out.println("Server sent packet with msg: " + msg);
                Thread.sleep(1000);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public static void main(String[]args){
        new Server();
    }
}
