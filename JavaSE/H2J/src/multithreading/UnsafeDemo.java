package multithreading;

public class UnsafeDemo{
    public static void main(String[] args) {
        BugTicket bugTicket = new BugTicket();
        new Thread(bugTicket,"小明").start();
        new Thread(bugTicket,"小红").start();
        new Thread(bugTicket,"黄牛").start();
    }
}

class BugTicket implements Runnable {
    private int num = 10;
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void buy() throws InterruptedException {
        if (num <= 0) {
            flag = false;
            return;
        }

        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "拿走了第" + num-- + "张票");
    }
}
