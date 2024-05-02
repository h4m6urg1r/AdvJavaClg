import java.io.*;
import java.net.*;


public class client {
	public static void main(String[] args) {
		try {
			// Create DatagramSocket
			DatagramSocket clientSocket = new DatagramSocket();


			byte[] sendData;
			byte[] receiveData = new byte[1024];


			InetAddress serverAddress = InetAddress.getByName("localhost");


			// Read message from console
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


			while (true) {
				System.out.print("Client: ");
				String clientMessage = reader.readLine();
				sendData = clientMessage.getBytes();


				// Send message to server
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
				clientSocket.send(sendPacket);


				// Receive response from server
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				clientSocket.receive(receivePacket);
				String serverMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
				System.out.println("Server: " + serverMessage);


				if (serverMessage.equalsIgnoreCase("bye")) {
					System.out.println("Client stopped.");
					break;
				}
			}


			// Close socket
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}