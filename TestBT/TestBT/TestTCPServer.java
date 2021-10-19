package TestBT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TestTCPServer {

   

    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(6789);
            System.out.println("Server da duoc tao!");
            while(true){
                Socket s=ss.accept();

                BufferedReader reader= new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter out = new PrintWriter(s.getOutputStream());

                String line = reader.readLine();
                System.out.println("Client: "+line);
                
                out.println(line.toUpperCase());              
                out.flush();

                reader.close();
                out.close();
                s.close();
            }

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        } 
    }



}
