package Tuan4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class ChatTCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(6789);
            System.out.println("Server da duoc tao!");
            while(true){
                Socket s=ss.accept();

                BufferedReader reader= new BufferedReader(new InputStreamReader(s.getInputStream()));//lấy thông tin từ client
                PrintWriter out = new PrintWriter(s.getOutputStream());
       
                String msg_in = "", msg_out = "";
                while (!msg_in.equalsIgnoreCase("bye") && !msg_out.equalsIgnoreCase("bye")) {
                    msg_in = reader.readLine();
                    System.out.println("client: " + msg_in);
    
                   
                    System.out.println("server: ");
                    Scanner scan = new Scanner(System.in);
                    msg_out = scan.nextLine();
                    out.println(msg_out);
                    out.flush();
                }
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
