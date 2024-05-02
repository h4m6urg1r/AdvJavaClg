/*
 * Adarsh waale se completely different code hai. wo waala work hi nhi kr rha tha.
 */
import java.net.*;
import java.io.*;

public class E5 {
	public static void main(String[] args) throws Exception {

		URL aURL = new URL("http://example.com/docs/books/tutorial/index.html?name=networking#DOWNLOADING");

		System.out.println("protocol = " + aURL.getProtocol());
		System.out.println("authority = " + aURL.getAuthority());
		System.out.println("host = " + aURL.getHost());
		System.out.println("port = " + aURL.getPort());
		System.out.println("path = " + aURL.getPath());
		System.out.println("query = " + aURL.getQuery());
		System.out.println("filename = " + aURL.getFile());
		System.out.println("ref = " + aURL.getRef());
	}
}