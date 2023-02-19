package ma.enset.blocking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiThreadChatServer extends Thread{
    private List<Conversation> conversations=new ArrayList<>();
    private int clientCount;
    public static void main(String[] args) {
        new MultiThreadChatServer().start();
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket=new ServerSocket(1234);
            System.out.println("the server start ");
            while(true){
                Socket socket=serverSocket.accept();
                ++clientCount;
                Conversation conversation = new Conversation(socket, clientCount);
                conversations.add(conversation);
                conversation.start();
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
                String request;
                while((request=br.readLine())!=null){
                    //String request=br.readLine();
                    System.out.println("request IP => "+IP);
                    prodcastMessage(request,this);

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public void prodcastMessage(String message, Conversation from){
        try {
            for (Conversation conversation:conversations ) {
                if(conversation!=from) {
                    Socket socket = conversation.socket;
                    OutputStream outputStream = socket.getOutputStream();
                    PrintWriter printWriter = new PrintWriter(outputStream, true);
                    printWriter.println(message);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
