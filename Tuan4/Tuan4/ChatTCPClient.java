package Tuan4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatTCPClient {
    public static void main(String[] args) {
        try {
        
            Socket s=new Socket("127.0.0.1",6789);
            System.out.println("Client da duoc tao");

            BufferedReader reader= new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream());//đảy thong tin đi

            String msg_out = "", msg_in = "";
			while (!msg_out.equals("bye") && !msg_in.equals("bye")) {
				System.out.println("Client: ");
                    Scanner scan = new Scanner(System.in);
                    msg_out = scan.nextLine();
                    out.println(msg_out);
                    out.flush();

                    msg_in = reader.readLine();
                    System.out.println("Server: " + msg_in);
			}

            reader.close();
            out.close();
            s.close();

    } catch (Exception e) {
        //TODO: handle exception
        e.printStackTrace();
    } 
    }

}
