/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Red King
 */
public class TCPServer {
    private int port = 8000;
    private ServerSocket server;
    private Socket socket;

    public static void main(String[] args) {
        new TCPServer();
    }

    public TCPServer() {
        try {
            server = new ServerSocket(port);
            System.out.println("Server Started");
            int clientNo = 0;
            while(true){
                socket = server.accept();
                System.out.println("Connection established " + clientNo++);
                HandleClient hc = new HandleClient(socket);
                hc.start();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

class HandleClient extends Thread {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public HandleClient(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            
            double number = in.readDouble();
            out.writeDouble(number * 2);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
