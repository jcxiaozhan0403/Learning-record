package multithreading;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<100;i++) {
            System.out.println("这是vip线程" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i =0;i<100;i++) {
            System.out.println("线程" + i);

            if (i == 20) {
                thread.join();
            }
        }
    }
}
