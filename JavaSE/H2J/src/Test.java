import java.io.*;

public class Test implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            System.out.println("我在吃饭-------------------");
        }
    }

    public static void main(String[] args) throws IOException {
        Test test = new Test();

        new Thread(test).start();

        for (int i=0; i<1000 ;i++) {
            System.out.println("我在睡觉");
        }

    }
}
