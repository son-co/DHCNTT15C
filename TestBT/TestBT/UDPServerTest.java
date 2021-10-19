package TestBT;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
public class UDPServerTest {
    
    public static void main(String args[]) throws Exception { 
        //Tạo socket phía server với số hiệu cổng 9876
        DatagramSocket serverSocket = new DatagramSocket(9876);   
        while(true) { 
            //tạo biến receiveData để nhận dữ liệu từ gói tin đến 
            byte[] receiveData = new byte[1024];
            //tạo sendData để nhận dữ liệu gửi lên gói tin đi
            byte[] sendData  = new byte[2048];
            System.out.println("Server da duoc tao!");
// 
            //tạo biến receivePacket để nhận gói tin từ socket
            DatagramPacket receivePacket = 
                    new DatagramPacket(receiveData, receiveData.length); 
            //nhận gói tin qua phương thức receive()
            serverSocket.receive(receivePacket);
           
//            
            //Lấy địa chỉ IP của bên gửi
            InetAddress IPAddress = receivePacket.getAddress();
            //Lấy số hiệu cổng bên gửi
            int port = receivePacket.getPort(); 

            
//
            //Chuyển dữ liệu vừa nhận về dạng String
            String sentence = new String(receivePacket.getData()); 
 //           
           
            //Xử lý dữ liệu vừa nhận
            String sentence_to_client = sentence+ " (server accpeted!)"; 
            
            //tạo gói tin để gửi đi client
            sendData = sentence_to_client.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            //Gửi gói tin đi
            serverSocket.send(sendPacket); 
            
        } 
        
    } 
}