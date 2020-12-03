package url;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("等待客户连接中...");
        ss.accept();
        OutputStream os = so.getOutputStream();
        os.write("你好,客户端！",)
        System.out.println("客户已连接");

        
    }
}
