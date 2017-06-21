package database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Speed {
	
	public static double getSpeed(){
		long start,fin;
		double result=0;
		long length=0;
		int counter=0;
		try {
			//URL url = new URL("http://blnarroganz.bplaced.de/test.txt");
			URL url = new URL("https://download.microsoft.com/download/7/0/3/703455ee-a747-4cc8-bd3e-98a615c3aedb/dotNetFx35setup.exe");
			
			//URL url = new URL("http://blnarroganz.bplaced.de/octave-4.0.0_0-installer.exe");
			
			InfoThread r = new InfoThread(1000);
			Thread t = new Thread(r);
			t.start();
			
			InputStream in = url.openConnection().getInputStream();
			//File file = new File("C:/Users/Justin/Documents/Mobile Anwendungen/newfile.jpg");
			//OutputStream out = new FileOutputStream(file);
			
			byte[] buffer = new byte[1024];
			//for (int n;(n = in.read(buffer)) != -1;out.write(buffer, 0, n));
			start = System.currentTimeMillis();
			for (int n;(n = in.read(buffer)) != -1;){length = length + n; r.setFilesize(length);}
			fin = System.currentTimeMillis();
			r.stop();
			result = fin - start;
			System.out.println("Dateigröße : " + length + " in Byte");
			System.out.println("benötigte Zeit : " + result + " in Ms");
			System.out.println(length/result + " Byte pro Millisekunde");
			
			//in.close();
			//out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}
		
		
		//Path saveFile = Paths.get("C:\\Dinesh", fileName);
		//Files.copy(uc.getInputStream(), saveFile);
		return ((length/1024)/(result/1000));
	}
	
}
