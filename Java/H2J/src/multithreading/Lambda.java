package multithreading;

public class Lambda {
    public static void main(String[] args) {
        Demo02 demo02 = new Demo02() {
            @Override
            public void test() {
                System.out.println("Hello World");
            }
        };
        demo02.test();
    }
}

interface Demo02 {
    void test();
}
