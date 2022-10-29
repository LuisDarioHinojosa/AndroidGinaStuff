package Sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocketFactory;

public class SocketServer {
    static final int port = 8000;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.setProperty("javax.net.ssl.keyStore","za.store");
        System.setProperty("javax.net.ssl.keyStorePassword","123456");
        SSLServerSocketFactory sslServerSocketFactory = 
                (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
        
        try {
            ServerSocket sslServerSocket = 
                    sslServerSocketFactory.createServerSocket(port);
            System.out.println("SSL ServerSocket started");
            System.out.println(sslServerSocket.toString());
            
            Socket socket = sslServerSocket.accept();
            System.out.println("ServerSocket accepted");
            
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            try (BufferedReader bufferedReader = 
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()))) {
                String line;
                while((line = bufferedReader.readLine()) != null){
                    System.out.println(line);
                    out.println(line);
                }
            }
            System.out.println("Closed");
            
        } catch (IOException ex) {
        	throw new RuntimeException(ex);
        }
	}

}
