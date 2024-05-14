import java.io.*;
import java.net.*;
public class client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 1234);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
			String inputLine, outputLine;
			while (true) {
				System.out.print("Client: ");
				outputLine = consoleReader.readLine();
				out.println(outputLine);
				if (outputLine.equals("bye"))
					break;
				inputLine = in.readLine();
				System.out.println("Server: " + inputLine);
			}
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}