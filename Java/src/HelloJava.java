public class HelloJava{
        public void method1(final int j) {
        j = 5; //这个能否执行？
    }
    
    public static void main(String[] args){
        System.out.println("Hello Java");
        method1(6);
    }
}