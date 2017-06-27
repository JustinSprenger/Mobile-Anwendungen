package InOut;

import java.util.Scanner;

public class Read {
	Scanner sc = new Scanner(System.in);
	
	public Read(){
		
	}
	
	/**
	 * 
	 * @return Integer
	 */
	public int readInt(){
		String s="";
		int zahl=0;
		boolean wieder=true;
		do{
			s = sc.next();
			try {
				zahl = Integer.parseInt(s);
				wieder = true;
			} catch (Exception e) {
				System.out.println("Bitte geben Sie eine ganze Zahl ein!!!");
				wieder = false;
			}
		}while(wieder==false);
		return zahl;
	}
	
	/**
	 * 
	 * @return Double
	 */
	public double readDouble(){
		String s="";
		double zahl=0;
		boolean wieder=true;
		do{
			s = sc.next();
			try {
				zahl = Double.parseDouble(s);
				wieder = true;
			} catch (Exception e) {
				System.out.println("Bitte geben Sie eine Zahl ein!!!");
				wieder = false;
			}
		}while(wieder==false);
		return zahl;
	}
	
	/**
	 * 
	 * @return Char
	 */
	public char readChar(){
		String s="";
		char c=' ';
		boolean wieder=true;
		do{
			s = sc.next();
			try {
				c = s.charAt(0);
				wieder = true;
			} catch (Exception e) {
				System.out.println("Bitte geben Sie einen Buchstaben ein!!!");
				wieder = false;
			}
		}while(wieder==false);
		return c;
	}
	
	/**
	 * 
	 * @return String
	 */
	public String readString(){
		String s="";
		s = sc.next();
		return s;
	}
}
