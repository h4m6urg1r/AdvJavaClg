import java.io.*;
import java.net.*;
public class server {
	public static void main(String[] args) {
		try {
			DatagramSocket serverSocket = new DatagramSocket(9876);
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];
			System.out.println("Server is running...");
			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
				String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
				System.out.println("Client: " + clientMessage);
				InetAddress clientAddress = receivePacket.getAddress();
				int clientPort = receivePacket.getPort();
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Server: ");
				String serverMessage = reader.readLine();
				sendData = serverMessage.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
				serverSocket.send(sendPacket);
				if (serverMessage.equalsIgnoreCase("bye")) {
					System.out.println("Server stopped.");
					break;
				}
			}
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
