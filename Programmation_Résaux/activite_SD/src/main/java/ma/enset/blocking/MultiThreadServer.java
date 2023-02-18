package ma.enset.blocking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer extends Thread{
    private int clientCount;
    public static void main(String[] args) {
        new MultiThreadServer().start();
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket=new ServerSocket();
            while(true){
                Socket socket=serverSocket.accept();
                ++clientCount;
                new Conversation(socket,clientCount).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    class Conversation extends Thread{
        private Socket socket;
        int clientId;
        public Conversation(Socket socket, int clientId){
            this.socket=socket;
            this.clientId=clientId;
        }
        @Override
        public void run() {

            try {
                InputStream is = socket.getInputStream();
                InputStreamReader isr= new InputStreamReader(is);
                BufferedReader br=new BufferedReader(isr);

                OutputStream os=socket.getOutputStream();
                PrintWriter pw=new PrintWriter(os,true);
                String IP=socket.getRemoteSocketAddress().toString();
                System.out.println("new client connection "+clientId+", IP: "+IP);
                pw.println("Welcome, your ID : "+clientId);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
