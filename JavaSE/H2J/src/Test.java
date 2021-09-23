import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        // 1 创建BufferedInputStream
        FileInputStream fis = new FileInputStream("e://hello.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        // 2 读取
        int data = 0;
        while((data = bis.read()) != -1){
            System.out.println((char)data);
        }
        // 用自己创建的缓冲流
        byte[] buf = new byte[1024];
        int count = 0;
        while((count = bis.read(buf)) != -1){
            System.out.println(new String(buf, 0, count));
        }

        // 3 关闭
        bis.close();

    }
}
