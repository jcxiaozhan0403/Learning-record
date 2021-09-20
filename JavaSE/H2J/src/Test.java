public class Test {
    public static void main(String[] args) {
        String xxx = Outer.Inner.XXX;
        System.out.println(xxx);


        Outer.Inner inner = new Outer().new Inner();

    }
}
