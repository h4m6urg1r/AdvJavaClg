import java.io.*;
import java.net.*;

public class server {
	public static void main(String[] args) {
		try {
			// Create server socket
			ServerSocket serverSocket = new ServerSocket(1234);

			// Accept client connection
			System.out.println("Waiting for client to connect...");
			Socket clientSocket = serverSocket.accept();
			System.out.println("Client connected.");

			// Setup input and output streams
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

			// Create BufferedReader to read input from console
			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

			String inputLine, outputLine;

			// Start chatting
			while ((inputLine = in.readLine()) != null) {
				System.out.println("Client: " + inputLine);
				if (inputLine.equals("bye"))
					break;

System.out.print("Server: ");
				outputLine = consoleReader.readLine();
				out.println(outputLine);
			}

			// Close streams and sockets
			out.close();
			in.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}