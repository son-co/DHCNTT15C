package Tuan4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPDateTimeClient {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       try {
            Socket s =new Socket("127.0.0.1",9999);
            System.out.println("Client da khoi tao");

            BufferedReader reader= new BufferedReader(new InputStreamReader(s.getInputStream()));//doc tu server
            BufferedWriter wri = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//gui den server

            String line= reader.readLine();
            System.out.println("\n\t\t"+line);

            int i;
            do{
                System.out.println("\n\t\t"+line);
                System.out.println("\nNhap lua chon: ");
                i=sc.nextInt();
                wri.write(i);
                wri.newLine();
                wri.flush();


                String ex=reader.readLine();
                System.out.println(ex);
                System.out.println("\n\n");

                if(i == 0){
                    System.out.println("Client đóng.");
                }
            }while(i<=3);
            s.close();
            wri.close();
            reader.close();

       } catch (Exception e) {
           //TODO: handle exception
           e.printStackTrace();
       } 
    }
    
}