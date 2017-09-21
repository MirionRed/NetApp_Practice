/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Red King
 */
public class TCPClient {

    private int port = 8000;
    private String host = "localhost";
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new TCPClient();
    }

    public TCPClient() {
        try {
            socket = new Socket(host, port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            System.out.print("Enter numer : ");
            double number = scanner.nextDouble();
            out.writeDouble(number);
            System.out.println(in.readDouble());
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
