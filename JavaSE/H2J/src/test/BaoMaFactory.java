package test;

/**
 * @author John.Cena
 * @date 2023/3/14 22:05
 * @Description:
 */
public class BaoMaFactory implements CarFactory{
    @Override
    public Car getCar() {
        Car car = new BaoMa();
        return car;
    }
}
