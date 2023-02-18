package ma.enset.blocking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SampleServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(1234);
        System.out.println("i'm waiting new connetion");
        Socket socket =ss.accept();
        InputStream is=socket.getInputStream();
        OutputStream os=socket.getOutputStream();
        System.out.println("i'm waiting data");
        int nb=is.read();
        int res=nb*23;
        System.out.println("im sending response");
        os.write(res);
        socket.close();


    }
}
