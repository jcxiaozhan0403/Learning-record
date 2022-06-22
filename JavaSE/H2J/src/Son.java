/**
 * @author John.Cena
 * @date 2022/6/22 15:24
 * @Description:
 */
public class Son implements Parent{
    @Override
    public void test() {
        System.out.println("测试");
    }
}

class Test {
    public static void main(String[] args) {
        Parent parent = new Son();
        Class class1 = parent.getClass();
        System.out.println(class1);

        Parent parent1 = new Parent() {
            @Override
            public void test() {
                Class class1 = parent.getClass();
                System.out.println(class1);
            }
        };
        parent1.test();
    }
}