package Tuan3;



public class FileWriteRead {
    public static void main(String[] args){

        FileTWrite FW=new FileTWrite("D:\\TestPT\\test4.txt");
        FW.start();
        FileTReader FR=new FileTReader("D:\\TestPT\\test4.txt");
        FR.start();
    }
}
