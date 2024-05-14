import java.io.*;
import java.net.*;
public class client {
	public static void main(String[] args) {
		try {
			DatagramSocket clientSocket = new DatagramSocket();
			byte[] sendData;
			byte[] receiveData = new byte[1024];
			InetAddress serverAddress = InetAddress.getByName("localhost");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.print("Client: ");
				String clientMessage = reader.readLine();
				sendData = clientMessage.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
				clientSocket.send(sendPacket);
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				clientSocket.receive(receivePacket);
				String serverMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
				System.out.println("Server: " + serverMessage);
				if (serverMessage.equalsIgnoreCase("bye")) {
					System.out.println("Client stopped.");
					break;
				}
			}
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
