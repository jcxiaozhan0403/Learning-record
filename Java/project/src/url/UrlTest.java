package url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UrlTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://how2j.cn/");
        InputStream is = url.openStream();
        int n = -1;
        byte[] bs = new byte[1024];
        while ((n = is.read(bs))!= -1){
            System.out.print(new String(bs,0,n,"UTF-8"));
        }
        is.close();
    }
}
