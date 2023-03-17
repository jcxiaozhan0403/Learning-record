package test;

/**
 * @author John.Cena
 * @date 2023/3/17 18:03
 * @Description:
 */
public abstract class Kitchen {
    /**
     * 制作快餐 A
     * @param msg 快餐名称
     * @return 快餐
     */
    abstract Kitchen builderA(String msg);
    /**
     * 制作快餐 B
     * @param msg 快餐名称
     * @return 快餐
     */
    abstract Kitchen builderB(String msg);
    /**
     * 制作快餐 C
     * @param msg 快餐名称
     * @return 快餐
     */
    abstract Kitchen builderC(String msg);
    /**
     * 制作快餐 D
     * @param msg 快餐名称
     * @return 快餐
     */
    abstract Kitchen builderD(String msg);
    /**
     * 获取产品
     * @return 产品
     */
    abstract Product getProduct();
}
