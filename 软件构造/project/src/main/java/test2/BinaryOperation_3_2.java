package test2;

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
        do {
            right = random.nextInt(UPPER+1);
            result = calculate(left,right);
        } while (!(checkingCalculation(result)));
        left_operand = left;
        right_operand = right;
        operator = anOperation;
        value = result;
    }

    //子类必须实现的两个方法
    abstract  boolean checkingCalculation(int anInteger);
    abstract int calculate(int left,int right);

    public boolean equals(BinaryOperation_3_2 anOperation){
        //左算子与左算子
        //右算子与右算子
        //操作符与操作符
        return  left_operand == anOperation.getLeftOperand() &
                right_operand == anOperation.getRightOperand() &
                operator == anOperation.getOperator();
    }

    //获取左算子
    public int getLeftOperand(){

        return this.left_operand;
    }

    //获取右算子
    public int getRightOperand(){
        return this.right_operand;
    }

    //获取操作符
    public int getOperator(){
        return this.operator;
    }

    //获取结果
    public int getResult(){
        return this.value;
    }

    //32+5
    //格式化1：32+5
    public String toString(){
        return "" + this.left_operand + this.operator + this.right_operand;
    }

    //格式化2：32+5=
    public String asString(){
        return "" + this.left_operand + this.operator + this.right_operand + "=";
    }

    //格式化3：32+5=37
    public String fullString(){
        return "" + this.left_operand + this.operator + this.right_operand + this.value;
    }
}

//两个子类
class AdditionOperation extends BinaryOperation_3_2{
    //构造方法，生成加法算式
    AdditionOperation(){
        generateBinaryOperation('+');
    }

    @Override
    boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER;
    }

    @Override
    int calculate(int left, int right) {
        return left + right;
    }
}

class SubstractOperation extends BinaryOperation_3_2{
    //构造方法，生成减法算式
    SubstractOperation(){
        generateBinaryOperation('-');
    }

    @Override
    boolean checkingCalculation(int anInteger) {
        return anInteger >= LOWER;
    }

    @Override
    int calculate(int left, int right) {
        return left - right;
    }
}
