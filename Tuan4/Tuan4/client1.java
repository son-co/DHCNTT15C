package Tuan4;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class client1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
         //tao moi socket client
         int port = 9876;
         DatagramSocket ClientSocket = new DatagramSocket();
         System.out.println("Đã tạo client. ");
        while(true){
         //nhap yeu cau tu nguoi dung
         DataInputStream inFromUser = new DataInputStream(System.in);
         int a;
         //dia chi may chu
         InetAddress address = InetAddress.getByName("Localhost");
         // kết nối server số port: 
         System.out.println("Đã tìm thấy máy chủ port: "+port);
         System.out.println("Nhap vao so a :");
         a = Integer.parseInt(inFromUser.readLine());
      //   do{
            System.out.println("Nhap vao so b :");
            System.out.println("1.asd || 2.bcd || 3.Exit");
            
             try{
                // System.out.println("Nhap vao so a :");
                //  a = Integer.parseInt(inFromUser.readLine()); 
                 //Khai bao mang byte de chua du lieu gui di server
                 byte outToServer1[];                
                 //chuyen kieu du lieu : int -> String
                 String s1 = String.valueOf(a);     
                 //chuyen kieu du lieu : String -> byte va dua vao mang byte da khai bao o tren
                 outToServer1 = s1.getBytes();
                 //lay kich thuoc cua mang
                 int leng1 = outToServer1.length;
                 // tao goi de gui di
                 DatagramPacket toServer1 = new DatagramPacket(outToServer1, leng1, address, port);
                 // gui goi len server
                 ClientSocket.send(toServer1);
                 // ClientSocket.send(toServer2);
                 System.out.println("Đã gửi đến máy chủ port: "+port);
                 //tao byte de nhan du lieu ve
                 byte inFromServer[];
                 inFromServer = new byte[600];
                 //kich thuoc mang nhan du lieu ve
                 leng1 = inFromServer.length;
                 System.out.println("leng1" +leng1);
                //  int x = 0;
                 DatagramPacket fromServer;
                //  DatagramPacket fromServer = new DatagramPacket(inFromServer, leng1); 
                    
                    while (true) {
                      for (int x=0; x< leng1;x++){
                        // tạo goi nhan du lieu ve
                        fromServer = new DatagramPacket(inFromServer, leng1); 
                        ClientSocket.receive(fromServer);
                        String bString = new String(fromServer.getData(),0,fromServer.getLength());
                        System.out.println("Day so:"+bString);

                        // nhan goi tra ve tu server
                        fromServer = new DatagramPacket(inFromServer, leng1); 
                        System.out.println("Máy chủ trả về: ");
                        ClientSocket.receive(fromServer);
                        //khai bao bien de chuyen tu kieu byte sang kieu String
                        String data;
                        // dua du lieu tu mang byte vao bien data, lay tu vi tri so 0.
                        data = (new String(fromServer.getData(),0,fromServer.getLength())).trim();
                        //in ket qua ra man hinh
                        System.out.println("Ket Qua :"+data);
                      }
                        
                    }
                 // ClientSocket.close();

             }catch (UnknownHostException e)
             {
                 System.out.println("Server Not Found");
                 System.exit(1);
              }
            // catch (IOException e)
            //  {
            //      System.out.println("Cannot connect to server");
            //      System.exit(1);
            //  }
      //   }while(a<3);
        }
    }
}
