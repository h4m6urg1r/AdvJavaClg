import java.io.*;
import java.net.*;


public class server {
	public static void main(String[] args) {
		try {
			// Create DatagramSocket
			DatagramSocket serverSocket = new DatagramSocket(9876);


			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];


			System.out.println("Server is running...");


			while (true) {
				// Receive client's message
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
				String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
				System.out.println("Client: " + clientMessage);


				// Get client's IP address and port number
				InetAddress clientAddress = receivePacket.getAddress();
				int clientPort = receivePacket.getPort();


				// Read message from console
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Server: ");
				String serverMessage = reader.readLine();


				// Send response to client
				sendData = serverMessage.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
				serverSocket.send(sendPacket);


				if (serverMessage.equalsIgnoreCase("bye")) {
					System.out.println("Server stopped.");
					break;
				}
			}


			// Close socket
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}