import java.util.regex.Pattern;

/**
 * @author John.Cena
 * @date 2023/3/1 11:11
 * @Description:
 */
public class Person {
    interface MyInterface{
        void test();
    }

    public static void main(String[] args) {
        int x = 0;

        //erro
        MyInterface myInterface = () -> System.out.println("x=" + x);

        x = 5;
    }
}
