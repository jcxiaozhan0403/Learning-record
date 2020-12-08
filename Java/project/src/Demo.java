import com.ndktools.javamd5.Mademd5;

public class Demo {
    public static void main(String[] args) {
        Mademd5 md5 = new Mademd5();

        String pwd= "admin";

        System.out.println(md5.toMd5(pwd));
    }
}
