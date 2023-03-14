package test;

/**
 * @author John.Cena
 * @date 2023/3/14 22:07
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Car car1 = new BenChiFactory().getCar();
        Car car2 = new BaoMaFactory().getCar();

        car1.name();
        car2.name();
    }
}
