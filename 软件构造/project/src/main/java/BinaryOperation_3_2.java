import java.util.Random;

/**
 * @author John.Cena
 * @date 2022/11/22 22:20
 * @Description:
 */
abstract class BinaryOperation_3_2 {
    //上界
    static  final  int UPPER = 100;
    //下界
    static  final  int LOWER = 0;
    //左右算子
    private int left_operand = 0,right_operand = 0;
    //操作符
    private char operator = '+';
    //结果
    private int value = 0;
    
    protected  void generateBinaryOperation(char anOperation){
        int left,right,result;
        Random random = new Random();
        left = random.nextInt(UPPER+1);
//        do {
//            right = random.nextInt(UPPER+1);
//            result = calculate(int left,int right);
//        } while ()
    }
}
