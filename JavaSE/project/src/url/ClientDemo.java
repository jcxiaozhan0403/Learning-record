package url;

import java.io.IOException;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket so = new Socket("172.20.84.139",8888);
        System.out.println("连接服务器");

    }
}
