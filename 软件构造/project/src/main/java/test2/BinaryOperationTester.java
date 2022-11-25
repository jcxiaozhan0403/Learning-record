package test2;

/**
 * @author John.Cena
 * @date 2022/11/23 17:00
 * @Description:
 */
public class BinaryOperationTester {
    public static void main(String[] args) {
        BinaryOperation_3_2 bop;
        for (int i=0;i<10;i++){
            bop = new AdditionOperation();
            System.out.println(bop);
        }
    }
}
