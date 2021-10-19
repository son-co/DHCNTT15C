package Tuan3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileTReader implements Runnable {
    String fileName;
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public FileTReader(String fileName) {
        this.fileName = fileName;
    }
 
    public void run() {
        try {
            FileReader fr = new FileReader(new File(this.getFileName()));
            BufferedReader br = new BufferedReader(fr);
            int c;
            while((c = br.read()) != -1) {
                System.out.println(this.getFileName() + ": " + c);
            }
            br.close();
            fr.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new FileTReader("D:\\TestPT\\test1.txt"));
        Thread t2 = new Thread(new FileTReader("D:\\TestPT\\test2.txt"));
        Thread t3 = new Thread(new FileTReader("D:\\TestPT\\test3.txt"));
        
        t1.start();
        t2.start();
        t3.start();
    }
    public void start() {
    }
   
}