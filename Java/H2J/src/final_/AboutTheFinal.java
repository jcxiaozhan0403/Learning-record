package final_;

public class AboutTheFinal {
    public void method1() {
        final int i = 5;
        //i在第4行已经被赋值过了，所以这里再赋值会出现编译错误
        //i = 10;
    }

    public void method2() {
        final int i;
        i = 10; //i在第4行，只是被声明，但是没有被赋值，所以在这里可以进行第一次赋值
    }

//    public void method3(final int j) {
//        System.out.println(j);
//    }
//
//    public static void main(String[] args) {
//        new method3(5);
//    }
}
