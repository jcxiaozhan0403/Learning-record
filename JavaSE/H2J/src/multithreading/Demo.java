package multithreading;

public class Demo implements Runnable{
    @Override
    public void run() {
        for(int i =0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + "抢到了第" + i + "张票");
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(demo,"小明").start();
        new Thread(demo,"小红").start();
    }

}
