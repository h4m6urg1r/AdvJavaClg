import java.io.*;
import java.net.*;

public class client {
	public static void main(String[] args) {
		try {
			// Create socket to connect to server
			Socket socket = new Socket("localhost", 1234);


			// Setup input and output streams
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);


			// Create BufferedReader to read input from console
			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));


			String inputLine, outputLine;


			// Start chatting
			while (true) {
				System.out.print("Client: ");
				outputLine = consoleReader.readLine();
				out.println(outputLine);
				if (outputLine.equals("bye"))
					break;


				inputLine = in.readLine();
				System.out.println("Server: " + inputLine);
			}


			// Close streams and socket
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}