package TestBT;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket dataSocket = new DatagramSocket(8079);
            byte[] readBuffer = new byte[1024];
            byte[] writerbuffer= null;
            System.out.println("Server da dc tao!");
            while(true){
                DatagramPacket rePacket= new DatagramPacket(readBuffer, readBuffer.length);
                dataSocket.receive(rePacket);

                String line = new String(rePacket.getData());
                System.out.println("Receiver: "+line);

                writerbuffer=line.toUpperCase().getBytes();
                InetAddress host= rePacket.getAddress();
                int port = rePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(writerbuffer,writerbuffer.length,host,port);
                System.out.println("Sent: "+ line.toUpperCase());
                dataSocket.send((sendPacket));
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
