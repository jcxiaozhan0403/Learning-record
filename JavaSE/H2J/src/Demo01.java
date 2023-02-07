/**
 * @author John.Cena
 * @date 2023/2/7 10:06
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        //12A34B56C
        Printer printer = new Printer();
        //接口形式多线程启动方法，使用共享打印对象
        new Thread(new A(printer)).start();
        new Thread(new B(printer)).start();
    }
}
class Printer{
    //第index次打印，用于判断是否打印字母
    private static int index = 1;

    //打印数字，当index为3的倍数时，不仅打印数字，还要打印字母
    synchronized void print(int i) throws InterruptedException {
        //模3余0，表示3的倍数
        if(index % 3 == 0){
            //唤醒等待池中的另一个线程，并且将当前线程放入等待池
            notify();
            wait();
            //从字母线程回来后，还是需要打印当前数字的
            System.out.print(i);
            index++;
        }else {
            //index不为3的倍数，则只打印数字
            System.out.print(i);
            index++;

            if (i == 52){
                System.out.println("Z");
                System.exit(0);
            }
        }
    }
    synchronized void printChar(char a) throws InterruptedException {
        if(index % 3 == 0){
            System.out.print(a);
            index++;
            notify();
            wait();
        }
    }
}
class A implements Runnable{
    Printer p;
    public A(Printer p) {
        this.p = p;
    }

    //循环打印数字
    @Override
    public void run() {
        for (int i = 1; i <= 52; i++) {
            try {
                p.print(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class B implements Runnable{
    Printer p;

    public B(Printer p) {
        this.p = p;
    }
    //循环打印字母
    @Override
    public void run() {
        for (int i = 65; i <= 90; i++) {
            try {
                p.printChar(((char) i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
