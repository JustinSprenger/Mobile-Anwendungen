package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by justin on 6/23/17.
 */
public class Network {
    static String s;
    static String t;
    static Process p;
    Network(){

    }

    public static String getAccessPoint(){
        try {
            p = Runtime.getRuntime().exec("traceroute www.google.de");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            //while ((s = br.readLine()) != null)
            //    System.out.println("line: " + s);
            s = br.readLine();
            s = br.readLine();
            try {
                p.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println ("exit: " + p.exitValue());
            p.destroy();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String getRouterIP(){
        String erg = "";
        try {
            int i = 0;
            int indexr = 0;
            p = Runtime.getRuntime().exec("route -n");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            while ((t = br.readLine()) != null){
                System.out.println("line: " + t);

                if (t.contains("UG")) {
                    indexr = t.indexOf("UG");
                    //erg = Character.toString(t.charAt(indexr)) + Character.toString(t.charAt(indexr + 1));
                    for(int j = 0;j<16;j++){
                        erg = erg + Character.toString(t.charAt(16+j));
                    }
                }
                i++;
            }
            try {
                p.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println ("exit: " + p.exitValue());
            p.destroy();

        } catch (IOException e) {
            e.printStackTrace();
        }



        return erg;
    }
}
