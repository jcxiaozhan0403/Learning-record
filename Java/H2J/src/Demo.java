import java.io.File;
import java.lang.reflect.Array;

public class Demo{



    public static void main(String[] args) {

        File f = new File("c:/WINDOWS");


        String list[] = f.list();

        for (String i : list){


            System.out.println();
        }
    }
}