package SSLSOCKETCERT;

import javax.net.ssl.SSLSocketFactory;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("javax.net.ssl.trustStore", "za.store");
		Socket socket = ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket("localhost",8080);
		BufferedReader socketBuffRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader commPromtBuffRead = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter a username: ");
		System.out.println(commPromtBuffRead.readLine());
		String msg = null;
		while(true) {
			System.out.println("please enter a server message");
			msg = commPromtBuffRead.readLine();
			if(msg.equals("quit")) {
				printWriter.println(msg);
				socket.close();
				break;
			}
			printWriter.println(msg);
			System.out.println("reply from server");
			System.out.print(socketBuffRead.readLine());
		}
	}

}
