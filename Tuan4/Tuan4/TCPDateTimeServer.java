package Tuan4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPDateTimeServer {

    public static void main(String[] args) {
        
        try {
            ServerSocket ss=new ServerSocket(9999);
            System.out.println("Server da duoc tao!");
            while (true) {
                Socket s=ss.accept();
                System.out.println("Da ket noi voi client!");
                //lấy thông tin từ client
                BufferedReader reader= new BufferedReader(new InputStreamReader(s.getInputStream()));//nhan tu client
                BufferedWriter wri = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//guiwr   client

             
                wri.write("1. Date | 2.Time | 3.DateTime | 0.Exit");
                wri.newLine();
                wri.flush();

                do{
                    int i=reader.read();
                    switch (i) {
                        case 0:
                            System.exit(0);
                            break;
                        case 1:
                            String date = "Ngay hien tai: " + java.time.LocalDate.now() + "          ";
                            wri.write(date);
                            wri.newLine();
                            wri.flush();
                            break;
                        case 2:
                            String time = "Gio hien tai: " + java.time.LocalTime.now() + "          ";
                            wri.write(time);
                            wri.newLine();
                            wri.flush();
                            break;
                        case 3:
                            String Dtime = "Ngay Gio hien tai: " + java.time.LocalDateTime.now() + "          ";
                            wri.write(Dtime);
                            wri.newLine();
                            wri.flush();
                    
                        default:
                            break;
                    }

                }while(true);

        
            }
           

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}