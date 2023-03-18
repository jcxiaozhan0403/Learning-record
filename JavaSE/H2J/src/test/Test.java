package test;

/**
 * @author John.Cena
 * @date 2023/3/17 18:03
 * @Description:
 */
public class Test implements InvocationHandler{
    public static void main(String[] args) {
        // 叫服务员
        Waiter waiter = new Waiter();
        // 可以选择套餐，省事，直接告诉服务员要套餐即可
        Product product1 = waiter.getProduct();
        System.out.println(product1);
        // 也可以自己点餐，点了哪些上哪些
        Product product2 = waiter
                .builderA("炸鸡")
                .builderB("雪碧")
                .builderC(null)
                .builderD(null)
                .getProduct();
        System.out.println(product2);


    }
}
