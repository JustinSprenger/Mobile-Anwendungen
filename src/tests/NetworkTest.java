package tests;

import java.net.SocketException;

import database.Network;

public class NetworkTest {

	public static void main(String[] args) {
		
		try {
			System.out.println(Network.getIP());
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
