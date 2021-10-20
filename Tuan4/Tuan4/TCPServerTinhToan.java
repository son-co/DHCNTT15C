package Tuan4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerTinhToan {
    public static void main(String[] args) {
        try {
            ServerSocket ss= new ServerSocket(8888);
            System.out.println("Server da duoc tao!");
            Socket s=ss.accept();
            System.out.println("Da ket noi voi client!");
            
            while (true) {

                BufferedReader reader= new BufferedReader(new InputStreamReader(s.getInputStream()));//doc tu client
                BufferedWriter wri = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//gui den client
                int tong;
                String out;
                out=reader.readLine();
                switch (out) {
                    case "0":
                        System.exit(0);
                        break;
                    case "1":
                        tong = 0;

                        wri.write("Nhap n: ");
                        wri.newLine();
                        wri.flush();

                        int n= reader.read();
                        for (int i = 0; i <=n; i++) {
                            tong += (2*i)+1;
                        }
                        wri.write(tong);
                        wri.newLine();
                        wri.flush();
                        
                        break;
                    case "2":
                        tong = 0;

                        wri.write("Nhap n: ");
                        wri.newLine();
                        wri.flush();

                        n= reader.read();
                        for (int i = 0; i <=n; i++) {
                            tong += i*(i+1);
                        }
                        wri.write(tong);
                        wri.newLine();
                        wri.flush();
                        
                        break;        
                    case "3":
                        tong = 0;

                        wri.write("Nhap n: ");
                        wri.newLine();
                        wri.flush();

                        n= reader.read();
                        for (int i = 0; i <=n; i++) {
                            tong += (-2*i)+((2*i)+1);
                        }
                        wri.write(tong);
                        wri.newLine();
                        wri.flush();
                        
                        break;
                    default:
                        break;
                }
            }          
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

    }
}
