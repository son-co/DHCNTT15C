package TestBT;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author giasutinhoc.vn
 */
public class Docfile {
 public static void main(String[] args) {
  try {
   //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
   FileInputStream fis = new FileInputStream("D:/NguyenTheSon/mydata.txt");
   DataInputStream dis = new DataInputStream(fis);
   BufferedReader re= new BufferedReader(new InputStreamReader(dis));
   //Bước 2: Đọc dữ liệu
   System.out.println(re.readLine()); 
//    double m = dis.readDouble();
   //Bước 3: Đóng luồng
   fis.close();
   dis.close();
   //Hiển thị nội dung đọc từ file
//    System.out.println("Số nguyên: " + n);
//    System.out.println("Số thực: " + m);
  } catch (IOException ex) {
    ex.printStackTrace();
  } 
 }
}