package Tuan4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServerFile {
    public static void main(String[] args) {
        try {
            // ServerSocket ss= new ServerSocket(9876);
            // System.out.println("Server da duoc tao!");

            // Socket s=ss.accept();
            System.out.println("Da ket noi toi client!");
            FileInputStream file= new FileInputStream("D:/TestPT/int1.txt");
            BufferedReader doc= new BufferedReader(new InputStreamReader(file));
            Scanner in = new Scanner(file);
            int i=0;
                while(in.hasNextLine()){
                    in.nextLine();
                     i++;
                }
                System.out.println("i="+i);
            // while (true) {
            //     BufferedReader doc= new BufferedReader(new InputStreamReader(file));
                
            //     String line = doc.readLine();
            //     int i=0;
                
            //     while (line != null) {
            //          System.out.println("\n"+line);
            //         //  sum += Integer.parseInt(line);
            //         //  System.out.println(sum);
                     

            //          line= doc.readLine();

            //     }
                              
            // }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
