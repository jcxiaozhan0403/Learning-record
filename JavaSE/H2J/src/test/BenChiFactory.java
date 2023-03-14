package test;

/**
 * @author John.Cena
 * @date 2023/3/14 21:52
 * @Description:
 */
public class BenChiFactory implements CarFactory{
    @Override
    public Car getCar() {
        Car car = new BenChi();
        return car;
    }
}
