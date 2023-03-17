package test;

/**
 * @author John.Cena
 * @date 2023/3/17 18:03
 * @Description:
 */
public class Waiter extends Kitchen {
    private Product product;
    public Waiter(){
        product = new Product();
    }
    @Override
    Kitchen builderA(String msg) {
        product.setBuildA(msg);
        return this;
    }
    @Override
    Kitchen builderB(String msg) {
        product.setBuildB(msg);
        return this;
    }
    @Override
    Kitchen builderC(String msg) {
        product.setBuildC(msg);
        return this;
    }
    @Override
    Kitchen builderD(String msg) {
        product.setBuildD(msg);
        return this;
    }
    @Override
    Product getProduct() {
        return product;
    }
}
