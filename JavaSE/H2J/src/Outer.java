public class Outer{

    private String name = "xxx";
    private int age = 20;

    static class Inner{
        private String address = "上海";
        private String phone = "111";
        private static int count = 1000;

        public void show(){
            Outer outer = new Outer();

            System.out.println(outer.name);
            System.out.println(outer.age);

            System.out.println(address);
            System.out.println(phone);

            System.out.println(Inner.count);
        }
    }
}