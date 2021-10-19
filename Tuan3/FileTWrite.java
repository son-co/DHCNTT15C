package Tuan3;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileTWrite implements Runnable {
    private String fileName;
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public FileTWrite(String fileName) {
        this.fileName = fileName;
    }
    
    public void run() {
        try {
            FileWriter fw = new FileWriter(new File(this.getFileName()));
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0 ; i < 10; i++){
                int rand = (int) (Math.random() * 100);
                bw.write(rand + "\t");
            }
            bw.close();
            fw.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Thread t1 = new Thread(new FileTWrite("D:\\TestPT\\test1.txt"));
        Thread t2 = new Thread(new FileTWrite("D:\\TestPT\\test2.txt"));
        Thread t3 = new Thread(new FileTWrite("D:\\TestPT\\test3.txt"));
        
        t1.start();
        t2.start();
        t3.start();
        
        System.out.println("Done!");
    }

    public void start() {
    }

  
}