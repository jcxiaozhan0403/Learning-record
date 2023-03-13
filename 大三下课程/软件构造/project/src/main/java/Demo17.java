import java.util.Random;

/**
 * @author John.Cena
 * @date 2022/10/2 11:59
 * @Description:
 */

// 17.改变案例程序，使其可以产生最多3个数值的[0..100]的二元算式，尽可能整齐打印输出，每行5列算式
// 逻辑无误，运行时间异常
public class Demo17 {
    //保存3个数值
    //18.通过数组长度，来控制数值个数
   public static int[] values = new int[3];

    public static void main(String[] args) {
        int[][] equations = generateEquations(50, 0, 200);
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
        setValues(values,minOperandValue,maxOperandValue);
        int leftOperand = 0, rightOperand = 0, operator = 0, value = 0;
        //算式：使用一个包含四个成员的数组[leftOperand,rightOperand,operator,value]表示算式Equation
        int[] equation = new int[4];
        Random random = new Random();
        //生成操作符
        operator = random.nextInt(2);
        switch (operator){
            //加法算式
            case 0:
                do{
                    leftOperand = random.nextInt(maxOperandValue - minOperandValue + 1) + minOperandValue;
                    rightOperand = random.nextInt(maxOperandValue - minOperandValue + 1) + minOperandValue;
                    value = leftOperand + rightOperand;
                    //判断产生的答案是否在范围内
                }while (!isContains(values,value));
                break;
            //减法算式
            case 1:
                do{
                    leftOperand = random.nextInt(maxOperandValue - minOperandValue + 1) + minOperandValue;
                    rightOperand = random.nextInt(maxOperandValue - minOperandValue + 1) + minOperandValue;
                    value = leftOperand - rightOperand;
                    //判断产生的答案是否在范围内
                }while (!isContains(values,value));
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
        System.out.println("- 程序输出" + equations.length + "道加减法算式的习题 -");
        System.out.println("-------------------------------------");
        for (int i = 0; i < equations.length; i++) {
            String equation = equationFormate(equations[i]);
            System.out.println((i+1) + ":\t" + equation);
        }
    }

    /**
     * 整齐打印题目
     * @param equations
     * @param col 列数
     */
    public static void printExercise(int[][] equations,int col){
        System.out.println("-------------------------------------");
        System.out.println("- 程序输出" + equations.length + "道加减法算式的习题 -");
        System.out.println("-------------------------------------");
        for (int i = 0; i < equations.length; i++) {
            String equation = equationFormate(equations[i]);
            //打印序号
            if ((i)%col == 0){
                System.out.print(i+1 + "~" + (col+i) + ":\t");
            }
            //制表符控制题目间隔
            System.out.print(equation + "\t");
            //控制换行
            if ((i+1)%col == 0){
                System.out.print("\n");
            }
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

    /**
     * 向数组填充 3个范围内数值
     * @param values
     * @param minOperandValue
     * @param maxOperandValue
     */
    public static void setValues(int[] values,int minOperandValue,int maxOperandValue){
        Random random = new Random();
        int i = random.nextInt(1);
        int value = 0;
        for (int index = 0; index < values.length; index++) {
            int leftOperand = random.nextInt(maxOperandValue - minOperandValue + 1) + minOperandValue;
            int rightOperand = random.nextInt(maxOperandValue - minOperandValue + 1) + minOperandValue;
            if (i == 0){
                value = leftOperand + rightOperand;
            }else if (i == 1){
                value = leftOperand - rightOperand;
            }
            values[index] = value;
        }
    }

    /**
     * 判断数字是否在固定数值中
     * @param arr
     * @param value
     * @return
     */
    public static boolean isContains(int[] arr,int value){
        boolean result = false;
        String valueString = String.valueOf(value);
        for (int i = 0; i < arr.length; i++) {
            if (String.valueOf(arr[i]).equals(valueString)){
                result = true;
            }
        }
        return result;
    }
}
