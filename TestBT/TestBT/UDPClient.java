package TestBT;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter word: ");
            String st= sc.nextLine();

            DatagramSocket dataSocket = new DatagramSocket();
            byte[] readBuffer = new byte[1024];
            byte[] writerbuffer= null;
            
            InetAddress host= InetAddress.getByName("localhost");
            int port = 8079 ;
            writerbuffer=st.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(writerbuffer,writerbuffer.length,host,port);
            System.out.println("Sent: "+ st);
            dataSocket.send((sendPacket));

            DatagramPacket rePacket= new DatagramPacket(readBuffer, readBuffer.length);
            dataSocket.receive(rePacket);

            String line = new String(rePacket.getData());
            System.out.println("Receiver: "+line);


        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
