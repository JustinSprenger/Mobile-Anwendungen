package tests;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetzTest {

	public static void main(String[] args) {
		
		try {
			System.out.println( "Host Name/Adresse: " + InetAddress.getLocalHost() );
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
