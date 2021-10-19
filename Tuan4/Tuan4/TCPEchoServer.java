package Tuan4;

import java.io.*;

import java.net.ServerSocket;

import java.net.Socket;

public class TCPEchoServer {

    public final static int serverPort = 7;

    public static void main(String[] args) {

        try {

            ServerSocket ss = new ServerSocket (serverPort); 
            System.out.println("Server da duoc tao"); 
            while(true){ 
                try {

                    Socket s= ss.accept();

                    OutputStream os=s.getOutputStream(); 
                    InputStream is=s.getInputStream();

                    int ch = 0;

                    while(true) {

                        ch= is.read();

                        if(ch == -1) break;

                        System.out.println((char)ch);

                        os.write(ch);

                       
                    } 
                    s.close();

                }catch (IOException iel) {

                    System.out.println("Connection Error: "+iel);
                }
            }

        }catch(IOException e) {

                System.out.println("Server Creation Error: "+e);
        }
        
    }
}