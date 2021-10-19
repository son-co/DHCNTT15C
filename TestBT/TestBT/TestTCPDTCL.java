package TestBT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class TestTCPDTCL {
    public static void main(String[] args) {
        try {
            Socket s= new Socket("127.0.0.1",888);
            BufferedReader read = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println("Date: "+read.readLine());
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
