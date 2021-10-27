package Tuan4;
import java.net.DatagramSocket;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class sv1 {
    private static DatagramPacket sendPacket1;
 
    public static void main(String args[]) throws Exception { 
        //Tạo socket phía server với số hiệu cổng 9876
        DatagramSocket serverSocket = new DatagramSocket(9876);   
        while(true) { 
            //tạo biến receiveData để nhận dữ liệu từ gói tin đến 
            byte[] receiveData = new byte[1];
            //tạo sendData để nhận dữ liệu gửi lên gói tin đi
            byte[] sendData1 = new byte[60];

            //tạo biến receivePacket để nhận gói tin từ socket
            DatagramPacket receivePacket = 
                    new DatagramPacket(receiveData, receiveData.length); 
            //nhận gói tin qua phương thức receive()
            serverSocket.receive(receivePacket);
            //Chuyển dữ liệu vừa nhận về dạng String
            String sentence = new String(receivePacket.getData()); 
            // //Lấy địa chỉ IP của bên gửi
             InetAddress IPAddress = receivePacket.getAddress();
            // //Lấy số hiệu cổng bên gửi
             int port = receivePacket.getPort(); 
           
            //------------------------------------------------------------------------
            int a =Integer.valueOf(sentence) ; 
                   
            switch (a) {
                case 1:                    
                
                // Đọc file theo đường dẫn
                break;
                case 2:

                    String sentence_to_client1;
                //tạo gói tin để gửi đi client

                //    DatagramPacket sendPacket1;
                //  String s2 = "Gio hien tai: " + java.time.LocalTime.now() + "         " ;
                final String FILE_URL1 = "D:/TestPT/int1.txt";
                // Đọc từng dòng của file và tiến hành cộng tổng lại
                InputStream inputStream = new FileInputStream(FILE_URL1);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = "";
                 while((line = reader.readLine()) != null){
                    System.out.println("file:"+line);
                    sendData1= line.getBytes();
                    sendPacket1 = new DatagramPacket(sendData1, sendData1.length, IPAddress, port);
                    // //Gửi gói tin đi
                    serverSocket.send(sendPacket1);

                    int [] Element;
                    String [] item = line.split(" "); //tach chuoi thanh cac phan tu chuoi
                    Element = new int[item.length];
                        int sum1 = 0;
                        for(int i=0; i<item.length; i++){//doi kieu string sang int cua cac phan tu
                            Element[i] = Integer.parseInt(item[i]);
                            sum1 += Element[i];
                        //    System.out.println("n: "+n[i]);
                            
                        }
                    System.out.println("Tổng = " + sum1);
                 
                    sentence_to_client1 = sum1+ " (server accpeted!)";           
                    sendData1 = sentence_to_client1.getBytes();
                    System.out.println("sendData1:"+sendData1);
                    // sendPacket1 = new DatagramPacket(sendData1, sendData1.length, IPAddress, port);
                    System.out.println("a="+a);

                    
                    sendPacket1 = new DatagramPacket(sendData1, sendData1.length, IPAddress, port);
                    // //Gửi gói tin đi
                    serverSocket.send(sendPacket1);
                    
                }
                
                break;
                
            }
               // } while ((a < 1) || (a >= 3));
            // serverSocket.close();
        } 
    }
   
}