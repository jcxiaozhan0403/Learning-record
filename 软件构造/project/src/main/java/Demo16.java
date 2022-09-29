import java.util.Random;

/**
 * @author John.Cena
 * @date 2022/9/29 11:39
 * @Description:
 */
// 16.修改程序，使其可以产生任意整数数值范围、任意个二元运算的习题
// 测试一：产生50道[0..200]的加法或减法二元运算
// 测试二：产生50道[-100..100]的加法或减法二元运算
public class Demo16 {
    public static void main(String[] args) {
        int[][] equations = generateEquations(50, -100, 100);
        printExercise(equations);
        printCalculations(equations);
    }

    /**
     * 生成算式
     * @param minOperandValue 最小操作数
     * @param maxOperandValue 最大操作数
     * @return
     */
    public static int[] generateEquation(int minOperandValue, int maxOperandValue){
        int leftOperand = 0, rightOperand = 0, operator = 0, value = 0;
        //算式：使用一个包含四个成员的数组[leftOperand,rightOperand,operator,value]表示算式Equation
        int[] equation = new int[4];

        Random random = new Random();
        //生成操作符
        operator = random.nextInt(2);
        switch (operator){
            //加法算式
            case 0:
                leftOperand = random.nextInt(maxOperandValue)%(maxOperandValue-minOperandValue+1) + minOperandValue;
                rightOperand = random.nextInt(maxOperandValue)%(maxOperandValue-minOperandValue+1) + minOperandValue;
                value = leftOperand + rightOperand;
                break;
            //减法算式
            case 1:
                leftOperand = random.nextInt(maxOperandValue)%(maxOperandValue-minOperandValue+1) + minOperandValue;
                rightOperand = random.nextInt(maxOperandValue)%(maxOperandValue-minOperandValue+1) + minOperandValue;
                value = leftOperand - rightOperand;
                break;
        }
        equation[0] = leftOperand; //左操作数
        equation[1] = rightOperand; //右操作数
        equation[2] = operator; //操作符--0:加法 1:减法
        equation[3] = value; // 计算结果
        return equation;
    }

    /**
     * 生成习题集
     * @param equationNum 习题数量
     * @param minOperandValue 最小操作数
     * @param maxOperandValue 最大操作数
     * @return
     */
    public static int[][] generateEquations(int equationNum, int minOperandValue, int maxOperandValue){
        int equation[];   // 算式     //[操作数1，操作数2，操作符，结果]
        int[][] equations = new int[equationNum][4];
        int index = 0; //目前习题中算式的个数

        for(int i = 0; i < equationNum; i++) {
            do {
                equation = generateEquation(minOperandValue, maxOperandValue); //产生一个算式
            }while(isRrepeat(equation, equations, index)); //判断算式是否出现在习题集中
            // 把算式存放在习题集中，游标加1
            equations[index++] = equation;
        }
        return equations;
    }

    /**
     * 判断两个算式是否相等
     * @param equation1：第一个算式  [操作数1，操作数2，操作符，结果]
     * @param equation2：第二个算式  [操作数1，操作数2，操作符，结果]
     * @return：如果相等，返回1；如果不相等，返回0
     */
    public static boolean isEqual(int[] equation1, int[] equation2) {
        //正向判断+反向判断
        return (equation1[0] == equation2[0] && equation1[1] == equation2[1] && equation1[2] == equation2[2])
                || (equation1[0] == equation2[1] && equation1[1] == equation2[0] && equation1[2] == equation2[2]);
    }

    /**
     * 判断算式是否重复
     * @param equation 算式
     * @param equations 算式集
     * @param index 下标
     * @return
     */
    public static boolean isRrepeat(int[] equation,int[][] equations,int index){
        //默认不重复
        boolean result = false;
        //遍历当前数组
        for(int i = 0; i < index; i++) {
            if(isEqual(equation, equations[i])) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 按格式转换算式 1+1=
     * @param equation
     * @return
     */
    public static String equationFormate(int[] equation){
        String operator = null;
        if (equation[2] == 0){
            operator = "+";
        }else if (equation[2] == 1){
            operator = "-";
        }

        return "" + equation[0] + operator + equation[1] + "=";
    }

    /**
     * 打印题目
     */
    public static void printExercise(int[][] equations){
        System.out.println("-------------------------------------");
        System.out.println("- 程序输出50道100以内的加减法算式的习题 -");
        System.out.println("- 每次运行程序可以得到一套50道题的习题及答案 -");
        System.out.println("-------------------------------------");
        for (int i = 0; i < equations.length; i++) {
            String equation = equationFormate(equations[i]);
            System.out.println((i+1) + ":\t" + equation);
        }
    }

    /**
     * 打印答案
     */
    public static void printCalculations(int[][] equations){
        System.out.println("\n-----以下是习题的答案-------");
        for(int i = 0; i < equations.length; i++) {
            System.out.println((i+1) + ":\t" + equations[i][3]);
        }
    }

    public static void OperandSymbolic(int minOperandValue, int maxOperandValue){
        //对操作数进行预处理
        if (minOperandValue < 0){
            minOperandValue = minOperandValue * -1;
        }
        if (maxOperandValue < 0){
            maxOperandValue = maxOperandValue * -1;
        }
    }
}
