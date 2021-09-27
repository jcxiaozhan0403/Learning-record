public class Test extends Thread{
    // 玩具刀和玩具枪都只有一份
    static Knife knife = new Knife();
    static Gun gun = new Gun();

    @Override
    public void run() {

        if (Thread.currentThread().getName().equals("小明")) {
            synchronized (knife) {
                System.out.println("小明得到了玩具枪");
            }
            synchronized (gun) {
                System.out.println("小明得到了玩具刀");
            }
        }else {
            synchronized (gun) {
                System.out.println("小黄得到了玩具刀");
            }
            synchronized (knife) {
                System.out.println("小明得到了玩具刀");
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

        Thread thread1 = new Thread(test,"小明");
        Thread thread2 = new Thread(test,"小黄");

        thread1.start();
        thread2.start();

    }
}

// 刀
class Knife  {

}

// 枪
class Gun {

}