package SSLSOCKETCERT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocketFactory;

public class Server {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("javax.net.ssl.keyStore", "za.store");
		System.setProperty("javax.net.ssl.keyStorePassword", "123456");
		ServerSocket serverSocket = ((SSLServerSocketFactory)SSLServerSocketFactory.getDefault()).createServerSocket(8080);
		System.out.println("Server Ready");
		while(true) {
			new ServerThreat(serverSocket.accept()).start();
		}
		
	}
}
