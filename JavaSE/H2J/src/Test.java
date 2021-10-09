// DCL懒汉式单例
public class Test {
    public static void main(String[] args) {
        int i = 7;
        do {
            System.out.println(--i);
            --i;
        } while (i != 0);
        System.out.println(i);
    }
}