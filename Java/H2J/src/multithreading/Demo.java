package multithreading;

public class Demo implements Runnable{
    @Override
    public void run() {
        for(int i = 0;i<100;i++){

        }
        for(int j = 0;j<100;j++){

        }
    }

    private boolean gameOver(int i,int j) {
        if (i == 100) {
            j = 0;
            System.out.println("胜利者是" + Thread.currentThread().getName());
            return true;
        }

        if (j == 100) {
            i = 0;
            System.out.println("胜利者是" + Thread.currentThread().getName());
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(demo,"兔子").start();
        new Thread(demo,"乌龟").start();
    }
}
