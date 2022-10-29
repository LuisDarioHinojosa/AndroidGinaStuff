package SSLSOCKETCERT;

import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.IOException;


public class ServerThreat extends Thread {
	Socket socket;
	
	ServerThreat(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		try {
			PrintWriter printWritter = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("username logged in : " + bufferedReader.readLine());
			
			while(true) printWritter.println(bufferedReader.readLine() + " echo");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
