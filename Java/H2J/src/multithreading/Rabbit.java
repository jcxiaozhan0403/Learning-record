package multithreading;

public class Rabbit implements Runnable{
    @Override
    public void run() {
        // 兔子跑100米
        for (int i = 0;i<=100;i++){
            System.out.println("兔子跑了" + i +"米");
            if(i == 100){
                String winner = Multithreading.getWinner();
                 if (winner == null) {
                     Multithreading.setWinner("兔子");
                     System.out.println("兔子赢了啊啊啊啊啊啊啊啊啊啊");
                     break;
                 }else{
                     break;
                 }
            }
        }
    }
}
