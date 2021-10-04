import java.util.concurrent.locks.ReentrantLock;

public class Test extends Thread{
    private int ticks = 10;

    public static void main(String[] args) {

        Test test = new Test();

        new Thread(test,"线程一").start();
        new Thread(test,"线程二").start();
        new Thread(test,"线程三").start();
    }
}