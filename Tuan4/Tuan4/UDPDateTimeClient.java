package Tuan4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDateTimeClient {
    public static void main(String[] args) throws Exception {
        //Tạo socket cho client
        DatagramSocket clientSocket = new DatagramSocket(6789); 
        
        //Tạo địa chỉ IP address bỏi tên "localhost)
        InetAddress IPAddress = InetAddress.getByName("localhost"); 
        System.out.println("Client da duoc tao!");

        while (true) {
            //Tạo dữ liệu(group of bytes) cho gói tin nhận và gói tin gủi
            byte[] sendData = new byte[1024]; 
            byte[] receiveData = new byte[2048];


            String i;
            do{
                System.out.println("\n\t1.Date | 2.Time | 3. DateTime | 0.Exit\n");
                System.out.println("\nNhap lua chon cua ban: ");
                           
                //lấy dòng văn bản nhập từ bàn phím và gán cho biến sentence
                BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 
                 i = inFromUser.readLine();
           
                //tạo dữ liệu gửi với dữ liệu vừa nhập từ bàn phím
                sendData = i.getBytes();
                //Tạo gói tin để truyền đi
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876); 
                //Truyền đến server bằng phương thức send()
                clientSocket.send(sendPacket); 
                               

                 //tạo gói tin nhận
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
                //lấy biến receivePacket để nhận gói tin bằng phương thức receive()
                clientSocket.receive(receivePacket); 

                //Chuyển dữu liệu trong gói tin vừa nhận thành kiểu String và in ra
                String modified_Sentence = new String(receivePacket.getData());
                System.out.println( modified_Sentence); 


            }while(i != null);

 
        }
        
        
    }
}
