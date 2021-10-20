package Tuan4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientTinhToan {
    public static void main(String[] args) {
        try {

            Socket s= new Socket("127.0.0.1",8888);
            System.out.println("Client da duoc tao!");
            while (true) {
                
            BufferedReader reader= new BufferedReader(new InputStreamReader(s.getInputStream()));//doc tu server
            BufferedWriter wri = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//gui den server

            System.out.println("Thuc hien chuc nang: \n");
            System.out.println("\t1. Tổng 1+3+5+7+...+(2n+1)\n");
            System.out.println("\t2. Tổng 1*2 + 2*3+...+n*(n+1)\n");
            System.out.println("\t3. Biểu thức 1-2+3-4+..+(2n+1)\n");

            String i;
            
                Scanner sc= new Scanner(System.in);
                System.out.println("\n Nhap lua chon: ");
                i=sc.nextLine();
                wri.write(i);
                wri.newLine();
                wri.flush();

                String line= reader.readLine();
                System.out.println(line);

                int n=sc.nextInt();
                wri.write(n);
                wri.newLine();
                wri.flush();


                int ex=reader.read();
                System.out.println(ex);
                System.out.println("\n\n");

                
            }
            
            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}

