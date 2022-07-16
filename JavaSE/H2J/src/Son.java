public class Son extends Parent{
    public static void main(String[] args) {
        Son parent = new Son();

        System.out.println(parent instanceof Parent);
    }
}