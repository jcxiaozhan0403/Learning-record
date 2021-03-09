package multithreading;

public class Tortoise implements Runnable{
    @Override
    public void run() {
        // 乌龟跑100米
        for (int i = 0;i<=100;i++){
            System.out.println("乌龟跑了" + i +"米");
            if(i == 100){
                String winner = Multithreading.getWinner();
                if (winner == null) {
                    Multithreading.setWinner("乌龟");
                    System.out.println("乌龟赢了啊啊啊啊啊啊啊啊啊啊");
                    break;
                }else{
                    break;
                }
            }
        }
    }
}
