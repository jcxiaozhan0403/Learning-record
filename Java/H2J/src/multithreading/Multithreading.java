package multithreading;

public class Multithreading {
    private static String winner;

    public static String getWinner() {
        return winner;
    }

    public static void setWinner(String winner) {
        Multithreading.winner = winner;
    }

    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();

        new Thread(rabbit,"兔子").start();
        new Thread(tortoise,"乌龟").start();

    }
}
