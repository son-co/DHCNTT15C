package TestBT;


import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ghifile {
 public static void main(String[] args) { 
  try {
   //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
   FileOutputStream fos = new FileOutputStream("D:/NguyenTheSon/mydata.txt");
   DataOutputStream dos = new DataOutputStream(fos);

   //Bước 2: Ghi dữ liệu
   dos.writeBytes("abcd");
   dos.writeInt(65);
   dos.flush();
//    dos.write(3);
   //Bước 3: Đóng luồng
   fos.close();
   dos.close();
   System.out.println("Done!");
  } catch (IOException ex) {
    ex.printStackTrace();
  } 
 }
} 