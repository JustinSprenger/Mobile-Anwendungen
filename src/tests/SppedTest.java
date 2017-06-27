package tests;

import InOut.Read;
import database.Database;
import database.Dateandtime;
import database.Network;
import database.Speed;

public class SppedTest {

	public static void main(String[] args) {
		char wieder = 'j';
		int auswahl = 0;
		String[] arg = new String[5];
		Read sc = new Read();
		Database db = new Database("angewandteinfo.spdns.org",3306,"Mobile-Anwendungen","Justin","Tresor132");
		
		System.out.println("   _____                     _   _______        _ ");
		System.out.println("  / ____|                   | | |__   __|      | |  ");
		System.out.println(" | (___  _ __   ___  ___  __| |    | | ___  ___| |_ ");
		System.out.println("  \\___ \\| '_ \\ / _ \\/ _ \\/ _` |    | |/ _ \\/ __| __|");
		System.out.println("  ____) | |_) |  __/  __/ (_| |    | |  __/\\__ \\ |_ ");
		System.out.println(" |_____/| .__/ \\___|\\___|\\__,_|    |_|\\___||___/\\__|");
		System.out.println("        | |                                         ");
		System.out.println("        |_|                                         ");
		System.out.println();
		System.out.println();
		
		do{
			
			System.out.println("1. Ausgabe der Accespoint IP");
			System.out.println("2. Ausgabe der Router IP");
			System.out.println("3. um speedtest durchzuführen");
			System.out.println("4. Datensätze ausgeben");
			System.out.println("0. um Abzubrechen");
			
			auswahl = sc.readInt();
			
			switch (auswahl) {
			case 1:
				System.out.println(Network.getAccessPoint());
				break;
			case 2:
				System.out.println(Network.getRouterIP());
				break;
			case 3:
				double speed;
				
				try {
					speed = Speed.getSpeed();
					arg[0] = Network.getAccessPoint();
					arg[1] = Network.getRouterIP();
					arg[2] = speed+"";
					arg[3] = Dateandtime.getTime();
					arg[4] = Dateandtime.getDate();
					
					db.insertDatabase("t_Messungen", arg);
					
				} catch (Exception e) {
					e.getStackTrace();
				}
				
				
				break;
			case 4:
				db.getDatabase();
				break;
			case 0:
				
				break;
			default:
				break;
			}
			
			System.out.println("");
			System.out.println("Möchten Sie wiederhohlen ?(j/n):");
			System.out.println("");
			
			wieder = sc.readChar();
			
			System.out.println("");
			
		}while(wieder == 'j');

	}

}
