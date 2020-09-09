package abc;

public class FinalDemo {
    final static float PI = 3.1415926F;
    static int age = 23;
    public static void main(String[] args) {
        final int number;
        number = 123;
        age = 0;
        System.out.println("常量PI="+PI);
        System.out.println("赋值后的number="+number);
        System.out.println("int类型age="+age);
    }
}

