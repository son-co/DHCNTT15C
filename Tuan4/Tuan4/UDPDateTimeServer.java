
package Tuan4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDateTimeServer {
    public static void main(String[] args) throws Exception {
        //Tạo socket cho server
        DatagramSocket serverSocket = new DatagramSocket(9876);

        while (true) {
            //tạo biến nhận dữ liệu 
            byte[] receiver = new byte[1024];
            //tạo biến gửi dữ liệu
            byte[] send = new byte[2048];
            System.out.println("Server da duoc tao!");

             //tạo biến receivePacket để nhận gói tin từ socket
             DatagramPacket receivePacket = new DatagramPacket(receiver, receiver.length); 
            //nhận gói tin qua phương thức receive()
            serverSocket.receive(receivePacket);
            
            

             //Lấy địa chỉ IP của bên gửi
            InetAddress IPAddress = receivePacket.getAddress();
            //Lấy số hiệu cổng bên gửi
            int port = receivePacket.getPort(); 
            DatagramPacket sendPacket = new DatagramPacket(send, send.length, IPAddress, port);
            //Chuyển dữ liệu vừa nhận về dạng String
            String sentence = new String(receivePacket.getData()); 

            switch (sentence) {
                case "1":
                    String date= "Ngay hien tai : "+ java.time.LocalTime.now();
                    send= date.getBytes();
                    //Gửi gói tin đi
                    serverSocket.send(sendPacket);
                    break;
            
                default:
                    break;
            }

            
            

            
        }


    }
}
