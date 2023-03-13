package test2;

import java.util.Random;

/**
 * @author John.Cena
 * @date 2022/11/22 21:40
 * @Description:
 */
public class BinaryOperation_3_1 {
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

    /**
     * 生成一个算式
     * @param left 左算子
     * @param right 右算子
     * @param op 操作符
     */
    private void construct(int left,int right, char op){
        left_operand = left;
        right_operand = right;
        operator = op;
        if (op == '+'){
            value = left + right;
        }else {
            value = left - right;
        }
    }

    /**
     * 生成加法算式
     * @return
     */
    public BinaryOperation_3_1 generateAdditionOperation(){
        Random random = new Random();
        int left,right,result;

        //生成100以内的随机数作为左算子
        left = random.nextInt(UPPER+1);

        do {
            //生成100以内的随机数作为右算子
            right = random.nextInt(UPPER+1);
            result = left + right;
            //结果大于100，重新生成
        }while (result > UPPER);

        BinaryOperation_3_1 bop = new BinaryOperation_3_1();
        bop.construct(left,right,'+');
        return bop;
    }

    /**
     * 生成减法算式
     * @return
     */
    public BinaryOperation_3_1 generateSubstractOperation(){
        Random random = new Random();
        int left,right,result;

        //生成100以内的随机数作为右算子
        left = random.nextInt(UPPER+1);
        do {
            //生成100以内的随机数作为右算子
            right = random.nextInt(UPPER+1);
            result = left - right;
            //结果小于0，重新生成
        }while (result < LOWER);

        BinaryOperation_3_1 bop = new BinaryOperation_3_1();
        bop.construct(left,right,'-');
        return bop;
    }


    /**
     * 生成随机加减二元运算算式
     * @return
     */
    public BinaryOperation_3_1 generateBinaryOperation(){
        Random random = new Random();
        int left,right,result,op;

        //随机生成操作符，0：+ 1：-
        op = random.nextInt(2);


        if (op == 0){
            //操作符为0.生成加法
            //生成100以内的随机数作为左算子
            left = random.nextInt(UPPER+1);

            do {
                //生成100以内的随机数作为右算子
                right = random.nextInt(UPPER+1);
                result = left + right;
                //结果大于100，重新生成
            }while (result > UPPER);

            BinaryOperation_3_1 bop = new BinaryOperation_3_1();
            bop.construct(left,right,'+');
            return bop;
        }else {
            //操作符为0.生成加法
            //生成100以内的随机数作为右算子
            left = random.nextInt(UPPER+1);
            do {
                //生成100以内的随机数作为右算子
                right = random.nextInt(UPPER+1);
                result = left - right;
                //结果小于0，重新生成
            }while (result < LOWER);

            BinaryOperation_3_1 bop = new BinaryOperation_3_1();
            bop.construct(left,right,'-');
            return bop;
        }
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

    //判断两个算式是否相等
    public boolean equals (BinaryOperation_3_1 anOperation){
        //左算子与左算子
        //右算子与右算子
        //操作符与操作符
        return  left_operand == anOperation.getLeftOperand() &
                right_operand == anOperation.getRightOperand() &
                operator == anOperation.getOperator();
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
