import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("e:\\测试.txt");

        int date = 0;
        while((date = fr.read()) != -1){
            System.out.print(date + " ");
        }
    }
}