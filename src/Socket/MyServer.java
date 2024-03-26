package Socket;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	
	public static void main(String[] args) {
		try {
			System.out.println("Waiting for clients...");
			ServerSocket ss = new ServerSocket(9999);
			Socket soc = ss.accept();
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			String str = (String)dis.readUTF();
			System.out.println("message" + str);
			ss.close();
			System.out.println("Connection established");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
