/**
 * @author John.Cena
 * @date 2023/3/5 20:27
 * @Description:
 */
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
public class Test {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue =
                new SynchronousQueue<>(); // 同步队列
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()
                        +" put 1");
                // put进入一个元素
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()
                        +" put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()
                        +" put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();
        new Thread(()->{
            try {
                // 睡眠3s取出一个元素
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()
                        +" get "+blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()
                        +" get "+blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()
                        +" get "+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}
