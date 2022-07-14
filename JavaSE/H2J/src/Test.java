import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws IOException {
        // 1.创建
        Properties properties = new Properties();

        // 2.添加数据
        properties.setProperty("driver","com.mysql.jdbc.Driver");
        properties.setProperty("url","jdbc:mysql://localhost:3306/ssmbuild?useSSL=true&amp;amp;useUnicode=true&amp;amp;characterEncoding=utf8");
        properties.setProperty("username","root");
        properties.setProperty("password","lishuang001219");


        System.out.println(properties.toString());
    }
}