public class Test implements Runnable{
    private static String winner;

    @Override
    public void run() {

        for (int i=0; i<=100; i++) {
            if (gameOver(i)) {
                break;
            }

            // 通过线程名选择对应操作
            if (Thread.currentThread().getName().equals("乌龟")) {
                // 乌龟每一米都比兔子慢9毫秒
                try {
                    Thread.sleep(9);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("乌龟跑了第" + i + "米");
            }else if (Thread.currentThread().getName().equals("兔子")) {
                // 兔子跑到第50米的时候，模拟兔子睡觉
                if (i==50) {
                    try {
                        Thread.sleep(1510);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("兔子跑了第" + i + "米");
            }
        }
    }

    // 开启乌龟和兔子两个线程
    public static void main(String[] args) {
        Test test = new Test();

        new Thread(test,"乌龟").start();
        new Thread(test,"兔子").start();
    }

    // 判断比赛是否结束
    public boolean gameOver(int distance) {
        // 冠军产生，比赛结束
        if (winner != null) {
            return true;
            //100米达成，比赛结束
        }else if (distance == 100) {
            winner = Thread.currentThread().getName();
            System.out.println("胜利者：" + winner);
            return true;
        }
        return false;
    }
}