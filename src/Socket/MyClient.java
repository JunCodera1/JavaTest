package Socket;

import java.io.DataOutputStream;
import java.net.Socket;

public class MyClient {  
	public static void main(String[] args) {
		try {
			 System.out.println("Client started");
			 Socket soc = new Socket("localhost", 9999);
			 DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			 dos.writeUTF("Hello Server");
			 dos.flush();
			 dos.close();
			 soc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}  
}  