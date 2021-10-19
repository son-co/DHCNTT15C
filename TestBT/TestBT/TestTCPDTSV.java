package TestBT;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TestTCPDTSV {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(888);
            while (true) {
                System.out.println("Server da duoc tao");
                Socket s = ss.accept();
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                out.writeBytes("Server Date: "+(new Date().toString()));

                out.close();
                s.close();
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
