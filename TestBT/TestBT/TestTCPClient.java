package TestBT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;



public class TestTCPClient {
    public static void main(String[] args) {
        try {
        
            Socket s=new Socket("127.0.0.1",6789);
            System.out.println("Client da duoc tao");


            BufferedReader reader= new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream());

            Scanner sc=new Scanner(System.in);
            System.out.println("Client : ");
            String line=sc.nextLine();

            // System.out.println("Sent: "+line);
       
            out.println(line);
            out.flush();

            String st=reader.readLine();
            System.out.print("Server: "+st);

            reader.close();
            out.close();
            s.close();
            sc.close();
        

        } catch (Exception e) {
            //TODO: handle exception
             e.printStackTrace();
        } 
    }

}
